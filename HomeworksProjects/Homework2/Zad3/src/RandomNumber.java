import java.text.NumberFormat;
import java.util.Random;

public class RandomNumber {

    // generate random integers from within [1,3] with appropriate probability for each number
    public static int drawRandomNumber(Random rand){

        // generate random number
        int randNumber = rand.nextInt(100);

        if(randNumber <= 20){
            return  1;
        }
        else if(randNumber <= 50){
            return 2;
        }
        return 3;
    }

    public static void testRandomNumber(Random rand, int allPossible){

        // count frequencies of numbers
        int countNumber1 = 0;
        int countNumber2 = 0;
        int countNumber3 = 0;

        for(int i = 0; i < allPossible; i++){

            int number = drawRandomNumber(rand);

            switch (number){
                case 1: countNumber1++; break;
                case 2: countNumber2++; break;
                case 3: countNumber3++; break;
            }
        }

        calculateAndDisplayProbabilities(allPossible, countNumber1, countNumber2, countNumber3);
    }

    public static void calculateAndDisplayProbabilities(int allPossible, int countNumber1, int countNumber2, int countNumber3){

        // calculate probability for each number
        double probabilityOfNumber1 = (double)countNumber1 / allPossible;
        double probabilityOfNumber2 = (double)countNumber2 / allPossible;
        double probabilityOfNumber3 = (double)countNumber3 / allPossible;

        // to format probabilities as percentages
        NumberFormat numberFormat = NumberFormat.getPercentInstance();

        // display formatted probabilities
        System.out.println("P(1) = " + numberFormat.format(probabilityOfNumber1));
        System.out.println("P(2) = " + numberFormat.format(probabilityOfNumber2));
        System.out.println("P(3) = " + numberFormat.format(probabilityOfNumber3));
    }

    public static void main(String[] args) {

        Random rand = new Random();

        // test method drawRandomNumber() 10 000 times in a loop
        System.out.println("Calculated probabilities for 10 000 numbers:");
        testRandomNumber(rand, 10_000);

        // test method drawRandomNumber() 60 000 times in a loop
        System.out.println("Calculated probabilities for 60 000 numbers:");
        testRandomNumber(rand, 60_000);

    }
}
