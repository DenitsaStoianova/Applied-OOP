package cipher;

public class RouteCipher {

    // FIRST WAY

    private int key; // cipher key of route cipher - tells which route to follow to encrypt or decrypt text

    public RouteCipher(int key){
        setKey(key);
    }

    public void setKey(int key) { // set method of cipher key
        this.key = key;
    }

    public int getKey() { // get method of cipher key
        return key;
    }

    /*
     Encrypt plain text spiraling inwards starting from the top left corner in a counterclockwise direction
     in case the key is positive, or spiraling inwards starting from the bottom right corner in a counterclockwise
     direction in case the key is negative.
     */
    public String encrypt(String plainText){

        // fill plain text array with entered plain text by user
        char[] plainTextArr = fillArray(plainText.toCharArray());

        // get cols number and rows number of matrix filled with plain text
        int colsNumber = Math.abs(key);
        int rowsNumber = (int)Math.ceil((double)plainTextArr.length / colsNumber);

        // to fill with elements of matrix
        char[] cipherTextArr = new char[colsNumber * rowsNumber];

        // matrix filled sequentially with plain text
        char[][] encryptMatrix = fillEncryptedMatrix(rowsNumber, colsNumber, plainTextArr);

        if(key > 0){ // encrypt text by spiraling inwards starting from the top left corner in a counterclockwise direction
            startFromTopLeftEncrypt(encryptMatrix, 0, rowsNumber - 1, 0, colsNumber - 1, cipherTextArr, 0);
        }
        else{ // encrypt text by spiraling inwards starting from the bottom right corner in a counterclockwise direction
            startFromBottomRightEncrypt(encryptMatrix, 0, rowsNumber - 1, 0, colsNumber - 1, cipherTextArr, 0);
        }

        return new String(cipherTextArr); // return encrypted text as string
    }

    private char[] fillArray(char[] array){
        char[] resultArray;
        int resultArrayLength = 0; // length of result array with letters of plain text
        int resultArrIndex = 0; // index of result array with letters of plain text

        // count symbols of plain text ignoring symbols different from letters
        for(int index = 0; index < array.length; index++){
            if((array[index] >= 'a' && array[index] <= 'z') || (array[index] >= 'A' && array[index] <= 'Z')){
                resultArrayLength++;
            }
        }

        resultArray = new char[resultArrayLength];

        // fill result array by ignoring symbols different from letters from entered plain text
        for(int index = 0; index < array.length; index++){
            if((array[index] >= 'a' && array[index] <= 'z') || (array[index] >= 'A' && array[index] <= 'Z')){
                resultArray[resultArrIndex++] = array[index];
            }
        }

        return resultArray;
    }

    private char[][] fillEncryptedMatrix(int rowsNumber, int colsNumber, char[] plainTextArr){
        char[][] encryptMatrix = new char[rowsNumber][colsNumber];
        int plIndex = 0; // store index of plainTextArr to fill matrix with its character values

        // fill matrix sequentially with elements of plain text array
        for(int row = 0; row < rowsNumber; row++){
            for(int col = 0; col < colsNumber; col++){
                if(plIndex < plainTextArr.length) {
                    encryptMatrix[row][col] = plainTextArr[plIndex++];
                }
                else {// fill with single ‘X’ character to make a nice rectangle in matrix
                    encryptMatrix[row][col] = 'X';
                }
            }
        }
        return encryptMatrix; // return filled matrix
    }

    /*
     Method to read leftmost column and the lowest row of matrix and recursively call startFromBottomRightEncrypt method
     to read rightmost column and uppermost row of the submatrix.
     */
    private void startFromTopLeftEncrypt(char[][] matrix, int rowIndex, int rowCount, int colIndex, int colCount, char[] cipherTextArr, int symbolsCount){

        for(int row = rowIndex; row <= rowCount; row++){   // read elements from leftmost column of matrix and fill cipherTextArr
            cipherTextArr[symbolsCount++] = matrix[row][colIndex];
        }

        for(int col = colIndex + 1; col <= colCount; col++){ // read elements from the lowest row of matrix and fill cipherTextArr
            cipherTextArr[symbolsCount++] = matrix[rowCount][col];
        }

        // check if more layers need to be read and call method to read other part of matrix
        if(Math.min(colCount - colIndex, rowCount - rowIndex) > 0){
            startFromBottomRightEncrypt(matrix, rowIndex, rowCount - 1, colIndex + 1, colCount, cipherTextArr, symbolsCount);
        }
    }

    /*
    Method to read rightmost column and uppermost row of matrix and recursively call startFromTopLeftEncrypt method
    to read leftmost column and the lowest row of the submatrix.
    */
    private void startFromBottomRightEncrypt(char[][] matrix, int rowIndex, int rowCount, int colIndex, int colCount, char[] cipherTextArr, int symbolsCount){

        for(int row = rowCount; row >= rowIndex; row--){  // read elements from rightmost column of matrix and fill cipherTextArr
            cipherTextArr[symbolsCount++] = matrix[row][colCount];
        }

        for(int col = colCount - 1; col >= colIndex; col--){  // read elements from uppermost row of matrix and fill cipherTextArr
            cipherTextArr[symbolsCount++] = matrix[rowIndex][col];
        }

        // check if more layers need to be read and call method to read other part of matrix
        if(Math.min(colCount - colIndex, rowCount - rowIndex) > 0){
            startFromTopLeftEncrypt(matrix, rowIndex + 1, rowCount, colIndex, colCount - 1, cipherTextArr, symbolsCount);
        }
    }

    /*
     Decrypt cipher text spiraling inwards starting from the top left corner in a counterclockwise direction
     in case the key is positive, or spiraling inwards starting from the bottom right corner in a counterclockwise
     direction in case the key is negative.
     */
    public String decrypt(String cipherText){

        // fill cipher text array with entered cipher text by user
        char[] cipherTextArr = fillArray(cipherText.toCharArray());

        // get cols number and rows number of matrix to fill it with cipher text
        int colsNumber = Math.abs(key);
        int rowsNumber = (int)Math.ceil((double)cipherTextArr.length / colsNumber);

        // matrix filled sequentially with cipher text
        char[][] decryptMatrix = new char[rowsNumber][colsNumber];

        if(key > 0){ // encrypted: spiraling inwards starting from the top left corner in a counterclockwise direction
            fillMatrixStartedFromTopLeft(decryptMatrix, 0, rowsNumber - 1, 0, colsNumber - 1, 0, cipherTextArr);
        }
        else{ // encrypted: spiraling inwards starting from the bottom right corner in a counterclockwise direction
            fillMatrixStartedFromBottomRight(decryptMatrix, 0, rowsNumber - 1, 0, colsNumber - 1, 0, cipherTextArr);
        }

        // fill plain text array sequentially with elements of decrypted matrix
        char[] plainTextArr = fillDecryptedText(decryptMatrix, rowsNumber, colsNumber);

        return new String(plainTextArr);
    }

    // fill plain text array sequentially with elements of decrypted matrix
    private char[] fillDecryptedText(char[][] matrix, int rowsNumber, int colsNumber){

        char[] plainTextArr; // array to fill with elements of decrypted matrix
        int plIndex = 0; // index of plainTextArr
        int countX = 0; // count of single ‘X’ characters in last row of matrix

        // iterate over last row of matrix to count single ‘X’ characters
        for(int col = 0; col < colsNumber - 1; col++){
            if(matrix[rowsNumber - 1][col] == 'X' && matrix[rowsNumber - 1][col + 1] == 'X'){
                countX++;
            }
        }

        // с оставянето на един символ ‘X’ накрая винаги,
        // гарантирам, че ако текста завършва на буквата ‘X’, то тя ще бъде запазена,
        // а останалите символи, които служат за допълване на матрицата няма да бъдат добавени в декриптирания текст
        plainTextArr = new char[rowsNumber * colsNumber - countX];

        // fill plainTextArr with symbols of matrix
        for(int row = 0; row < rowsNumber; row++){
            for(int col = 0; col < colsNumber; col++){
                if(row == rowsNumber - 1 && col != colsNumber - 1 && matrix[rowsNumber - 1][col] == 'X' && matrix[rowsNumber - 1][col + 1] == 'X') {
                   continue;
                }
                plainTextArr[plIndex++] = matrix[row][col];
            }
        }

        return plainTextArr;
    }

    /*
     Method to fill leftmost column and the lowest row of matrix and recursively call startFromBottomRightEncrypt method
     to fill rightmost column and uppermost row of the submatrix.
     */
    private void fillMatrixStartedFromTopLeft(char[][] matrix, int rowIndex, int rowCount, int colIndex, int colCount, int symbolsCount, char[] cipherTextArr){

        for(int row = rowIndex; row <= rowCount; row++){ // fill leftmost column of matrix with elements of cipherTextArr
            matrix[row][colIndex] = cipherTextArr[symbolsCount++];
        }

        for(int col = colIndex + 1; col <= colCount; col++){ // fill the lowest row of matrix with elements of cipherTextArr
            matrix[rowCount][col] = cipherTextArr[symbolsCount++];
        }

        // check if more layers need to be filled and call method to fill other part of matrix
        if(Math.min(colCount - colIndex, rowCount - rowIndex) > 0){
            fillMatrixStartedFromBottomRight(matrix, rowIndex, rowCount - 1, colIndex + 1, colCount, symbolsCount, cipherTextArr);
        }
    }

    /*
    Method to fill rightmost column and uppermost row of matrix and recursively call startFromTopLeftEncrypt method
    to fill leftmost column and the lowest row of the submatrix.
    */
    private void fillMatrixStartedFromBottomRight(char[][] matrix, int rowIndex, int rowCount, int colIndex, int colCount, int symbolsCount, char[] cipherTextArr) {

        for(int row = rowCount; row >= rowIndex; row--){ // fill rightmost column of matrix with elements of cipherTextArr
            matrix[row][colCount] = cipherTextArr[symbolsCount++];
        }

        for(int col = colCount - 1; col >= colIndex; col--){ // fill uppermost row of matrix with elements of cipherTextArr
            matrix[rowIndex][col] = cipherTextArr[symbolsCount++];
        }

        // check if more layers need to be filled and call method to fill other part of matrix
        if(Math.min(colCount - colIndex, rowCount - rowIndex) > 0){
            fillMatrixStartedFromTopLeft(matrix, rowIndex + 1, rowCount, colIndex, colCount - 1, symbolsCount, cipherTextArr);
        }
    }

    @Override
    public String toString(){
        return String.format("Route Cipher key = %d", key);
    }
}

/*
public class RouteCipher{

    // SECOND WAY

    private int key;

    public RouteCipher(int key){
        setKey(key);
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }

    private void startFromTopLeftEncrypt(char[][] encryptMatrix, int rowIndex, int colIndex, int rowCount, int colCount, char[] cipherTextArr, int symbolsCount){
        int countOfSymbolsToRead = 0;
        int totalSymbolsToRead = rowCount * colCount;

        while(rowIndex < rowCount && colIndex < colCount){

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }

            for(int i = rowIndex; i < rowCount; i++){
                cipherTextArr[symbolsCount++] = encryptMatrix[i][colIndex];
                countOfSymbolsToRead++;
            }
            colIndex++;

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }

            for(int i = colIndex; i < colCount; i++){
                cipherTextArr[symbolsCount++] = encryptMatrix[rowCount - 1][i];
                countOfSymbolsToRead++;
            }
            rowCount--;

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }
            
            for (int i = rowCount - 1; i >= rowIndex; i--) {
                cipherTextArr[symbolsCount++] = encryptMatrix[i][colCount - 1];
                countOfSymbolsToRead++;
            }
            colCount--;

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }
            
            for (int i = colCount - 1; i >= colIndex; i--) {
                cipherTextArr[symbolsCount++] = encryptMatrix[rowIndex][i];
                countOfSymbolsToRead++;
            }
            rowIndex++;
        }
    }

    private void startFromBottomRightEncrypt(char[][] encryptMatrix, int rowIndex, int colIndex, int rowCount, int colCount, char[] cipherTextArr, int symbolsCount) {
        int countOfSymbolsToRead = 0;
        int totalSymbolsToRead = rowCount * colCount;

        while(rowIndex < rowCount && colIndex < colCount){

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }

            for (int i = rowCount - 1; i >= rowIndex; i--) {
                cipherTextArr[symbolsCount++] = encryptMatrix[i][colCount - 1];
                countOfSymbolsToRead++;
            }
            colCount--;

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }

            for (int i = colCount - 1; i >= colIndex; i--) {
                cipherTextArr[symbolsCount++] = encryptMatrix[rowIndex][i];
                countOfSymbolsToRead++;
            }
            rowIndex++;

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }

            for(int i = rowIndex; i < rowCount; i++){
                cipherTextArr[symbolsCount++] = encryptMatrix[i][colIndex];
                countOfSymbolsToRead++;
            }
            colIndex++;

            if(countOfSymbolsToRead == totalSymbolsToRead){
                break;
            }

            for(int i = colIndex; i < colCount; i++){
                cipherTextArr[symbolsCount++] = encryptMatrix[rowCount - 1][i];
                countOfSymbolsToRead++;
            }
            rowCount--;

        }
    }

        public String encrypt(String plainText) {
        char[] plainTextArr = fillArray(plainText.toCharArray());

        int colsNumber = Math.abs(key);
        int rowsNumber = (int)Math.ceil((double)plainTextArr.length / colsNumber);

        // to fill with elements of matrix
        char[] cipherTextArr = new char[colsNumber * rowsNumber];

        char[][] encryptMatrix = fillEncryptedMatrix(rowsNumber, colsNumber, plainTextArr);

        if(key > 0){ //  spiraling inwards starting from the top left corner in a counterclockwise direction
          startFromTopLeftEncrypt(encryptMatrix, 0, 0, rowsNumber, colsNumber, cipherTextArr, 0);
        }
        else{ //  spiraling inwards starting from the bottom right corner in a counterclockwise direction
            startFromBottomRightEncrypt(encryptMatrix, 0, 0, rowsNumber, colsNumber, cipherTextArr, 0);
        }

        return new String(cipherTextArr);
    }

    private char[] fillArray(char[] array){
        char[] resultArray;
        int resultArrayLength = 0; // length of result array with letters of plain text
        int resultArrIndex = 0; // index of result array with letters of plain text

        // count symbols of plain text ignoring symbols different from letters
        for(int index = 0; index < array.length; index++){
            if((array[index] >= 'a' && array[index] <= 'z') || (array[index] >= 'A' && array[index] <= 'Z')){
                resultArrayLength++;
            }
        }

        resultArray = new char[resultArrayLength];

        // fill result array by ignoring symbols different from letters from entered plain text
        for(int index = 0; index < array.length; index++){
            if((array[index] >= 'a' && array[index] <= 'z') || (array[index] >= 'A' && array[index] <= 'Z')){
                resultArray[resultArrIndex++] = array[index];
            }
        }

        return resultArray;
    }

    private char[][] fillEncryptedMatrix(int rowsNumber, int colsNumber, char[] plainTextArr){
        char[][] encryptMatrix = new char[rowsNumber][colsNumber];
        int plIndex = 0; // store index of plainTextArr to fill matrix with its character values

        // fill matrix sequentially with elements of plain text array
        for(int row = 0; row < rowsNumber; row++){
            for(int col = 0; col < colsNumber; col++){
                if(plIndex < plainTextArr.length) {
                    encryptMatrix[row][col] = plainTextArr[plIndex++];
                }
                else {// fill with single ‘X’ character to make a nice rectangle in matrix
                    encryptMatrix[row][col] = 'X';
                }
            }
        }
        return encryptMatrix; // return filled matrix
    }

    public String decrypt(String cipherText) {
        char[] cipherTextArr = fillArray(cipherText.toCharArray());

        int colsNumber = Math.abs(key);
        int rowsNumber = (int)Math.ceil((double)cipherTextArr.length / colsNumber);

        char[][] decryptMatrix = new char[rowsNumber][colsNumber];

        if(key > 0){ // encrypted: spiraling inwards starting from the top left corner in a counterclockwise direction
            fillStartedFromTopLef(decryptMatrix, 0, 0, rowsNumber, colsNumber, cipherTextArr, 0);
        }
        else{ // encrypted: spiraling inwards starting from the bottom right corner in a counterclockwise direction
            fillStartedFromBottomRight(decryptMatrix, 0, 0, rowsNumber, colsNumber, cipherTextArr, 0);
        }

        char[] plainTextArr = fillDecryptedText(decryptMatrix, rowsNumber, colsNumber);

        return new String(plainTextArr);
    }

       // fill plain text array sequentially with elements of decrypted matrix
    private char[] fillDecryptedText(char[][] matrix, int rowsNumber, int colsNumber){

        char[] plainTextArr; // array to fill with elements of decrypted matrix
        int plIndex = 0; // index of plainTextArr
        int countX = 0; // count of single ‘X’ characters in last row of matrix

        // iterate over last row of matrix to count single ‘X’ characters
        for(int col = 0; col < colsNumber - 1; col++){
            if(matrix[rowsNumber - 1][col] == 'X' && matrix[rowsNumber - 1][col + 1] == 'X'){
                countX++;
            }
        }

        // с оставянето на един символ ‘X’ накрая винаги,
        // гарантирам, че ако текста завършва на буквата ‘X’, то тя ще бъде запазена,
        // а останалите символи, които служат за допълване на матрицата няма да бъдат добавени в декриптирания текст
        plainTextArr = new char[rowsNumber * colsNumber - countX];

        // fill plainTextArr with symbols of matrix
        for(int row = 0; row < rowsNumber; row++){
            for(int col = 0; col < colsNumber; col++){
                if(row == rowsNumber - 1 && col != colsNumber - 1 && matrix[rowsNumber - 1][col] == 'X' && matrix[rowsNumber - 1][col + 1] == 'X') {
                   continue;
                }
                plainTextArr[plIndex++] = matrix[row][col];
            }
        }

        return plainTextArr;
    }


    private void fillStartedFromTopLef(char[][] decryptedMatrix, int rowIndex, int colIndex, int rowCount, int colCount, char[] cipherTextArr, int symbolsCount){
        int countOfSymbolsToFill = 0;
        int totalSymbolsToFill = rowCount * colCount;

        while(rowIndex < rowCount && colIndex < colCount){

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for(int i = rowIndex; i < rowCount; i++){
                decryptedMatrix[i][colIndex] = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            colIndex++;

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for(int i = colIndex; i < colCount; i++){
                decryptedMatrix[rowCount - 1][i] = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            rowCount--;

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for (int i = rowCount - 1; i >= rowIndex; i--) {
                decryptedMatrix[i][colCount - 1] = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            colCount--;

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for (int i = colCount - 1; i >= colIndex; i--) {
                decryptedMatrix[rowIndex][i]  = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            rowIndex++;
        }
    }

    private void fillStartedFromBottomRight(char[][] decryptedMatrix, int rowIndex, int colIndex, int rowCount, int colCount, char[] cipherTextArr, int symbolsCount) {
        int countOfSymbolsToFill = 0;
        int totalSymbolsToFill = rowCount * colCount;

        while(rowIndex < rowCount && colIndex < colCount){

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for (int i = rowCount - 1; i >= rowIndex; i--) {
                decryptedMatrix[i][colCount - 1] = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            colCount--;

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for (int i = colCount - 1; i >= colIndex; i--) {
                decryptedMatrix[rowIndex][i] = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            rowIndex++;

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for(int i = rowIndex; i < rowCount; i++){
                decryptedMatrix[i][colIndex] = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            colIndex++;

            if(countOfSymbolsToFill == totalSymbolsToFill){
                break;
            }

            for(int i = colIndex; i < colCount; i++){
                decryptedMatrix[rowCount - 1][i] = cipherTextArr[symbolsCount++];
                countOfSymbolsToFill++;
            }
            rowCount--;
        }
    }

    @Override
    public String toString(){
        return String.format("Route Cipher key = %d", key);
    }
}

*/