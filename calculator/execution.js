var cal=require('./mathcal');
var x = 23;
var y = 19;
console.log("Add : " + cal.add(x,y));
console.log("Sub : " + cal.sub(x,y));
console.log("Mul : " + cal.mul(x,y));
console.log("Div : " + cal.div(x,y));
const express = require('express');
const app = express();
app.get('/naveen',  cal.add(x,y))