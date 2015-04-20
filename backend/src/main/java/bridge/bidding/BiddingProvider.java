package bridge.bidding;

import bridge.domain.BalanceWithPoints;
import bridge.domain.Bidding;
import bridge.domain.BiddingFullInfo;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class BiddingProvider {

	public static final String BIDDINGS_JSON_FILE = "./backend/src/main/resources/biddings.json";

	public List<Bidding> getBiddings(BalanceWithPoints balance) {
		try {
			ObjectMapper mapper = new ObjectMapper();

			BiddingFullInfo biddingFullInfo = mapper.readValue(new File(BIDDINGS_JSON_FILE), BiddingFullInfo.class); // TODO this mapping should be done only one
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
