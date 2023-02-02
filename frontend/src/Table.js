import React from 'react'

const TableHeader = () => {
  return (
    <thead>
      <tr>
        <th>SensorEntry ID</th>
        <th>Sensor ID</th>
        <th>Data</th>
        <th>Timestamp</th>
      </tr>
    </thead>
  )
}

const TableBody = (props) => {
	const rows = props.sensorEntry.map((row, index) => {
	  return (
		  <tr key={index}>
		  	<td>{row.entryId}</td>
		  	<td>{row.id}</td>
        <td>{row.data}</td>
        <td>{row.timestamp}</td>
        <td>
          <button onClick={() => props.removeEntry(row.entryId)}>Delete</button>
        </td>
	    </tr>
	  )
	  })
	  
	  return <tbody>{rows}</tbody>
}

const Table = (props) => {
  const { sensorEntry, removeEntry} = props

  return (
    <table>
      <TableHeader />
      <TableBody sensorEntry={sensorEntry} removeEntry={removeEntry} />
    </table>
  )
}

export default Table