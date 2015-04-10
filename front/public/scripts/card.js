var Card = React.createClass({
    render: function () {
        return ( <img className="cardImage" src={"images/" + this.colorShortcut(this.props.color) + this.valueShortcut(this.props.cardValue) + ".gif"}/> );
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
                console.log(data);
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
        // setInterval(this.loadCardsFromServer, this.props.pollInterval);
    },
    render: function () {
        return (
            <div>
                <CardList data={this.state.data} />
            </div>
            );
    }
});

var CardList = React.createClass({
    render: function () {
        var cardNodes = this.props.data.map(function (card, index) {
            console.log(card);
            console.log();
            return ( <Card cardValue={card.cardValue} color={card.color} key={index}> xxx</Card> );
        });
        return ( <div className='hand'> {cardNodes} </div> );
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
                <CardBox url='cards.json' pollInterval={0} />
                <SenderButton/>
            </div>
        );
    }
});

React.render(
    //CardBox url='http://localhost:8080/hand/NORTH' pollInterval={0} />, document.getElementById('content')
    <Page url='cards.json' pollInterval={0} />, document.getElementById('content')
);