package genericmatrices;

public abstract class GenericMatrix <E> implements CanCompute<E> {

    public E[][] addMatrix(E[][] matrix1, E[][] matrix2){
        if(matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length){
            throw new RuntimeException("Matrices must have equal size!"); // unchecked exception
        }

        // generic type
        E[][] result = (E[][])new Object[matrix1.length][matrix1[0].length];

        for(int i = 0; i < matrix1.length; i++){
            for(int j = 0; j < matrix1[0].length; j++){
                result[i][j] = add(matrix1[i][j], matrix2[i][j]);
            }
        }

        return result;
    }

    public E[][] multiplyMatrix(E[][] matrix1, E[][] matrix2) {
        if(matrix1.length != matrix2.length){
            throw new RuntimeException("Matrices must have equal size!");
        }

        E[][] result = (E[][])new Object[matrix1.length][matrix1[0].length];

        for(int i = 0; i < matrix1.length; i++){ // rows
            for(int j = 0; j < matrix2[0].length; j++){
                result[i][j] = zero();

                for(int k = 0; k < matrix1[0].length; k++){
                    result[i][j] = add(result[i][j], multiply(matrix1[i][k], matrix2[k][j]));
                }
            }
        }

        return result;
    }

    // if type is E[][] => unchecked cast exception
    public static void printResult(Object[][] matrix1, Object[][] matrix2, Object[][] result, char op){
        for(int i = 0; i < matrix1.length; i++){
            printRow(matrix1, i);
            printOp(matrix1, op, i);
            printRow(matrix2, i);
            printOp(matrix1, '=', i);
            printRow(result, i);
            System.out.println();
        }
    }

    private static void printRow(Object[][] matrix, int rowIndex){
        for(int j = 0; j < matrix.length; j++){
            System.out.print(" " + matrix[rowIndex][j]);
        }
    }


    private static void printOp(Object[][] matrix, char op, int rowIndex){
        if(rowIndex == matrix.length / 2){
            System.out.print("  " + op + " ");
        } else{
            System.out.print("    ");
        }
    }

}
