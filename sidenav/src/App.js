import React from 'react'
import Home from './Pages/Home'
import About from './Pages/About'
import Careers from './Pages/Careers'
import Gallery from './Pages/Gallery'
import Contact from './Pages/Contact' 
import Sidenavmenubar from './Components/Sidenavmenubar'
import {BrowserRouter as Router , Route , Switch} from 'react-router-dom'
function App() {
  return (
    <Router>
      <Sidenavmenubar />
      <Switch>
      <Route path = '/' exact component = {Home}/>
        <Route path = '/about' component = {About}/>
        <Route path = '/careers' component = {Careers} />
        <Route path = '/gallery' component = {Gallery} />
        <Route path = '/contact' component = {Contact} />
        <Route component = {Home}/>
      </Switch>
    </Router>
  )
}

export default App
