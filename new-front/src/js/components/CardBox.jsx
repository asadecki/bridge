const React = require('react');
const CardStore = require('../stores/CardStore');
const CardActionFetcher = require('../actions/CardActionFetcher');
const Button = require('react-bootstrap/lib/Button');
const Panel = require('react-bootstrap/lib/Panel');
const CardList = require('./CardList.jsx');
const BiddingList = require('./BiddingList.jsx');

let App = React.createClass({

  	getInitialState() {
    	return {
      		cards: {
      			playerNorth : {
      				hand : {
      					cards : []
      				}
      			},
      			playerSouth : {
					hand : {
						cards : []
					}
				}
      		}
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
    	console.log({cards});
		return (
			<div>
				<Panel header="NORTH" bsStyle='primary'>
					<CardList cards={cards.playerNorth.hand.cards} />
				</Panel>

				<BiddingList biddingBtnId="bidding-list-north">
                </BiddingList>

				<Panel>
					<Button className="getCardsButton" onClick={this.handleGetCardsClick} bsStyle='primary' bsSize='large'>Get cards</Button>
				</Panel>

				<BiddingList biddingBtnId-id="bidding-list-south">
				</BiddingList>

				<Panel header="SOUTH" bsStyle='primary'>
					<CardList cards={cards.playerSouth.hand.cards} />
				</Panel>

			</div>
    	);
  	}
});

module.exports = App;
