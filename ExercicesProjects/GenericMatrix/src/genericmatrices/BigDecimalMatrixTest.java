package genericmatrices;

import java.math.BigDecimal;

public class BigDecimalMatrixTest {
    public static void main(String[] args) {
        BigDecimal[][] matrix1 = new BigDecimal[3][3];
        BigDecimal[][] matrix2 = new BigDecimal[3][3];


        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++){
                matrix1[i][j] = BigDecimal.valueOf((i + 1.0)/(i + 5));
                matrix2[i][j] =  BigDecimal.valueOf((i + 2.0)/(i + 6));
            }
        }

        BigDecimalMatrix rationalMatrix = new BigDecimalMatrix();
        System.out.println("Sum of two matrices is:");
        // cannot be cast to Integer[][] -> class cast exception
        Object[][] sumMatrices = rationalMatrix.addMatrix(matrix1, matrix2);
        //GenericMatrix.printResult(matrix1, matrix2, sumMatrices, '+');

        System.out.println("Multiplication of two matrices is:");
        Object[][] multMatrices = rationalMatrix.multiplyMatrix(matrix1, matrix2);
        //GenericMatrix.printResult(matrix1, matrix2, multMatrices, '*');
    }
}
