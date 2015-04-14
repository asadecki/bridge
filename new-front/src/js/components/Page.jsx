const React = require('react');
const Jumbotron = require('react-bootstrap/lib/Jumbotron');
const CardBox = require('./CardBox.jsx');

let Page = React.createClass({

	render() {
    	return (
      		<div className="container">
        		<Jumbotron>
          			<h1>Learning Flux</h1>
          			<p>
            			Here is an endpoint: {this.props.url}
            		</p>
            		<div>
						<CardBox url={this.props.url} pollInterval={0} />
					</div>
        		</Jumbotron>
      		</div>
    	);
  	}
});

module.exports = Page;
