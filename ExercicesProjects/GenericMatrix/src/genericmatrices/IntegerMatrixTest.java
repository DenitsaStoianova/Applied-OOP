package genericmatrices;

public class IntegerMatrixTest {
    public static void main(String[] args) {

        Integer[][] matrix1 = new Integer[][]{{1,2,3},{4,5,6},{7,8,9}};
        Integer[][] matrix2 = new Integer[][]{{9,8,7},{6,5,4},{3,2,1}};

        IntegerMatrix integerMatrix = new IntegerMatrix();

        System.out.println("Sum of two matrices is:");
        Object[][] resultSum = integerMatrix.addMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, resultSum, '+');

        System.out.println("Multiplication of two matrices is:");
        Object[][] resultMultiplication = integerMatrix.multiplyMatrix(matrix1, matrix2);
        GenericMatrix.printResult(matrix1, matrix2, resultMultiplication,'*');
    }
}
