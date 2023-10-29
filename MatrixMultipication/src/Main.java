public class Main {
    public static void main(String[] args) {
        int matrixSize = 4;
        int[][] matrixDataA = {
                {1, 37, 76, 19},
                {99, 3, 50, 42},
                {65, 29, 17, 510},
                {123, 83, 47, 82}
        };

        int[][] matrixDataB = {
                {8, 98, 5, 14},
                {91, 25, 74, 24},
                {34, 11, 3, 56},
                {2, 33, 13, 0}
        };
        // init the matrix, C will hold the result of multiplying A and B
        Matrix matrixA = new Matrix(matrixSize, matrixSize);
        Matrix matrixB = new Matrix(matrixSize, matrixSize);
        Matrix matrixC = new Matrix(matrixSize, matrixSize);

        // Set values for the entire matrix
        matrixA.setValues(matrixDataA);
        matrixB.setValues(matrixDataB);



        try {
            // to preform multiplication using the Classical Matrix Multiplication algorithm
            //matrixC.setValues(ClassicalMatrixMultipication.multiply(matrixA.getValues(), matrixB.getValues()));
            // to preform multiplication using the Divide and Conquer Matrix Multiplication algorithm
            //matrixC.setValues(DivideAndConquerMatrixOps.multiply(matrixA.getValues(), matrixB.getValues()));
            // to preform multiplication using the Strassen's Matrix Multiplication algorithm
            matrixC.setValues(StrassenMatrixOps.multiply(matrixA.getValues(), matrixB.getValues()));


            // Print the result
            matrixC.printMatrix();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}