package bridge.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Deck {

    private List<Card> cards;

    public Deck() {
        cards = new ArrayList<>();
        init();
    }

    private void init() {
        for (CardColor color : CardColor.values()) {
            for (CardValue value : CardValue.values()) {
                Card card = new Card(value, color);
                cards.add(card);
            }
        }
    }

    public List<Card> getCards() {
        return Optional.ofNullable(cards).orElse(Collections.emptyList());
    }
}
