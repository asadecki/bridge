package bridge.shuffler;

import bridge.domain.Card;
import bridge.domain.Deck;
import bridge.domain.Hand;
import bridge.domain.Player;
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

		return table;
	}

	private void createHandForPlayers(Deck deck, Table table) {

		int start = 0;
		for (Player player : table.getPlayers()) {
			player.setHand(new Hand(deck.getCards().subList(0, start + 13)
				.stream()
				.sorted(comparing(Card::getCardValue))
				.sorted(comparing(Card::getColor))
				.collect(Collectors.toList())
			));
			start += 13;
		}
	}
}
