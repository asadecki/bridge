const React = require('react');
const CardList = require('./CardList.jsx');

let CardBox = React.createClass({
	loadCardsFromServer: function () {
	console.log("I am taking data...");
	// TODO this has to be removed from here
	/*
	   	$.ajax({
			url: this.props.url,
		   	dataType: 'json',
		   	success: function (data) {
			   	this.setState({data: data});
			   	var $element = $('.cardImage');
			   	setupSolutionButtonOnclickEvent();
		   	}.bind(this),
		   	error: function (xhr, status, err) {
			   	console.error(this.props.url, status, err.toString());
		   	}.bind(this)
	   	});
	*/
   	},
   	getInitialState: function () {
	   	return {
		   	data: {
			   	playerSouth: {
				   	name: "SOUTH",
				   	hand: {
					   	cards: []
				   	}
			   	}, playerNorth: {
				   	name: "NORTH",
				   	hand: {
					   	cards: []
				   	}
			   	}
		   	}
	   	};
   	},
   	componentDidMount: function () {
	   	this.loadCardsFromServer();
   	},
   	render: function () {
	   	return (
		   	<div>
			   	<CardList data={this.state.data.playerNorth} />
			   	<CardList data={this.state.data.playerSouth} />
		   	</div>
		);
   	}
});

module.exports = CardBox;
