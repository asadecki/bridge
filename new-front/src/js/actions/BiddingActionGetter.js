var AppDispatcher = require('../dispatchers/AppDispatcher');
var Constants = require('../constants/AppConstants');

module.exports = {

    getBidding: function () {

        console.log('BiddingActionGetter works');
        this.biddings = ['1c', '2s'];

        AppDispatcher.handleViewAction({
                type: Constants.ActionTypes.GET_BIDDING,
                biddings: this.biddings
        });
    }

};
