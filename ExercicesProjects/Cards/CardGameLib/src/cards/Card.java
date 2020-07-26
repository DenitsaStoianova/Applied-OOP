package cards;

public class Card {

    private FaceOfCard face;
    private SuitOfCard suit;

    public Card(FaceOfCard face, SuitOfCard suit) {
        setFace(face);
        setSuit(suit);
    }

    public FaceOfCard getFace() {
        return face;
    }

    public void setFace(FaceOfCard face) {
        if(face == null){
            this.face = FaceOfCard.ACE;
        } else {
            this.face = face;
        }
    }

    public SuitOfCard getSuit() {
        return suit;
    }

    public void setSuit(SuitOfCard suit) {
        if(suit == null){
            this.suit = SuitOfCard.SPADES;
        } else {
            this.suit = suit;
        }
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.face.getFace(), this.suit.getSuit());
    }
}
