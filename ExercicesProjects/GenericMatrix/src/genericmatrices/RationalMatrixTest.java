package genericmatrices;

public class RationalMatrixTest {
    public static void main(String[] args) {
        Rational[][] matrix1 = new Rational[3][3];
        Rational[][] matrix2 = new Rational[3][3];

        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++){
                matrix1[i][j] = new Rational(i + 1, j + 5);
                matrix2[i][j] = new Rational(i + 6, j + 3);
            }
        }

        RationalMatrix rationalMatrix = new RationalMatrix();

        System.out.println("Sum of two matrices is:");
        Object[][] sumMatrices = rationalMatrix.addMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, sumMatrices, '+');

        System.out.println("Multiplication of two matrices is:");
        Object[][] multMatrices = rationalMatrix.multiplyMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, multMatrices, '*');
    }
}
