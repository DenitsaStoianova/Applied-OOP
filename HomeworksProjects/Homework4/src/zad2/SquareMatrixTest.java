package zad2;

import java.util.Random;

public class SquareMatrixTest {

    public static int[][] generateRandomMatrix(){

        Random generator = new Random();

        int dimensionsOfMatrix = generator.nextInt(11) + 2;

        int[][] randomGeneratedMatrix = new int[dimensionsOfMatrix][dimensionsOfMatrix];

        for(int row = 0; row < randomGeneratedMatrix.length; row++){
            for(int col = 0; col < randomGeneratedMatrix[row].length; col++){
                randomGeneratedMatrix[row][col] = generator.nextInt(9);
            }
        }
        return randomGeneratedMatrix;
    }

    public static void main(String[] args) {

        int[][] randomGeneratedMatrix = generateRandomMatrix();

        SquareMatrix squareMatrix = new SquareMatrix(randomGeneratedMatrix);

        squareMatrix.printAll();
    }
}
