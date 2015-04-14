const React = require('react');

let Card = React.createClass({
  	render: function () {
	  	return ( <img className="cardImage" src={"images/" + this.colorShortcut(this.props.color) + cardShortcut[this.props.cardValue] + ".gif"}
	  	data-card-value={cardShortcut[this.props.cardValue]} data-card-color={this.colorShortcut(this.props.color)} />);
  	},

  	colorShortcut: function (color) {
	  	return color.charAt(0);
	},

  	var cardShortcut = {
		'TWO': 2,
		'THREE': 3,
		'FOUR': 4,
		'FIVE': 5,
		'SIX': 6,
		'SEVEN': 7,
		'EIGHT': 8,
		'NINE': 9,
		'TEN': 10,
		'JACK': 'j',
		'QUEEN': 'q',
		'KING': 'k',
		'ACE': 1
	};
});


module.exports = Card;
