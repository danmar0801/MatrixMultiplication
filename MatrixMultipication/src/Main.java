public class Main {
    public static void main(String[] args) {
        int matrixSize = 2;
        // init the matrix, C will hold the result of multiplying A and B
        Matrix matrixA = new Matrix(matrixSize);
        Matrix matrixB = new Matrix(matrixSize);
        Matrix matrixC = new Matrix(matrixSize);

        // Set values for the entire matrix
        matrixA.setValues(new MatrixGenerator(matrixSize).getMatrix());
        matrixB.setValues(new MatrixGenerator(matrixSize).getMatrix());


        matrixA.printMatrix();
        matrixB.printMatrix();



        try {
            // to preform multiplication using the Classical Matrix Multiplication algorithm
            matrixC.setValues(ClassicalMatrixMultipication.multiply(matrixA.getValues(), matrixB.getValues()));
            matrixC.printMatrix();
            System.out.println("\n");
            // to preform multiplication using the Divide and Conquer Matrix Multiplication algorithm
            System.out.println("Preforming D&C OPS");
            matrixC.setValues(DivideAndConquerMatrixOps.multiply(matrixA.getValues(), matrixB.getValues()));
            matrixC.printMatrix();
            System.out.println("\n");
            // to preform multiplication using the Strassen's Matrix Multiplication algorithm
            matrixC.setValues(StrassenMatrixOps.multiply(matrixA.getValues(), matrixB.getValues()));


            // Print the result
            matrixC.printMatrix();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}