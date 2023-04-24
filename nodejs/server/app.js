const EventEmitter = require('events');  
const errorMonitor = require('events');
// const emitter = new EventEmitter();

// emitter.on('messagelogged', function(arg){
//     console.log('Listener', arg);
// });

// emitter.emit('message', {id:1, url:'http://'});

// var os = require('os')
// console.log("platform" + os.platform())
// console.log("shree" + os.arch())
// console.log("nm")

// import { EventEmitter } from 'node:events';

class MyEmitter extends EventEmitter {}

// const myEmitter = new MyEmitter();
// myEmitter.on('event', (a, b) => {
//   console.log(a, b, this);
//   // Prints: a b {}
// });
// myEmitter.emit('event', 'a', 'b');

// const myEmitter = new MyEmitter();
// myEmitter.on('event', (a, b) => {
//   setImmediate(() => {
//     console.log('this happens asynchronously');
//   });
// });
// myEmitter.emit('event', 'a', 'b');

//import { EventEmitter } from 'node:events';

// class MyEmitter extends EventEmitter {}

// const myEmitter = new MyEmitter();
// myEmitter.on('event', () => {
//   console.log('an event occurred!');
// });
// myEmitter.emit('event');

// const myEmitter = new MyEmitter();
// myEmitter.on('event', function(a, b) {
//   console.log(a, b, this, this === myEmitter);
//   // Prints:
//   //   a b MyEmitter {
//   //     _events: [Object: null prototype] { event: [Function (anonymous)] },
//   //     _eventsCount: 1,
//   //     _maxListeners: undefined,
//   //     [Symbol(kCapture)]: false
//   //   } true
// });
// myEmitter.emit('event', 'a', 'b');

// const myEmitter = new MyEmitter();
// let m = 1;
// myEmitter.on('event', () => {
//   console.log(m++);
// });
// myEmitter.emit('event');
// // Prints: 1
// myEmitter.emit('event');
// // Prints: 2
// myEmitter.emit('event');
// // Prints: 1
// myEmitter.emit('event');
// // Prints: 2

const myEmitter = new EventEmitter();
myEmitter.on(errorMonitor, (err) => {
  MyMonitoringTool.log(err);
});
myEmitter.emit('error', new Error('whoops!'));