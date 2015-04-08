var Card = React.createClass({
    render: function () {
        return (
            <div className='card'>
                <img src={'images/ck.gif'}/>
            </div>
            );
    },

    valueShortcut: function (value) {
        if (value === 'TWO') {
            return 2;
        } else if (value === 'THREE') {
            return 3;
        } else if (value === 'FOUR') {
            return 4;
        } else if (value === 'FIVE') {
            return 5;
        } else if (value === 'SIX') {
            return 6;
        } else if (value === 'SEVEN') {
            return 7;
        } else if (value === 'EIGHT') {
            return 8;
        } else if (value === 'NINE') {
            return 9;
        } else if (value === 'TEN') {
            return 10;
        } else if (value === 'JACK') {
            return 'j';
        } else if (value === 'QUEEN') {
            return 'q';
        } else if (value === 'KING') {
            return 'k';
        } else if (value === 'ACE') {
            return 1;
        }
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
            }.bind(this),
            error: function (xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    getInitialState: function () {
        return {data: []};
    },
    componentDidMount: function () {
        this.loadCardsFromServer();
        setInterval(this.loadCardsFromServer, this.props.pollInterval);
    },
    render: function () {
        return (
            <div>
                <h1>Cards</h1>
                <CardList data={this.state.data} />
            </div>
            );
    }
});

var CardList = React.createClass({
    render: function () {
        var cardNodes = this.props.data.map(function (card, index) {
            return ( <Card value={card.value} color={card.color} key={index}> xxx</Card> );
        });
        return ( <div className='cardList'> {cardNodes} </div> );
    }
});

React.render(
    <CardBox url='cards.json' pollInterval={2000} />,
    document.getElementById('content')
);