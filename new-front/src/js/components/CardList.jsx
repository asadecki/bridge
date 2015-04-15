const React = require('react');
const Card = require('./Card.jsx');
const Table = require('react-bootstrap/lib/Table');


let CardList = React.createClass({
  	getDefaultProps() {
    	return {
      		cards: []
    	};
  	},

  	render() {
    	let {cards} = this.props;

    	return (
              <Table> <tr>{cards.map(card =>  <td><Card card={card} /></td> )} </tr></Table>
        );
  	}
});

module.exports = CardList;
