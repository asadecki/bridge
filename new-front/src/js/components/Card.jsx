const React = require('react');

let cardShortcut = {
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
	'ACE': 1,
	'none' : 'b1fv'
};

let Card = React.createClass({
  	getDefaultProps() {
    	return {
      		card: {
        		color: '',
        		cardValue: false
      		}
    	};
  	},

  	colorShortcut: function (color) {
  		return color.charAt(0);
  	},

  	render() {
    	let {card} = this.props;
		return (
			<img className="card" src={"images/" + this.colorShortcut(card.color) + cardShortcut[card.cardValue] + ".gif"}
			data-card-value={card.cardValue}
			data-card-color={this.colorShortcut(card.color)}/>
		);
  	}
});

module.exports = Card;
