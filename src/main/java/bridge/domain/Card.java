package bridge.domain;

public class Card {

    private CardValue cardValue;
    private CardColor color;

    public Card(CardValue cardValue, CardColor color) {
        this.cardValue = cardValue;
        this.color = color;
    }

    public CardValue getCardValue() {
        return cardValue;
    }

    public CardColor getColor() {
        return color;
    }
}
