const React = require('react');
const CardStore = require('../stores/CardStore');
const CardActionFetcher = require('../actions/CardActionFetcher');
const BiddingButtonManager = require('../helpers/BiddingButtonHelper');
const BiddingListHelper = require('../helpers/BiddingListHelper');
const Button = require('react-bootstrap/lib/Button');
const Panel = require('react-bootstrap/lib/Panel');
const CardList = require('./CardList.jsx');
const BiddingList = require('./BiddingList.jsx');

let App = React.createClass({

  	getInitialState() {
    	return CardActionFetcher.getInitState();
  	},

  	_onChange() {
   		this.setState(CardStore.getAllCards());
  	},

  	componentDidMount() {
    	CardStore.addChangeListener(this._onChange);
    	BiddingButtonManager.hideBiddingButtons();

  	},

  	handleGetCardsClick(e) {
    	CardActionFetcher.fetchAllCards();
    	BiddingButtonManager.hideBiddingButton("bidding-list-south");
    	BiddingListHelper.clearBiddingList();
  	},

  	render() {
    	let {cards} = this.state;
		return (
			<div>
				<Panel className='player-panel' header='NORTH' bsStyle='primary'>
					<CardList cards={cards.playerNorth.hand.cards} />
					<BiddingList biddingBtnId='bidding-list-north' player='north'></BiddingList>
				</Panel>

				<Panel>
					<Button className='getCardsButton' onClick={this.handleGetCardsClick} bsStyle='primary' bsSize='large'>Get cards</Button>
				</Panel>

				<Panel className='player-panel' header='SOUTH' bsStyle='primary'>
					<BiddingList biddingBtnId='bidding-list-south' player='south'></BiddingList>
					<CardList cards={cards.playerSouth.hand.cards} />
				</Panel>
			</div>
    	);
  	}
});

module.exports = App;
