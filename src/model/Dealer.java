package model;

import java.util.List;

public class Dealer {
    Deck deck = new Deck();
    public void resetDeck() {
        deck.reset();
    }
    public List<Card> dealHand(){
        return deck.getCards(8);
    }

}
