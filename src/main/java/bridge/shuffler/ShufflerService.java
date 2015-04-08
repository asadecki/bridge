package bridge.shuffler;

import bridge.domain.Card;
import bridge.domain.Deck;
import bridge.domain.Hand;
import bridge.domain.Player;
import bridge.domain.Table;

import java.util.Random;

/**
 * This class is cool but we can do it better
 * With current shuffle method implementation 99 % of case
 * will provide JQKA of Spade for 4th player
 *
 * We can take numbers from 0 to 51 and sort them
 * Then divide into 4 groups and get cards
 */
@Deprecated
public class ShufflerService {

    private Random random;

    public ShufflerService(Random random) {
        this.random = random;
    }

    public Table shuffle(Deck deck) {
        Table table = new Table();

        deck.getCards().forEach(
            card -> addCardToRandomHand(table, card)
        );
        return table;
    }

    private void addCardToRandomHand(Table table, Card card) {
        boolean playerWithEmptySlotFound = false;

        while (!playerWithEmptySlotFound) {
            Player player = getRandomPlayer(table);
            if (hasPlayerPlaceForNextCard(player)) {
                playerWithEmptySlotFound = true;
                Hand hand = player.getHand();
                hand.addCard(card);
            }
        }
    }

    private boolean hasPlayerPlaceForNextCard(Player player) {
        return player.getHand().getCards().size() < 13;
    }

    private Player getRandomPlayer(Table table) {
        return table.findPlayerByPosition(random.nextInt(4)).get();
    }
}
