
public class MatrixTestSimulator {
    String algoName;
    Matrix matrixA;
    Matrix matrixB;
    Matrix matrixC;
    long[] runtimes = new long[10];
    long average;

    public MatrixTestSimulator(String algoName, Matrix matrixA, Matrix matrixB, Matrix matrixC){
        this.matrixA = matrixA;
        this.matrixB = matrixB;
        this.matrixC = matrixC;
        this.algoName = algoName;
        for (int i = 0; i < 10; i++) {
            long startTime = System.nanoTime();
            switch (algoName) {
                case "Classical":
                    matrixC.setValues(ClassicalMatrixMultipication.multiply(matrixA.getValues(), matrixB.getValues()));
                    break;
                case "DivideAndConquer":
                    matrixC.setValues(DivideAndConquerMatrixOps.multiply(matrixA.getValues(), matrixB.getValues()));
                    break;
                case "Strassen":
                    matrixC.setValues(StrassenMatrixOps.multiply(matrixA.getValues(), matrixB.getValues()));
                    break;
            }
            long endTime = System.nanoTime();
            runtimes[i] = endTime - startTime;
        }
        // Sort and discard fastest and slowest times
        java.util.Arrays.sort(runtimes);

        long sum = 0;
        for (int i = 1; i < 9; i++) {
            sum += runtimes[i];
        }

        average = sum / 8;

    }

    public long runSimulation(){
        System.out.println(algoName + " average time: " + average + " nanoseconds");
        return average;

    }
}
