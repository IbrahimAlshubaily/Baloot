package model;

import java.util.ArrayList;
import java.util.Collections;

class Deck {
    private int top = 0;
    private final ArrayList<Card> deck = new ArrayList<>(32);
    public void reset() {
        for (Suit suit : Suit.values()){
            for (Value value : Value.values()){
                deck.add(new Card(suit, value));
            }
        }
        Collections.shuffle(deck);
    }

    public Card[] getCards(int numCards) {
        Card[] cards = new Card[numCards];
        while (numCards > 0 && top < deck.size()){
            cards[--numCards] = deck.get(top++);
        }
        return cards;
    }
}
