package coins;

public class MonetaryCoinTest {
    public static void main(String[] args) {

        MonetaryCoin monetaryCoin1 = new MonetaryCoin(Face.HEAD, 10);
        MonetaryCoin monetaryCoin2 = new MonetaryCoin(Face.TAIL, 20);
        MonetaryCoin monetaryCoin3 = new MonetaryCoin(Face.HEAD, 5);
        MonetaryCoin monetaryCoin4 = new MonetaryCoin(Face.TAIL, 50);

        int sum = monetaryCoin1.getValue() + monetaryCoin2.getValue() + monetaryCoin3.getValue() + monetaryCoin4.getValue();

        System.out.println("Sum of four coins: " + sum);

        System.out.println("Monetary coins info:");
        System.out.println("Coin 1: " + monetaryCoin1);
        System.out.println("Coin 2: " + monetaryCoin2);
        System.out.println("Coin 3: " + monetaryCoin3);
        System.out.println("Coin 4: " + monetaryCoin4);

        // flip first coin 10 times
        System.out.println("Flip first monetary coin 10 times:");

        for(int i = 0; i < 10; i++){
            monetaryCoin1.flip();
            System.out.println(monetaryCoin1.getFace());
        }

    }
}
