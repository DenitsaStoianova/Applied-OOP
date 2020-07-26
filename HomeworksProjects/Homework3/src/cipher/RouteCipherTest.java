package cipher;

import java.util.Scanner;

public class RouteCipherTest {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int cipherKey; // cipher key of route cipher - tells which route to follow when reading the cipher text from the block
        int userChoice; // user choice to encrypt or decrypt text
        String text; // text entered by user for encrypt or decrypt

        do {
            System.out.print("Enter 1 for encrypt or 2 for decrypt: ");
            userChoice = input.nextInt();
        } while(userChoice < 1 || userChoice > 2);
        input.nextLine();

        System.out.print("Enter text: ");
        text = input.nextLine();  // read text for encrypt or decrypt

        System.out.print("Enter cipher key: ");
        cipherKey = input.nextInt(); // read route cipher key

        RouteCipher cipher = new RouteCipher(cipherKey);

        if(userChoice == 1) { // encrypt entered text from user using method of RouteCipher class
            System.out.println("Encrypted text: " + cipher.encrypt(text));
        }
        else { // decrypt entered text from user using method of RouteCipher class
            System.out.println("Decrypted text: " + cipher.decrypt(text));
        }

        // test with given examples
        System.out.println("\nTest:");

        cipher.setKey(5);
        System.out.println("Encrypted text: " + cipher.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED"));
        System.out.println("Decrypted text: " + cipher.decrypt("ATSYVNTEDXXTEANITROBHSOESPOEHOMEIUB"));

        cipher.setKey(-5);
        System.out.println("Encrypted text: " + cipher.encrypt("ABORT THE MISSION, YOU HAVE BEEN SPOTTED"));
        System.out.println("Decrypted text: " + cipher.decrypt("XTEANITROBATSYVNTEDXOEHOMEHSOESPBUI"));

        cipher.setKey(4);
        System.out.println("Encrypted text: " + cipher.encrypt("THISISTHEPLAINTEXT"));
        System.out.println("Decrypted text: " + cipher.decrypt("TIEIXTXXEAHSIHSPNTLT"));

        cipher.setKey(-4);
        System.out.println("Encrypted text: " + cipher.encrypt("THISISTHEPLAINTEXT"));
        System.out.println("Decrypted text: " + cipher.decrypt("XEAHSIHTIEIXTXTLTSPN"));

    }
}
