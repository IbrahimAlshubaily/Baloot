package model;

import java.util.ArrayList;

public class Dealer {
    Deck deck = new Deck();

    public void resetDeck() {
        deck.reset();
    }

    public ArrayList<Card> dealHand(){
        return deck.getCards(8);
    }

}
