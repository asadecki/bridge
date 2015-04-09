package bridge.services;

import bridge.domain.Deck;
import bridge.domain.Hand;
import bridge.domain.PlayerPlace;
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
		return shufflerService.shuffle(deck).getPlayers()
			.stream()
			.filter(player -> player.getName().equals(PlayerPlace.valueOf(playerName)))
			.findFirst()
			.get()
			.getHand();
	}
}
