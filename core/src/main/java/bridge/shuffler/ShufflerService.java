package bridge.shuffler;

import bridge.domain.Deck;
import bridge.domain.Table;

public interface ShufflerService {

	Table shuffle(Deck deck);
}
