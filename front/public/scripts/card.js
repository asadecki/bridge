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


var Card = React.createClass({
    render: function () {
        return ( <img className="cardImage" src={"images/" + this.colorShortcut(this.props.color) + cardShortcut[this.props.cardValue] + ".gif"}
        data-card-value={cardShortcut[this.props.cardValue]} data-card-color={this.colorShortcut(this.props.color)} />);
    },

    colorShortcut: function (color) {
        return color.charAt(0);
    }
});

var CardBox = React.createClass({
    loadCardsFromServer: function () {
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

var CardList = React.createClass({
    render: function () {

        var cardNodes = this.props.data.hand.cards.map(function (card, index) {
            return ( <Card cardValue={card.cardValue} color={card.color} key={index}> xxx</Card> );
        });
        return ( <div className='hand' data-player-name={this.props.data.name}> {cardNodes} </div> );
    }
});

var SenderButton = React.createClass({
    render: function () {
        return (<div id="senderButton" className='senderButton'> Solution </div>)
    }
});

var Page = React.createClass({
    render: function () {
        return (
            <div>
                <CardBox url={this.props.url} pollInterval={0} />
                <SenderButton/>
                <Solutions/>
            </div>
            );
    }
});

var Solutions = React.createClass({
    render: function () {
        return (
            <div id="solutions">
            </div>
            );
    }
});

React.render(
    <Page url='http://localhost:8080/hand' pollInterval={0} />, document.getElementById('content')
);