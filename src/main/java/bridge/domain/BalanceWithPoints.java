package bridge.domain;

import javax.ws.rs.QueryParam;

public class BalanceWithPoints {

	public BalanceWithPoints() {
	}

	@QueryParam("numberOfClubs")
	private Integer numberOfClubs;

	@QueryParam("numberOfDiamonds")
	private Integer numberOfDiamonds;

	@QueryParam("numberOfHearts")
	private Integer numberOfHearts;

	@QueryParam("numberOfSpades")
	private Integer numberOfSpades;

	@QueryParam("points")
	private Integer points;

	public Integer getNumberOfClubs() {
		return numberOfClubs;
	}

	public void setNumberOfClubs(Integer numberOfClubs) {
		this.numberOfClubs = numberOfClubs;
	}

	public Integer getNumberOfDiamonds() {
		return numberOfDiamonds;
	}

	public void setNumberOfDiamonds(Integer numberOfDiamonds) {
		this.numberOfDiamonds = numberOfDiamonds;
	}

	public Integer getNumberOfHearts() {
		return numberOfHearts;
	}

	public void setNumberOfHearts(Integer numberOfHearts) {
		this.numberOfHearts = numberOfHearts;
	}

	public Integer getNumberOfSpades() {
		return numberOfSpades;
	}

	public void setNumberOfSpades(Integer numberOfSpades) {
		this.numberOfSpades = numberOfSpades;
	}

	public Integer getPoints() {
		return points;
	}

	public void setPoints(Integer points) {
		this.points = points;
	}

	@Override
	public String toString() {
		return "BalanceWithPoints{" +
			"numberOfClubs=" + numberOfClubs +
			", numberOfDiamonds=" + numberOfDiamonds +
			", numberOfHearts=" + numberOfHearts +
			", numberOfSpades=" + numberOfSpades +
			", points=" + points +
			'}';
	}
}
