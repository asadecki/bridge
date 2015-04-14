const AppDispatcher = require('../dispatchers/AppDispatcher');
const Constants = require('../constants/AppConstants');
const BaseStore = require('./BaseStore');
const assign = require('object-assign');

let _data = [];

function setData(cards) {
    _data = cards;
}

let CardStore = assign({}, BaseStore, {

    getAllCards() {
        return {
            cards: _data
        };
    },

    dispatcherIndex: AppDispatcher.register(function (payload) {
        let action = payload.action;

        switch (action.type) {

            case Constants.ActionTypes.FETCH_ALL_CARDS:
                let cards = action.cards.playerNorth.hand.cards;
                setData(cards);
                console.log(CardStore.getAllCards());
                CardStore.emitChange();

                break;

        }
    })
});

module.exports = CardStore;
