package zad2;

public class SquareMatrix {

    // FIRST WAY

    private int[][] dataArray;

    public SquareMatrix(int[][] matrix){
        setDataArray(matrix);
    }

    public SquareMatrix(){
        this(new int[0][0]);
    }

    public SquareMatrix(SquareMatrix matrix){
        this(matrix.dataArray);
    }

    public int[][] getDataArray() { // make deep copy of dataArray
        int[][] copyDataArray = new int[dataArray.length][dataArray.length];

        for(int row = 0; row < copyDataArray.length; row++){
            for(int col = 0; col < copyDataArray[row].length; col++){
                copyDataArray[row][col] = this.dataArray[row][col];
            }
        }
        return copyDataArray;
    }

    public void setDataArray(int[][] dataArray) { // make deep copy of dataArray
        if(dataArray != null) {
            this.dataArray = new int[dataArray.length][dataArray.length];

            for (int row = 0; row < dataArray.length; row++) {
                for (int col = 0; col < dataArray[row].length; col++) {
                    this.dataArray[row][col] = dataArray[row][col];
                }
            }
        }
        else{
            this.dataArray = new int[0][0];
        }
    }

    // find sum of every submatrix in dataArray and find maximum sum of all submatrices
    public int findMaxSum(){
        int maxSum = 0;

        for(int row = 0; row < dataArray.length - 1; row++){
            for(int col = 0; col < dataArray[row].length - 1; col++){
                // calculate sum of current 2x2 submatrix of dataArray
                int sum = dataArray[row][col] + dataArray[row][col + 1] +
                        dataArray[row + 1][col] + dataArray[row + 1][col + 1];
                // check if current sum is greater from already calculated maximum sum
                if(sum > maxSum){
                    maxSum = sum;
                }
            }
        }

        return maxSum;
    }

    public void printAll(){

        int maxSum = findMaxSum();

        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Submatrices with Maximum sum:");

        for(int row = 0; row < dataArray.length - 1; row++){
            for(int col = 0; col < dataArray[row].length - 1; col++){

                int sum = dataArray[row][col] + dataArray[row][col + 1] +
                        dataArray[row + 1][col] + dataArray[row + 1][col + 1];

                if(sum == maxSum){
                    System.out.printf("[%d, %d]\n", row, col);
                }
            }
        }
    }

    @Override
    public String toString() {
        String textDataArray = "";

        for(int row = 0; row < dataArray.length; row++){
            for(int col = 0; col < dataArray[row].length; col++){
                textDataArray += String.format("%d ",dataArray[row][col]);
            }
            textDataArray += "\n";
        }

        return textDataArray;
    }
}
/*
import java.util.ArrayList;

public class SquareMatrix {

    // SECOND WAY

    private int[][] dataArray;

    public SquareMatrix(int[][] matrix) {
        setDataArray(matrix);
    }

    public SquareMatrix(){
        this(new int[0][0]);
    }

    public SquareMatrix(SquareMatrix matrix){
        this(matrix.dataArray);
    }

    public int[][] getDataArray() { // make deep copy of dataArray
        int[][] copyDataArray = new int[dataArray.length][dataArray.length];

        for(int row = 0; row < copyDataArray.length; row++){
            for(int col = 0; col < copyDataArray[row].length; col++){
                copyDataArray[row][col] = this.dataArray[row][col];
            }
        }
        return copyDataArray;
    }

    public void setDataArray(int[][] dataArray) { // make deep copy of dataArray
        if(dataArray != null) {
            this.dataArray = new int[dataArray.length][dataArray.length];

            for (int row = 0; row < dataArray.length; row++) {
                for (int col = 0; col < dataArray[row].length; col++) {
                    this.dataArray[row][col] = dataArray[row][col];
                }
            }
        }
        else{
            this.dataArray = new int[0][0];
        }
    }

    public int findMaxSum(){
        ArrayList<Integer> maxSumList = findMaxSumFromMatrix(); // first element of array is maximum sum
        return maxSumList.get(0); // get maximum sum
    }

    private ArrayList<Integer> findMaxSumFromMatrix(){
        // ArrayList to keep max sum of 2x2 submatrices and their upper left row index and their upper left col index
       ArrayList<Integer> maxSumIndexes = new ArrayList<>();
       maxSumIndexes.add(0); // add value 0 for maximum sum
       int sum; // sum of current 2x2 submatrix

        for(int row = 0; row < dataArray.length - 1; row++){
            for(int col = 0; col < dataArray[row].length - 1; col++){
                // calculate sum of current 2x2 submatrix of dataArray
                sum = dataArray[row][col] + dataArray[row][col + 1] +
                        dataArray[row + 1][col] + dataArray[row + 1][col + 1];
                // check if current sum is greater from already calculated maximum sum, whisc is first element of maxSumIndexes
                if(sum > maxSumIndexes.get(0)){
                    // clear all data in maxSumIndexes if find greater sum from current maximum sum in array
                    maxSumIndexes.clear();
                    // add maximum sum and indexes of submatrix
                    maxSumIndexes.add(sum);
                    maxSumIndexes.add(row);
                    maxSumIndexes.add(col);
                }
                else if (sum == maxSumIndexes.get(0)){
                    maxSumIndexes.add(row);
                    maxSumIndexes.add(col);
                }
            }
        }

        return maxSumIndexes;
    }

    public void printAll(){

        ArrayList<Integer> maxSumIndexes = findMaxSumFromMatrix();
        int indexToGet = 1;

        System.out.println("Maximum sum: " + maxSumIndexes.get(0));
        System.out.println("Submatrices with Maximum sum:");

        while(indexToGet <= maxSumIndexes.size() - 1){
            System.out.printf("[%d, %d]\n", maxSumIndexes.get(indexToGet++), maxSumIndexes.get(indexToGet++));
        }
    }

    @Override
    public String toString() {
        String textDataArray = "";

        for(int row = 0; row < dataArray.length; row++){
            for(int col = 0; col < dataArray[row].length; col++){
                textDataArray += String.format("%d ",dataArray[row][col]);
            }
            textDataArray += "\n";
        }

        return textDataArray;
    }
}
 */
