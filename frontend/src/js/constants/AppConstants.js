const keyMirror = require('react/lib/keyMirror');

module.exports = {

    ActionTypes: keyMirror({
        FETCH_ALL_CARDS: null,
        GET_BIDDING: null,
        ADD_TASK: null
    }),

    ActionSources: keyMirror({
        SERVER_ACTION: null,
        VIEW_ACTION: null
    })
};
