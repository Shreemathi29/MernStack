const express = require('express');
const app = express();
app.get('/ping', (request, response) => {
 response.send('pong');
});
app.listen(8080, 'localhost');





/*
const express = require('express');
// Creates an Express application using the top-level function
const app = express();
// Define port number as 3000
const port = 3000;
// Routes HTTP GET requests to the specified path "/" with the specified callback function
app.get('/', function(request, response) {
 response.send('Hello, World!');
});
// Make the app listen on port 3000
app.listen(port, function() {
 console.log('Server listening on http://localhost:' + port);
});*/