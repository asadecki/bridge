const React = require('react');
const ListGroup = require('react-bootstrap/lib/ListGroup');
const ListGroupItem = require('react-bootstrap/lib/ListGroupItem');
const Button = require('react-bootstrap/lib/Button');
const BiddingActionGetter = require('../actions/BiddingActionGetter');
const BiddingStore = require('../stores/BiddingStore');

let BiddingList = React.createClass({

 	getInitialState() {
    	return {
      		biddings: []
    	}
  	},

	_onChange() {
		this.setState(BiddingStore.getBiddings());
	},

	componentDidMount() {
		BiddingStore.addChangeListener(this._onChange);
	},

	  	handleBiddingClick(e) {
      		console.log('handle method in jsx');
    		BiddingActionGetter.getBidding();
	},

  	render() {
    	let {biddings} = this.state;

    	return (
    		<div>
    			<Button bsStyle='info' onClick={this.handleBiddingClick}>Bidding</Button>
		  		<ListGroup>
              		<ListGroupItem>Fake bidding 1</ListGroupItem>
				</ListGroup>
			</div>
        );
  	}
});

module.exports = BiddingList;
