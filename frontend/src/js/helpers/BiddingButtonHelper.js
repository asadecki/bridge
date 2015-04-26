const assign = require('object-assign');

var buttons = {
    "bidding-list-south" : "bidding-list-north",
    "bidding-list-north" : "bidding-list-south"
};

var BiddingButtonManager = assign({}, {

    hideBiddingButtons() {
        $('#' + buttons['bidding-list-south']).hide();
        $('#' + buttons['bidding-list-north']).hide();
    },

    hideBiddingButton(buttonId) {
        $('#' + buttonId).hide();
        this.showCorrespondingButton(buttons[buttonId]);
    },

    showCorrespondingButton(buttonId) {
        $('#' + buttonId).show();
    }
});

module.exports = BiddingButtonManager;
