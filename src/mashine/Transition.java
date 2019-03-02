package mashine;

public class Transition {
    private int from;
    private int to;
    private char symbol;

    public Transition(int from, int to, char symbol) {
        this.from = from;
        this.to = to;
        this.symbol = symbol;
    }

    public int getFrom() {
        return from;
    }

    public int getTo() {
        return to;
    }

    public char getSymbol() {
        return symbol;
    }
}