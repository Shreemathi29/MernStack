var http = require("http");
var fs = require("fs");
http.createServer(function(req,res)
{
    fs.readFile("shree.html", function(err,data)
    {
        if(err)
        {
        return console.log.error(err);
        }
        console.log("Async data : " + data.toString());
        res.write(data);
        res.end();
    });
}).listen(1239);

var data = fs.readFileSync('shree.txt');
console.log("Sync data : " + data.toString());
console.log("program end");
