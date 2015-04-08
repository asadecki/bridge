package bridge.domain

import spock.lang.Specification

class TableSpec extends Specification {

    Table table

    def setup() {
        table = new Table()
    }

    def "Table should have 4 players"() {
        when:
        def numberOfPlayers = table.getPlayers().size()

        then:
        numberOfPlayers == 4
    }

    def "Players should be properly set up"() {
        when:
        Player player0 = table.getPlayers().get(0)
        Player player1 = table.getPlayers().get(1)
        Player player2 = table.getPlayers().get(2)
        Player player3 = table.getPlayers().get(3)

        then:

        player0.getPosition() == 0
        player0.getName().equals(PlayerPlace.NORTH)

        player1.getPosition() == 1
        player1.getName().equals(PlayerPlace.SOUTH)

        player2.getPosition() == 2
        player2.getName().equals(PlayerPlace.EAST)

        player3.getPosition() == 3
        player3.getName().equals(PlayerPlace.WEST)
    }
}