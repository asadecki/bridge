package bridge.counter;

import bridge.domain.Hand;

public class HandPointsCounter {
    public HandPointsCounter() {
    }

    public int countPoints(Hand hand) {
        return hand.getCards().stream().mapToInt(card -> card.getCardValue().getValue()).sum();
    }
}
