package bridge.domain.bidding;

public class Bidding {

	private int level;
	private BiddingColor biddingColor;

	public Bidding(int level, BiddingColor biddingColor) {
		this.level = level;
		this.biddingColor = biddingColor;
	}

	public Bidding() {
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public BiddingColor getBiddingColor() {
		return biddingColor;
	}

	public void setBiddingColor(BiddingColor biddingColor) {
		this.biddingColor = biddingColor;
	}
}
