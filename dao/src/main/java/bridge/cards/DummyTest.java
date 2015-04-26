package bridge.cards;

import bridge.ClientProvider;

public class DummyTest {

	public static void main(String[] args) {
		CardsDao cardsDao = new CardsDao(new ClientProvider().getClient());

	}
}
