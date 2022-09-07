package model;

import java.util.*;
import java.util.stream.Collectors;

public class Player {
    private static final Comparator<Card> COMPARATOR = Comparator.comparing(Card::getAscendingRank);
    private final int id;
    private final Team team;
    private List<Card> cards;

    public Player(Team team, int id){
        this.id = id;
        this.team = team;
    }
    public void setCards(List<Card> cards) { this.cards = cards; }
    public int getId() { return id; }
    public Team getTeam() { return team; }

    public Card play(ArrayList<Card> floor) {
        Card selectedCard = selectCard(floor);
        cards.remove(selectedCard);
        return selectedCard;
    }

    private Card selectCard(ArrayList<Card> floor) {
        Card selectedCard;
        if (floor.size() == 0){
            selectedCard = Collections.max(cards, COMPARATOR);

        } else if (hasMatchingCards(floor.get(0).getSuit())) {
            Suit firstCardSuit = floor.get(0).getSuit();
            List<Card> validCards = cards.stream()
                    .filter(card -> card.getSuit() == firstCardSuit)
                    .collect(Collectors.toList());

            selectedCard = Collections.max(validCards, COMPARATOR);
            Card maxPlacedCard = floor.stream().filter(card -> card.getSuit() == firstCardSuit).max(COMPARATOR).get();
            if (selectedCard.getAscendingRank() < maxPlacedCard.getAscendingRank()) {
                selectedCard = Collections.min(validCards, COMPARATOR);
            }

        }else {
            selectedCard = Collections.min(cards, COMPARATOR);
        }
        return selectedCard;
    }

    private boolean hasMatchingCards(Suit suit) {
        for (Card card : cards){
            if (card.getSuit() == suit)
                return true;
        }
        return false;
    }
}
