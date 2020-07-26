package com;

import cards.Card;
import cards.FaceOfCard;
import cards.SuitOfCard;

import java.util.*;

public class DeckOfCards {

    ArrayList<Card> cards; // списък от всички карти в тестето от карти
    int currentCard; // индекс на карта, която може да се тегли
    private Random generator;

    public DeckOfCards() {
        this.currentCard = 0;
        this.cards = new ArrayList<>();
        this.generator = new Random();

        for(SuitOfCard suit : SuitOfCard.values()){
            for(FaceOfCard face : FaceOfCard.values()){
                cards.add(new Card(face, suit));
            }
        }
    }

    public void shuffleCards(){
        this.currentCard = 0;
        int size = cards.size();
        int randomCardIndex;

        int[] uniqueGeneratedIndexes = new int[size]; // масив, който пази уникални случайно генерирани индекси с цел да не се повтарят смените
        boolean hasNumber;
        for(int i = 0; i < size; i++){
            while(true) {
                hasNumber = false;
                randomCardIndex = generator.nextInt(size); //generate numbers in range [0,51]

                for(int j = 0; j < i; j++){
                    if(randomCardIndex == uniqueGeneratedIndexes[j]){
                        hasNumber = true;
                        break;
                    }
                }

                if(!hasNumber){
                    break;
                }
            }
            uniqueGeneratedIndexes[i] = randomCardIndex;
            Collections.swap(cards, i, randomCardIndex);
        }
    }

    public Card[] dealFive(){
        Card[] fiveCards = new Card[5];

        for(int i = 0; i < 5; i++){
            if(this.currentCard < cards.size()){
                fiveCards[i] = this.cards.get(currentCard++);
            }
        }

        return fiveCards;
    }

    public void sortByFaceCards(){
        int size = this.cards.size();

        boolean areSwapped;
        for(int i = 0; i < size - 1; i++){
            areSwapped = false;
            for(int j = 0; j < size - 1 - i; j++){
                if(this.cards.get(j).getFace().ordinal() >= this.cards.get(j + 1).getFace().ordinal()) {
                    Collections.swap(this.cards, j, j + 1);
                    areSwapped = true;
                }
            }
            if(!areSwapped){
                break;
            }
        }

        System.out.println("Cards, sorted by face:");
        for (Card card : this.cards) {
            System.out.println(card);
        }
    }

    public void printBySuits(){
        ArrayList<Card> groupedBySuit = new ArrayList<>();

        for(SuitOfCard suit :SuitOfCard.values()){
            for (Card currentCard : this.cards) {
                if (currentCard.getSuit() == suit) {
                    groupedBySuit.add(currentCard);
                }
            }
            System.out.printf("All cards with suit %s:%n%s%n",suit.getSuit(), groupedBySuit);
            groupedBySuit.clear();
        }
    }

    public List<FaceOfCard> getDistinctFaces(){
        ArrayList<FaceOfCard> allFaces = new ArrayList<>();

        for (Card card : this.cards) {
            allFaces.add(card.getFace());
        }

        return allFaces;
    }

    @Override
    public String toString() {
        return String.format("Current card index: %d%nAll cards:%n%s", this.currentCard, this.cards);
    }

    public static void main(String[] args) {
        DeckOfCards deckOfCards = new DeckOfCards();

        System.out.println("=> Cards in deck:");
        System.out.println(deckOfCards);

        deckOfCards.shuffleCards();
        System.out.println("\n=> Cards after shuffle:");
        System.out.println(deckOfCards);

        System.out.println("\n=> Deal five cards - 3 times:");
        for(int i = 0; i < 3; i++) {
            System.out.println(Arrays.toString(deckOfCards.dealFive()));
        }

        System.out.println("\n=> Cards after sort:");
        deckOfCards.sortByFaceCards();
        System.out.println(deckOfCards);

        System.out.println("\n=> Cards, grouped by suit:");
        deckOfCards.printBySuits();

        System.out.println("\n=>Faces of cards:");
        System.out.println(deckOfCards.getDistinctFaces());
    }

}
