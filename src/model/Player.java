package model;

import java.util.ArrayList;

public class Player {
    private final Team team;
    private int cardsTop = 0;
    private Card[] cards;
    public Player(Team team){
        this.team = team;
    }

    public void setCards(Card[] cards) {
        this.cards = cards;
    }

    public Card play(ArrayList<Card> floor) {
        if (floor.size() > 0) {
            Suit floorSuit = floor.get(0).getSuit();
            int selectedInd = cardsTop;
            while (selectedInd < cards.length && cards[selectedInd].getSuit() != floorSuit){
                selectedInd++;
            }
            if (selectedInd < cards.length){
                Card tmp = cards[cardsTop];
                cards[cardsTop] = cards[selectedInd];
                cards[selectedInd] = tmp;
            }
        }
        return cards[cardsTop++];
    }
}
