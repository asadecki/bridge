package bridge.domain;

public enum CardColor {

    CLUB(0), DIAMOND(1), HEARTH(2), SPADE(3);

    private int priority;

    CardColor(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
