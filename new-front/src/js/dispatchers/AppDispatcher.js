const Dispatcher = require('flux').Dispatcher;
const Constants = require('../constants/AppConstants');
const assign = require('object-assign');

let AppDispatcher = assign(new Dispatcher(), {

    handleServerAction(action) {
        let payload = {
            source: Constants.ActionSources.SERVER_ACTION,
            action: action
        };
        this.dispatch(payload);
    },

    handleViewAction(action) {
        console.log('handle view dispatcher');
        console.log(action);
        let payload = {
            source: Constants.ActionSources.VIEW_ACTION,
            action: action
        };
        console.log(payload);
        this.dispatch(payload);
    }
});

module.exports = AppDispatcher;
