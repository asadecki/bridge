const assign = require('object-assign');

var BiddingListHelper = assign({}, {

    clearBiddingList() {
        $('.list-group-item').remove();
    }
});

module.exports = BiddingListHelper;
