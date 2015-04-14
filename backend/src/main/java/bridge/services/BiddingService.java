package bridge.services;

import bridge.bidding.OpeningProvider;
import bridge.domain.BalanceWithPoints;
import bridge.domain.Bidding;
import bridge.domain.BiddingColor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BiddingService {

	private OpeningProvider openingProvider;

	public BiddingService(OpeningProvider openingProvider) {
		this.openingProvider = openingProvider;
	}

	public List<Bidding> getBiddings(BalanceWithPoints balance) {
		List<Bidding> biddings = new ArrayList<>();

		add1LevelBiddings(balance, biddings);

		if (biddings.isEmpty()) {
			biddings.add(new Bidding(0, BiddingColor.PAS));
		}
		return biddings;
	}

	private void add1LevelBiddings(BalanceWithPoints balance, List<Bidding> biddings) {
		addBidding(biddings, openingProvider.c1(balance));
		addBidding(biddings, openingProvider.d1(balance));
		addBidding(biddings, openingProvider.h1(balance));
		addBidding(biddings, openingProvider.s1(balance));
		addBidding(biddings, openingProvider.nt1(balance));
	}

	private void addBidding(List<Bidding> biddings, Optional<Bidding> optionalBidding) {
		if (optionalBidding.isPresent()) {
			biddings.add(optionalBidding.get());
		}
	}


}
