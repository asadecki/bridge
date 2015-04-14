const keyMirror = require('react/lib/keyMirror');

module.exports = {

    ActionTypes: keyMirror({
        FETCH_ALL_CARDS: null,
        ADD_TASK: null
    }),

    ActionSources: keyMirror({
        SERVER_ACTION: null,
        VIEW_ACTION: null
    })
};
