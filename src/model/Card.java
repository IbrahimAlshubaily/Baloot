package model;

public class Card {
    private final Suit suit;
    private final Value value;
    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public String getRepr() {
        return suit+ " "+ value;
    }

    public Suit getSuit() {
        return suit;
    }

    public int getScoreValue() {
        return value.ordinal();
    }
}
