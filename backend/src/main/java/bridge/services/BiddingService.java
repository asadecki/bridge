package bridge.services;

import bridge.bidding.BiddingProvider;
import bridge.domain.BalanceWithPoints;
import bridge.domain.bidding.Bidding;
import bridge.domain.bidding.BiddingHistory;

import java.util.List;

public class BiddingService {

	private BiddingProvider biddingProvider;

	public BiddingService(BiddingProvider biddingProvider) {
		this.biddingProvider = biddingProvider;
	}

	public List<Bidding> getBiddings(BalanceWithPoints balance, BiddingHistory biddingHistory) {
		return biddingProvider.getBiddings(balance, biddingHistory);
	}
}
