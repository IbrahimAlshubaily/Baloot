import model.Card;
import model.Dealer;
import model.Player;
import model.Team;

import java.util.ArrayList;

public class Engine {
    private final Dealer dealer = new Dealer();
    private final Player[] players = {new Player(Team.A), new Player(Team.B), new Player(Team.A), new Player(Team.B)};

    public Engine(){
        setUp();
    }

    private void setUp() {
        dealer.resetDeck();
        for (Player player : players){
            player.setCards(dealer.dealHand());
        }
    }

    public void rollOut(){
        for (int round = 0; round < 8; round++){
            System.out.println("-".repeat(20));
            playRound();
        }
    }

    private void playRound() {
        ArrayList<Card> floor = new ArrayList<>();
        for (Player player : players){
            Card card = player.play(floor);
            floor.add(card);
            System.out.println(card.getRepr());
        }
    }

}
