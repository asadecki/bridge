var Card = React.createClass({
    render: function () {
        return (
            <div className="card">
                <h2 className="cardAuthor"> {this.props.value} </h2>
                <h2> {this.props.color} </h2>
            </div>
            );
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
            <div className="commentBox">
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
        return ( <div className="cardList"> {cardNodes} </div> );
    }
});

React.render(
    <CardBox url="cards.json" pollInterval={2000} />,
    document.getElementById('content')
);