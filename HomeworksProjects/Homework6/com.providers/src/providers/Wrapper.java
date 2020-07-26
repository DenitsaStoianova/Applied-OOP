package providers;

import services.Cipherable;

import java.util.Random;

public class Wrapper {

    // задава дължината на извеждания масив от символи
    private int size;

    public Wrapper(int size) {
        setSize(size);
    }

    private class FixedRandom implements Cipherable {
        // генерира една и съща последователност от произволно избрани
        // символи в интервала A-Z за всяка конкретна стойност на аргумента seed
        @Override
        public char[] getSecretChars(int seed) {
            Random generator = new Random(seed);
            char[] randomSymbols = new char[size];

            for(int i = 0; i < randomSymbols.length; i++){
                randomSymbols[i] = (char)(generator.nextInt(26) + 65);
            }

            return randomSymbols;
        }
    }

    private class FixedSelection implements Cipherable{
        // генерира произволна последователност от seed произволно избрани символи в интервала A-Z
        @Override
        public char[] getSecretChars(int seed) {
            Random generator = new Random();
            int randomIndex; // случаен индекс за попълване на масива randomSymbolsResult

            char[] randomSymbolsResult = new char[size];

            // масив, който ще съхранява seed на брой случайно генерирани символи
            char[] randomGeneratedSymbols = new char[seed];

            for(int i = 0; i < randomGeneratedSymbols.length; i++){
                randomGeneratedSymbols[i] = (char)(generator.nextInt(26) + 65);
            }

            // попълване на масива randomSymbolsResult със случайно генериран индекс,
            // като се вземе стойността на масива randomGeneratedSymbols в този индекс
            // по този начин се формира произволна последователност от символите
            for(int i = 0; i < randomSymbolsResult.length; i++){
                randomIndex = generator.nextInt(seed);
                randomSymbolsResult[i] = randomGeneratedSymbols[randomIndex];
            }

            return randomSymbolsResult;
        }
    }

    // метод, който връща тип Cipherable със съдържание обект от клас FixedRandom
    public Cipherable makeFixedSelection(){
        return new FixedRandom();
    }

    // е метод, който връща тип Cipherable със съдържание обект от клас FixedSelection
    public Cipherable makeFixedRandom(){
        return new FixedSelection();
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size < 0){
            this.size = 0;
        } else {
            this.size = size;
        }
    }
}
