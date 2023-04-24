import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
//import App from './App';
import reportWebVitals from './reportWebVitals';
import Home from './components/Home';
import Caption from './components/Caption';
import Contact from './components/Contact';
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Factorial from './components/Factorial';
import { Sqrt } from './components/Sqrt';
import Palindrome from './components/Palindrome';

const myRootElt = ReactDOM.createRoot(document.getElementById('root'));
const rting=(
  <div>
    <h1>React Router Example</h1>
    <BrowserRouter>
    <Routes>
      <Route path='/' element={<Home/>}></Route>
      <Route path='/about' element={<Contact/>} ></Route>
      <Route path='/why' element={<Caption/>} ></Route>
      <Route path='/palin' element={<Palindrome/>} ></Route>
      <Route path='/fact' element={<Factorial/>} ></Route>
      <Route path='/sqrt' element={<Sqrt/>} ></Route>
      
    </Routes>
    
    </BrowserRouter>
  </div>
);
myRootElt.render(rting);


// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();