package bridge.domain.bidding;

import javax.ws.rs.QueryParam;
import java.util.List;

public class BiddingHistory {

	@QueryParam("biddings")
	private List<String> biddings;

	public BiddingHistory() {
	}

	public List<String> getBiddings() {
		return biddings;
	}

	public void setBiddings(List<String> biddings) {
		this.biddings = biddings;
	}
}

