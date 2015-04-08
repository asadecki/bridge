var Card = React.createClass({
    render: function () {
        return (
            <div className="card">
            <img src={"images/jack.jpg"}/>
            </div>
            );
    }
});


var Hand = React.createClass({
    render: function () {
        return (
            <Card />
            );
    }
});

React.render(
    <Hand url="comments.json" pollInterval={2000} />,
    document.getElementById('content')
);