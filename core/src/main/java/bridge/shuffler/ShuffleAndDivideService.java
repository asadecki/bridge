package bridge.shuffler;

import bridge.cards.CardsDao;
import bridge.domain.Card;
import bridge.domain.Deck;
import bridge.domain.Hand;
import bridge.domain.Table;

import java.util.Collections;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class ShuffleAndDivideService implements ShufflerService {

	@Override
	public Table shuffle(Deck deck) {
		Table table = new Table();

		Collections.shuffle(deck.getCards());
		createHandForPlayers(deck, table);

		CardsDao xx = new CardsDao(null);

		return table;
	}

	private void createHandForPlayers(Deck deck, Table table) {

		table.getPlayerSouth().setHand(buildHand(deck, 0, 13));
		table.getPlayerNorth().setHand(buildHand(deck, 13, 26));
		table.getPlayerWest().setHand(buildHand(deck, 26, 39));
		table.getPlayerEast().setHand(buildHand(deck, 39, 52));

	}

	private Hand buildHand(Deck deck, int start, int end) {
		return new Hand(deck.getCards()
			.subList(start, end)
			.stream()
			.sorted(comparing(Card::getCardValue))
			.sorted(comparing(Card::getColor))
			.collect(Collectors.toList()));
	}
}
