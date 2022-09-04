package model;

public class ScoreBoard {
    private int scoreA = 0;
    private int scoreB = 0;
    public void score(int score, Team winnerTeam){
        if (winnerTeam == Team.A){
            scoreA += score;
        } else{
            scoreB += score;
        }
    }
    public Team getWinner(){
        if (scoreA > scoreB){
            return Team.A;
        } else if (scoreA < scoreB) {
            return Team.B;
        } else {
            return null; //very unlikely but lets find a better hack ; )
        }
    }

    public String getScores() {
        return scoreA + " Vs. " + scoreB;
    }
}
