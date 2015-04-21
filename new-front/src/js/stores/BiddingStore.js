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
        console.log(_data);

        return {
            biddings: _data
        };
    },

    dispatcherIndex: AppDispatcher.register(function (payload) {
        let action = payload.action;

        switch (action.type) {

            case Constants.ActionTypes.GET_BIDDING:
                let biddings = action.biddings;
                let player = action.player;
                addBidding(biddings, player);
                BiddingStore.emitChange();
                break;
        }
    })
});

module.exports = BiddingStore;
