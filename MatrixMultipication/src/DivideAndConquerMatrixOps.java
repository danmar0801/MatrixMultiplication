public class DivideAndConquerMatrixOps {




    public static int[][] multiply(int[][] A, int[][] B) {

        int n = A.length;
        int[][] C = new int[n][n];

        // Base case
        if (n == 1) {
            C[0][0] = A[0][0] * B[0][0];
            return C;
        }

        // Divide matrices into quadrants
        int newSize = n / 2;
        int[][] A11 = new int[newSize][newSize];
        int[][] A12 = new int[newSize][newSize];
        int[][] A21 = new int[newSize][newSize];
        int[][] A22 = new int[newSize][newSize];
        int[][] B11 = new int[newSize][newSize];
        int[][] B12 = new int[newSize][newSize];
        int[][] B21 = new int[newSize][newSize];
        int[][] B22 = new int[newSize][newSize];

        // Fill in the sub-matrices
        divide(A, A11, 0, 0);
        divide(A, A12, 0, newSize);
        divide(A, A21, newSize, 0);
        divide(A, A22, newSize, newSize);
        divide(B, B11, 0, 0);
        divide(B, B12, 0, newSize);
        divide(B, B21, newSize, 0);
        divide(B, B22, newSize, newSize);

        // Recursively multiply and add sub-matrices
        int[][] C11 = add(multiply(A11, B11), multiply(A12, B21));
        int[][] C12 = add(multiply(A11, B12), multiply(A12, B22));
        int[][] C21 = add(multiply(A21, B11), multiply(A22, B21));
        int[][] C22 = add(multiply(A21, B12), multiply(A22, B22));

        // Combine the results into the final matrix C
        combine(C, C11, 0, 0);
        combine(C, C12, 0, newSize);
        combine(C, C21, newSize, 0);
        combine(C, C22, newSize, newSize);

        return C;
    }

    public static void divide(int[][] parent, int[][] child, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < child.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) {
                child[i1][j1] = parent[i2][j2];
            }
        }
    }

    public static void combine(int[][] parent, int[][] child, int iB, int jB) {
        for (int i1 = 0, i2 = iB; i1 < child.length; i1++, i2++) {
            for (int j1 = 0, j2 = jB; j1 < child.length; j1++, j2++) {
                parent[i2][j2] = child[i1][j1];
            }
        }
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
}



