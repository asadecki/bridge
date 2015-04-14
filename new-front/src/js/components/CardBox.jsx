const React = require('react');
const CardStore = require('../stores/CardStore');
const CardActionFetcher = require('../actions/CardActionFetcher');
const Button = require('react-bootstrap/lib/Button');
const CardList = require('./CardList.jsx');

let App = React.createClass({

  	getInitialState() {
    	return {
      		cards: []
    	}
  	},

  	_onChange() {
   		this.setState(CardStore.getAllCards());
  	},

  	componentDidMount() {
    	CardStore.addChangeListener(this._onChange);
  	},

  	handleGetCardsClick(e) {
    	CardActionFetcher.fetchAllCards();
  	},

  	render() {
    	let {cards} = this.state;
    	console.log('asdadsasdds');
		console.log({cards});
		return (
			<div className="container">
				<CardList cards={cards} />
				<Button onClick={this.handleGetCardsClick} bsStyle="primary">Get cards</Button>
			</div>
    	);
  	}
});

module.exports = App;
