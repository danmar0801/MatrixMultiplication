public class Matrix {
    private int[][] data;
    private int rows;
    private int cols;

    // Constructor
    public Matrix(int size) {
        if ((size & (size - 1)) != 0 || size <= 0) {
            throw new IllegalArgumentException("Matrix size must be a positive power of 2.");
        }
        this.rows = size;
        this.cols = size;
        this.data = new int[size][size];
    }

    // Set values for the entire matrix
    public void setValues(int[][] newData) {
        if (newData.length != rows || newData[0].length != cols) {
            System.out.println("Invalid matrix dimensions");
            return;
        }

        for (int i = 0; i < rows; i++) {
            System.arraycopy(newData[i], 0, data[i], 0, cols);
        }
    }

    // Get values for the entire matrix
    public int[][] getValues() {
        int[][] result = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            System.arraycopy(data[i], 0, result[i], 0, cols);
        }
        return result;
    }

    // Print the matrix
    public void printMatrix() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}