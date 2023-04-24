var http = require('http');
http.createServer(function(req,res){
    res.writeHead(200,{'Content-type':'text/plain'});
    res.write("Welcome to Vellore");
    res.end("Thank you");

}).listen(8081);