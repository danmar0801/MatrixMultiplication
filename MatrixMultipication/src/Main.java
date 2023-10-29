public class Main {
    public static void main(String[] args) {
        int[][] matrixDataA = {
                {3, 7, 11},
                {1, 2, 3},
                {5, 14, 9}
        };

        int[][] matrixDataB = {
                {13, 4, 4},
                {9, 69, 7},
                {1, 7, 22}
        };
        // init the matrix, C will hold the result of multiplying A and B
        Matrix matrixA = new Matrix(3, 3);
        Matrix matrixB = new Matrix(3, 3);
        Matrix matrixC = new Matrix(3, 3);

        // Set values for the entire matrix
        matrixA.setValues(matrixDataA);
        matrixB.setValues(matrixDataB);



        try {
            matrixC.setValues(ClassicalMatrixMultipication.multiply(matrixA.getValues(), matrixB.getValues()));

            // Print the result
            matrixC.printMatrix();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}