public class Main {
    public static void main(String[] args) {
        int[][] matrixA = {
                {3, 7, 11},
                {1, 2, 3},
                {5, 14, 9}
        };

        int[][] matrixB = {
                {13, 4, 4},
                {9, 69, 7},
                {1, 7, 22}
        };

        int[][] result;

        try {
            result = ClassicalMatrixMultipication.multiply(matrixA, matrixB);

            // Print the result
            for (int i = 0; i < result.length; i++) {
                for (int j = 0; j < result[0].length; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}