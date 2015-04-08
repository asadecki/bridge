package bridge.domain;

import java.util.List;

public class Hand {

    public Hand(List<Card> cards) {
        this.cards = cards;
    }

    private List<Card> cards;

    public List<Card> getCards() {
        return cards;
    }
}
