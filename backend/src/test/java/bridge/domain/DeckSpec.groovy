package bridge.domain

import bridge.domain.CardColor
import bridge.domain.Deck
import spock.lang.Specification

class DeckSpec extends Specification {

    Deck deck

    def setup() {
        deck = new Deck()
    }

    def "Deck should have 52 cards"() {
        when:
        def numberOfCards = deck.getCards().size()

        then:
        numberOfCards == 52
    }

    def "Deck should have 13 clubs"() {
        when:
        def numberOfCards = deck.getCards().findAll{(it.color == CardColor.CLUB)}.size()

        then:
        numberOfCards == 13
    }
}