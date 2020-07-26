package zad1;

import java.util.Scanner;

public class HammingDistance {

     /*
      count bits that are different at same position in a binary representation of two 8-bit
      numbers entered by user
     */
    public static int calculateHammingDistance(byte firstNumber, byte secondNumber){

        // use xor operation to generate number which represent bits that are different in both numbers
        // if two bits are different xor gives 1
        // if two bits are equal xor gives 0
        int differentBitsNumber = firstNumber ^ secondNumber;

        // count different number of bits in differentBitsNumber
        int countOfDifferentBits = 0;

        // check whether rightmost bit of number is set or not in every iteration
        while(differentBitsNumber != 0){

            int checkBits = differentBitsNumber & 1; // gives 1 if rightmost bit of number is set
            countOfDifferentBits += checkBits; // if rightmost bit of number is set => increment counter

            // right shift differentBitsNumber by 1 => second last bit goes at rightmost position
            differentBitsNumber >>= 1;
        }

        return countOfDifferentBits; // return count of different bits between two numbers
    }

    // find binary representation of entered number
    public static String findBinaryRepresentation(byte number) {
        // char array for binary representation of number
        char[] binaryRepresentationArr = new char[8];

        for(int bit = 0; bit < 8; bit++){
            binaryRepresentationArr[7 - bit] = ((number >> bit) & 1) > 0 ? '1' : '0';
        }
        // return binary representation as string
        return new String(binaryRepresentationArr);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        byte firstNumber = input.nextByte();

        System.out.print("Enter second number: ");
        byte secondNumber = input.nextByte();

        System.out.println("Binary representation of first number: " + findBinaryRepresentation(firstNumber));

        System.out.println("Binary representation of second number: " + findBinaryRepresentation(secondNumber));

        int hammingDistance = calculateHammingDistance(firstNumber, secondNumber);
        System.out.printf("Hamming distance between %d and %d is: %d\n", firstNumber, secondNumber, hammingDistance);

    }
}
