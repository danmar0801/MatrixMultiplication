public class StrassenMatrixOps {

    public static int[][] multiply(int[][] A, int[][] B) {
        int n = A.length;
        int m = nextPowerOfTwo(n);

        int[][] APrep = new int[m][m];
        int[][] BPrep = new int[m][m];

        for (int i = 0; i < n; i++) {
            System.arraycopy(A[i], 0, APrep[i], 0, n);
            System.arraycopy(B[i], 0, BPrep[i], 0, n);
        }

        int[][] CPrep = multiplySquare(APrep, BPrep);

        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(CPrep[i], 0, C[i], 0, n);
        }

        return C;
    }

    private static int[][] multiplySquare(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];

        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        int newSize = n / 2;

        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];
        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];
        int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        // Filling sub-matrices
        divide(A, A11, 0, 0);
        divide(A, A12, 0, newSize);
        divide(A, A21, newSize, 0);
        divide(A, A22, newSize, newSize);
        divide(B, B11, 0, 0);
        divide(B, B12, 0, newSize);
        divide(B, B21, newSize, 0);
        divide(B, B22, newSize, newSize);

        // Create P1 to P7 according to Strassen's formulas
        int[][] P1 = multiplySquare(add(A11, A22), add(B11, B22));
        int[][] P2 = multiplySquare(add(A21, A22), B11);
        int[][] P3 = multiplySquare(A11, subtract(B12, B22));
        int[][] P4 = multiplySquare(A22, subtract(B21, B11));
        int[][] P5 = multiplySquare(add(A11, A12), B22);
        int[][] P6 = multiplySquare(subtract(A21, A11), add(B11, B12));
        int[][] P7 = multiplySquare(subtract(A12, A22), add(B21, B22));

        int[][] C11 = add(subtract(add(P1, P4), P5), P7);
        int[][] C12 = add(P3, P5);
        int[][] C21 = add(P2, P4);
        int[][] C22 = add(subtract(add(P1, P3), P2), P6);

        // Combine the C11, C12, C21, C22 into C
        combine(C, C11, C12, C21, C22, 0, 0);

        return C;
    }

    private static int nextPowerOfTwo(int n) {
        int power = 1;
        while (power < n) {
            power *= 2;
        }
        return power;
    }

    public static int[][] add(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] + B[i][j];
            }
        }
        return C;
    }

    public static int[][] subtract(int[][] A, int[][] B) {
        int n = A.length;
        int[][] C = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = A[i][j] - B[i][j];
            }
        }
        return C;
    }
    public static void divide(int[][] parent, int[][] child, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < child.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) {
                child[i1][j1] = parent[i2][j2];
            }
        }
    }
    public static void combine(int[][] C, int[][] C11, int[][] C12, int[][] C21, int[][] C22, int row, int col) {
        int newSize = C11.length;
        for (int i = 0; i < newSize; i++) {
            for (int j = 0; j < newSize; j++) {
                C[i + row][j + col] = C11[i][j];
                C[i + row][j + newSize + col] = C12[i][j];
                C[i + row + newSize][j + col] = C21[i][j];
                C[i + row + newSize][j + newSize + col] = C22[i][j];
            }
        }
    }
}


