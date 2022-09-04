package model;

public class Dealer {
    Deck deck = new Deck();

    public void resetDeck() {
        deck.reset();
    }

    public Card[] dealHand(){
        return deck.getCards(8);
    }

}
