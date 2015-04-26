package bridge.domain;

public enum CardValue {

    TWO(0), THREE(0), FOUR(0), FIVE(0), SIX(0), SEVEN(0), EIGHT(0), NINE(0), TEN(0), JACK(1), QUEEN(2), KING(3), ACE(4);

    private int value;

    CardValue(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
