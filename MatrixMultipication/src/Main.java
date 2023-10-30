public class Main {
    public static void main(String[] args) {
        for (int k = 1; k <= 10; k++) {
            int matrixSize = (int) Math.pow(2, k);
            System.out.println("Testing for matrix size: " + matrixSize);
            System.out.println("Testing for K values: " + k);

            // Generate matrices
            int[][] valuesA = new MatrixGenerator(matrixSize).getMatrix();
            int[][] valuesB = new MatrixGenerator(matrixSize).getMatrix();

            // Create Matrix objects
            Matrix matrixA = new Matrix(matrixSize);
            Matrix matrixB = new Matrix(matrixSize);
            Matrix matrixC = new Matrix(matrixSize);

            // Set Matrix values
            matrixA.setValues(valuesA);
            matrixB.setValues(valuesB);



            // Run tests
            new MatrixTestSimulator("Classical", matrixA, matrixB, matrixC).runSimulation();
            new MatrixTestSimulator("DivideAndConquer", matrixA, matrixB, matrixC).runSimulation();
            new MatrixTestSimulator("Strassen", matrixA, matrixB, matrixC).runSimulation();

            System.out.println("----------------------------------");
        }

    }

}