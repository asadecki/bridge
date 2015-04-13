package bridge.services;

import bridge.domain.Deck;
import bridge.domain.Hand;
import bridge.domain.Table;
import bridge.shuffler.ShufflerService;

public class TableService {

	private ShufflerService shufflerService;
	private Deck deck;

	public TableService(ShufflerService shufflerService, Deck deck) {
		this.shufflerService = shufflerService;
		this.deck = deck;
	}

	public Table getTable() {
		return shufflerService.shuffle(deck);
	}

	public Hand getHand(String playerName) {

		if (playerName.equals("SOUTH")) {
			return shufflerService.shuffle(deck).getPlayerSouth().getHand();
		} else if (playerName.equals("NORTH")) {
			return shufflerService.shuffle(deck).getPlayerNorth().getHand();
		} else if (playerName.equals("WEST")) {
			return shufflerService.shuffle(deck).getPlayerWest().getHand();
		} else if (playerName.equals("SOUTH")) {
			return shufflerService.shuffle(deck).getPlayerEast().getHand();
		}

		return new Hand();
	}
}