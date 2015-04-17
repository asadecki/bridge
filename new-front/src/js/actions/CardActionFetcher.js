var AppDispatcher = require('../dispatchers/AppDispatcher');
var Constants = require('../constants/AppConstants');

module.exports = {

    fetchAllCards: function () {

        $.ajax({
            url: 'http://localhost:8080/hand',
            dataType: 'json',
            async: false,
            success: function (data) {
                this.cards = data;
            }.bind(this),
            error: function (xhr, status, err) {
                this.cards = {
                    playerNorth: {
                        hand: {
                            cards: [
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'}
                            ]
                        }
                    },
                    playerSouth: {
                        hand: {
                            cards: [
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'},
                                {color: 'SPADE', cardValue: 'ACE'}
                            ]
                        }
                    }
                };
            }.bind(this)
        });

        AppDispatcher.handleViewAction({
                type: Constants.ActionTypes.FETCH_ALL_CARDS,
                cards: this.cards
            }
        );
    }
};

