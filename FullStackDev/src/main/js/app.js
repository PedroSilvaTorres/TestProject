const React = require('react');
const ReactDOM = require('react-dom');
const client = require('./client');

class SensorEntry extends React.Component{
	render() {
		return (
			<tr>
				<td>{this.props.sensorentry.entryId}</td>
				<td>{this.props.sensorentry.id}</td>
				<td>{this.props.sensorentry.data}</td>
				<td>{this.props.sensorentry.timestamp}</td>
				<td>{this.props.sensorentry.type}</td>
			</tr>
		)
	}
}

class SensorEntryList extends React.Component{
	render() {
		const sensorentries = this.props.sensorentries.map(sensorentry =>
			<sensorentry key={sensorentry._links.self.href} sensorentry={sensorentry}/>
		);
		return (
			<table>
				<tbody>
					<tr>
						<th>EntryId</th>
						<th>SensorId</th>
						<th>Data</th>
						<th>Timestamp</th>
						<th>Type</th>
					</tr>
					{sensorentries}
				</tbody>
			</table>
		)
	}
}

class App extends React.Component {

	constructor(props) {
		super(props);
		this.state = {sensorentry: []};
	}

	componentDidMount() {
		client({method: 'GET', path: '/sensors/'}).done(response => {
			this.setState({sensorentry: response.entity._embedded.sensorentry});
		});
	}

	render() {
		return (
			<SensorEntryList sensorentry={this.state.sensorentry}/>
		)
	}
}

ReactDOM.render(
	<App />,
	document.getElementById('react')
)