package bridge.bidding

import bridge.domain.BalanceWithPoints
import bridge.domain.BiddingColor
import spock.lang.Specification

public class BiddingProvider1CSpec extends Specification{

    def biddingProvider = new OpeningProvider()

    def setup() {
    }

    def "should return bidding 1C for 4-3-2-3 with 13 points"() {
        setup:
        def balance = new BalanceWithPoints(4, 3, 2, 3, 13)

        when:
        def biddings = biddingProvider.c1(balance).get()

        then:
        biddings != null
        biddings.biddingColor == BiddingColor.CLUB
        biddings.level == 1
    }
}