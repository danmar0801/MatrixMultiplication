import java.util.Random;

// this class is desgined to create a random matrix of size kxk which is provided when the class is called
public class MatrixGenerator {
    int[][] matrix;
    // bounds to set the limits of random numbers generated
    int upperBound = 100;
    int lowerBound = 0;
    private Random random = new Random();
    //constructor to generate the random values of the matrix based on the size
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

