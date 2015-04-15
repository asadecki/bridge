const React = require('react');
const ListGroup = require('react-bootstrap/lib/ListGroup');
const ListGroupItem = require('react-bootstrap/lib/ListGroupItem');


let BiddingList = React.createClass({

 	getInitialState() {
    	return {
      		cards: []
    	}
  	},

  	render() {
    	let {biddings} = this.state;

    	return (
		  	<ListGroup>
              	 <ListGroupItem>Fake bidding 1</ListGroupItem>
			</ListGroup>
        );
  	}
});

module.exports = BiddingList;
