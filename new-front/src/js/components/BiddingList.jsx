const React = require('react');
const ListGroup = require('react-bootstrap/lib/ListGroup');
const ListGroupItem = require('react-bootstrap/lib/ListGroupItem');
const Button = require('react-bootstrap/lib/Button');
const BiddingActionGetter = require('../actions/BiddingActionGetter');
const BiddingStore = require('../stores/BiddingStore');

let BiddingList = React.createClass({

 	getInitialState() {
    	return {
      		biddingsNorth: {
      			north : [],
      			south : []
      		}
    	}
  	},

	_onChange() {
		this.setState(BiddingStore.getBiddings());
	},

	componentDidMount() {
		BiddingStore.addChangeListener(this._onChange);
	},

	handleBiddingClick(e) {
		BiddingActionGetter.getBidding(e);
	},

  	render() {
    	let {biddingsNorth} = this.state;
    	return (
    		<div>
    			<Button bsStyle='info' onClick={this.handleBiddingClick} id={this.props.biddingBtnId}>Bidding</Button>
              	{biddingsNorth[this.props.player].map(bidding => <ListGroupItem>{bidding}</ListGroupItem>)}
			</div>
        );
  	}
});

module.exports = BiddingList;
