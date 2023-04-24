import React from 'react';
import ReactDOM from 'react-dom';

const sampleJSON = {
  "arrOfNumbers": [1, 2, 3, 4],
  "arrOfStrings": ["a", "b", "c", "d"]
}

function ArrayOfStr() {
  return (
    <div>
      <h1>Array Of String</h1>
      <h2>{sampleJSON.arrOfNumbers}
      {sampleJSON.arrOfStrings}</h2>
    </div>
  )
}

export default ArrayOfStr