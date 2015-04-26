package bridge.cards;

import org.elasticsearch.client.Client;

public class CardsDao {

	Client client;

	public CardsDao(Client client) {
		this.client = client;
	}


}
