package bridge.counter

import Card
import CardColor
import CardValue
import Hand
import spock.lang.Specification

class HandPointsCounterSpec extends Specification {

    def handPointsCounter = new HandPointsCounter()

    Hand handWithFourCards

    def setup() {
        def card1 = new Card(CardValue.TWO, CardColor.CLUB)
        def card2 = new Card(CardValue.QUEEN, CardColor.CLUB)
        def card3 = new Card(CardValue.KING, CardColor.CLUB)
        def card4 = new Card(CardValue.ACE, CardColor.CLUB)

        def fourCards = [card1, card2, card3, card4]
        handWithFourCards = new Hand(fourCards)
    }

    def "Should return 9 points for 2, Q, K, A"() {
        when:
        def totalPoints = handPointsCounter.countPoints(handWithFourCards)

        then:
        totalPoints == 9
    }

    def "Should return 0 points for empty list"() {
        setup:
        Hand handWithNoCards = new Hand([])

        when:
        def totalPoints = handPointsCounter.countPoints(handWithNoCards)

        then:
        totalPoints == 0
    }
}