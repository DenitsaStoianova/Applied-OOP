package cards;

public enum SuitOfCard {

    CLUBS("Clubs"), DIAMONDS("Diamonds"), HEARTS("Hearts"),
    SPADES("Spades");

    private final String suit;

    private SuitOfCard(String suit){
        if(suit == null){
            this.suit = "Spades";
        } else{
            this.suit = suit;
        }
    }

    public String getSuit(){
        return this.suit;
    }
}
