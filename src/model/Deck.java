package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Deck {
    private ArrayList<Card> deck;
    public void reset() {
        deck = new ArrayList<>();
        for (Suit suit : Suit.values()){
            for (Value value : Value.values()){
                deck.add(new Card(suit, value));
            }
        }
        Collections.shuffle(deck);
    }

    public List<Card> getCards(int numCards) {
        List<Card> cards = deck.stream().limit(numCards).collect(Collectors.toList());
        deck.removeAll(cards);
        return cards;
    }
}
