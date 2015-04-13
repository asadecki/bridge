package bridge.bidding;

import bridge.domain.BalanceWithPoints;
import bridge.domain.Bidding;
import bridge.domain.BiddingColor;

import java.util.Optional;

public class OpeningProvider {

	private static final int ALL_CARDS_IN_COLOR = 13;
	private static final int ALL_POINTS_IN_DECK = 40;

	public Optional<Bidding> c1(BalanceWithPoints balance) {
		// TODO add exception 5c - 4d 12-14 points possible 1c
		if ((checkNumberLimit(balance.getNumberOfHearts(), 0, 4) && checkNumberLimit(balance.getNumberOfSpades(), 0, 4) && checkNumberLimit(balance.getNumberOfDiamonds(), 0, 3) && checkPointsLimit(balance.getPoints(), 12, 14)) /* 12-14 points max 4 H/S max 4 D */ ||
			(checkNumberLimit(balance.getNumberOfClubs(), 5, ALL_CARDS_IN_COLOR) && checkPointsLimit(balance.getPoints(), 15, 17) /* 15-17 points 5+ clubs */ ||
				checkPointsLimit(balance.getPoints(), 18, ALL_POINTS_IN_DECK) /* 18+ points */)
			) {
			return Optional.of(new Bidding(1, BiddingColor.CLUB));
		}

		return Optional.empty();
	}

	public Optional<Bidding> d1(BalanceWithPoints balance) {
		if (checkNumberLimit(balance.getNumberOfDiamonds(), 4, ALL_CARDS_IN_COLOR) && checkPointsLimit(balance.getPoints(), 12, 17)) {
			return Optional.of(new Bidding(1, BiddingColor.DIAMOND));
		}
		return Optional.empty();
	}

	public Optional<Bidding> h1(BalanceWithPoints balance) {
		if (checkNumberLimit(balance.getNumberOfHearts(), 5, ALL_CARDS_IN_COLOR) && checkPointsLimit(balance.getPoints(), 12, 17)) {
			return Optional.of(new Bidding(1, BiddingColor.HEARTH));
		}

		return Optional.empty();
	}

	public Optional<Bidding> s1(BalanceWithPoints balance) {
		if (checkNumberLimit(balance.getNumberOfSpades(), 5, ALL_CARDS_IN_COLOR) && checkPointsLimit(balance.getPoints(), 12, 17)) {
			return Optional.of(new Bidding(1, BiddingColor.SPADE));
		}

		return Optional.empty();
	}

	public Optional<Bidding> nt1(BalanceWithPoints balance) {
		if (checkNumberLimit(balance.getNumberOfClubs(), 0, 4) && checkNumberLimit(balance.getNumberOfDiamonds(), 0, 3) && checkNumberLimit(balance.getNumberOfHearts(), 0, 4) && checkNumberLimit(balance.getNumberOfSpades(), 0, 4) && checkPointsLimit(balance.getPoints(), 15, 17)) {
			return Optional.of(new Bidding(1, BiddingColor.NOTRUMPH));
		}

		return Optional.empty();
	}

	private boolean checkNumberLimit(int cards, int min, int max) {
		return min <= cards && cards <= max;
	}

	private boolean checkPointsLimit(int points, int min, int max) {
		return min <= points && points <= max;
	}


}
