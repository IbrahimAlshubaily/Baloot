import model.*;

import java.util.ArrayList;


public class Engine {
    private final Dealer dealer = new Dealer();
    private Player[] players = {new Player(Team.A, 0), new Player(Team.B, 1),
                                            new Player(Team.A, 2), new Player(Team.B, 3)};
    private final ScoreBoard scoreBoard = new ScoreBoard();

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
        System.out.println("The Winner is : "+ scoreBoard.getWinner()+ " -> "+ scoreBoard.getScores());
    }

    private void playRound() {
        int score = 0;
        int winnerInd = 0;
        int maxScoreValue = -1;
        ArrayList<Card> floor = new ArrayList<>();
        for (int i = 0; i < players.length; i++){
            Card card = players[i].play(floor);
            floor.add(card);
            score += card.getScoreValue();
            if (card.getSuit() == floor.get(0).getSuit() && card.getScoreValue() > maxScoreValue){
                maxScoreValue = card.getScoreValue();
                winnerInd = i;
            }
            System.out.println(players[i].getId() + " : " + card.getRepr());
        }
        scoreBoard.score(score, players[winnerInd].getTeam());
        players = getReArrangedPlayers(winnerInd);
    }

    Player[] getReArrangedPlayers(int winnerInd){
        int n = players.length;
        Player[] reArrangedPlayers = new Player[n];
        for (int i = 0; i < n; i++)
            reArrangedPlayers[i] = players[winnerInd++%n];
        return reArrangedPlayers;
    }

}
