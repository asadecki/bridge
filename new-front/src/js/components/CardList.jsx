const React = require('react');
const Card = require('./Card.jsx');

let CardList = React.createClass({
  	getDefaultProps() {
    	return {
      		cards: []
    	};
  	},

  	render() {
    	let {cards} = this.props;

    	return (
              <div> {cards.map(card =>  <Card card={card} /> )} </div>
        );
  	}
});

module.exports = CardList;
