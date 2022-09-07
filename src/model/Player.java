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
    public void setCards(List<Card> cards) {
        this.cards = cards;
        sortCards();
    }

    private void sortCards() {
        cards.sort((c1, c2) -> {
            int result = c1.getSuit().compareTo(c2.getSuit());
            if (result == 0){
                result = c2.getAscendingRank() - c1.getAscendingRank();
            }
            return result;
        });
    }

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

    public void printCards() {
        for (int i = 0; i < cards.size(); i++){
            System.out.println(i + " : " + cards.get(i).getRepr());
        }
    }

    public Card getCard(int selectionInd) {
        Card selectedCard = cards.get(selectionInd);
        cards.remove(selectionInd);
        return selectedCard;
    }
}
