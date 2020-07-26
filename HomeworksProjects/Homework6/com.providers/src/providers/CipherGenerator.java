package providers;

import services.Cipherable;

public class CipherGenerator {


    // методът пресмята броя на уникалните символи в масива от символи, генерирани от
    // метода getSecretChars(seed) на обекта, рефериран с параметъра cipher,
    // връща обект от тип Result
    public static Result countDistinct(Cipherable cipher, int seed){

        char[] randomGeneratedSymbols = cipher.getSecretChars(seed);
        int uniqueSymbolsCount = 0;
        boolean unique;

        for(int i = 0; i < randomGeneratedSymbols.length; i++) {
            unique = true;
            for(int j = 0; j < randomGeneratedSymbols.length; j++){
                if(randomGeneratedSymbols[i] == randomGeneratedSymbols[j] && i != j){
                    unique = false;
                    break;
                }
            }

            if(unique){
                uniqueSymbolsCount++;
            }
        }

      return new Result(randomGeneratedSymbols, uniqueSymbolsCount);
    }
}
