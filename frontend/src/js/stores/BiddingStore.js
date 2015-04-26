const AppDispatcher = require('../dispatchers/AppDispatcher');
const Constants = require('../constants/AppConstants');
const BaseStore = require('./BaseStore');
const assign = require('object-assign');

let _data = {north: [], south: []};

function addBidding(bidding, player) {
    _data[player].push(bidding);
}

let BiddingStore = assign({}, BaseStore, {

    getBiddings() {
        return {
            biddings: _data
        };
    },

    dispatcherIndex: AppDispatcher.register(function (payload) {
        let action = payload.action;

        switch (action.type) {

            case Constants.ActionTypes.GET_BIDDING:
                let bidding = 'PAS';
                if (typeof action.biddings !== 'undefined') {
                    bidding = action.biddings.level + action.biddings.biddingColor;
                }

                let player = action.player;
                addBidding(bidding, player);
                BiddingStore.emitChange();
                break;
        }
    })
});

module.exports = BiddingStore;
