const AppDispatcher = require('../dispatchers/AppDispatcher');
const Constants = require('../constants/AppConstants');
const BaseStore = require('./BaseStore');
const assign = require('object-assign');

let _data = [];

function setData(biddings) {
    _data = biddings;
}

let BiddingStore = assign({}, BaseStore, {

    getBiddings() {
        return {
            cards: _data
        };
    },

    dispatcherIndex: AppDispatcher.register(function (payload) {
        let action = payload.action;

        console.log('elllooo');
        switch (action.type) {

            case Constants.ActionTypes.GET_BIDDING:
                let biddings = action.biddings;
                setData(biddings);
                BiddingStore.emitChange();
                console.log(biddings);
                break;
        }
    })
});

module.exports = BiddingStore;
