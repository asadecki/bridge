const React = require('react');
const Card = require('./Card.jsx');

let CardList = React.createClass({

   	getInitialState: function () {
	   	return {
		   	data: {
		   		hand : {
					cards: []
				},
				name : 'yeaahhhhhhh'
		   	}
	   	};
   	},
	render: function () {

	   	var cardNodes = this.props.data.hand.cards.map(function (card, index) {
		   	return ( <Card cardValue={card.cardValue} color={card.color} key={index}></Card> );
	   	});
	   	return ( <div data-player-name={this.props.data.name}> {cardNodes} </div> );
   	}
});

module.exports = CardList;
