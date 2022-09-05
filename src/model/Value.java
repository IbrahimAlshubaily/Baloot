package model;

public enum Value {
    Seven(0),
    Eight(0),
    Nine(0),

    Jack(2),
    Queen(3),
    King(4),

    Ten(10),
    Ace(11),
    ;

    private final int score;
    Value(int score) {
        this.score = score;
    }
    int getScore() {
        return score;
    }
}
