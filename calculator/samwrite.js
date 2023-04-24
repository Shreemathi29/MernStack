/*var http = require("http");
var fs = require("fs");
http.createServer(function(req,res)
{
    fs.writeFile("shree1.txt","Shreemathi", function(err,data)
    {
        if(err)
        {
        return console.log.error(err);
        }
        //console.log("Async data : " + data.toString());
        res.write("success");
        res.end();
    });
}).listen(1238);

//var data = fs.readFileSync('shree.txt');
//console.log("Sync data : " + data.toString());
//console.log("program end");

var http = require("http");
var fs = require("fs");
http.createServer(function(req,res)
{
    fs.appendFile("shree1.txt","Shreemathi", function(err,data)
    {
        if(err)
        {
        return console.log.error(err);
        }
        //console.log("Async data : " + data.toString());
        res.write("success");
        res.end();
    });
}).listen(1238);
*/
var http = require("http");
var fs = require("fs");
http.createServer(function(req,res)
{
    fs.stat("shreemathi.txt", function(err, stats)
    {
        if(err)
        {
            return console.log.error(err);
        }
        //console.log("Async data : " + data.toString());
        res.write("success");
        res.end();
    });
}).listen(1238);