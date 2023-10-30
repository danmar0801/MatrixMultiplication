import java.util.Random;

public class MatrixGenerator {
    int[][] matrix;
    private Random random = new Random();
    public MatrixGenerator(int k) {
        this.matrix = new int[k][k];

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                matrix[i][j] = random.nextInt(100); // Random integer between 0 and 99
            }
        }
    }
    public int[][] getMatrix(){
        return matrix;
    }

}

