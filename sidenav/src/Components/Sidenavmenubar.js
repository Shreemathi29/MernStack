import React from 'react'
import './Sidenavmenubar.css'
import HomeIcon from '@mui/icons-material/Home'
import InfoIcon from '@mui/icons-material/Info'
import WorkIcon from '@mui/icons-material/Work'
import PermMediaIcon from '@mui/icons-material/PermMedia'
import ContactPageIcon from '@mui/icons-material/ContactPage'
import {NavLink} from 'react-router-dom'
function Sidenavmenubar() {
    return (
        <div className = 'side-nav'>
            <input type = 'checkbox' id = 'menu' />
            <label className = 'icon' htmlFor = 'menu'>
                <div className = 'menu'>
                    
                </div>
            </label>
            <nav>
                <ul>
                    <NavLink exact = {true} to ='/' activeStyle = {{fontWeight : 'bold' , color : 'blue'}}>
                        <li>
                            <HomeIcon className = 'icons'></HomeIcon>
                            <div className = 'menu-text'>
                                Home
                            </div>
                        </li>
                    </NavLink>
                    <NavLink to ='/about' activeStyle = {{fontWeight : 'bold' , color : 'blue'}}>
                        <li>
                            <InfoIcon className = 'icons'></InfoIcon>
                            <div className = 'menu-text'>
                                About
                            </div>
                        </li>
                    </NavLink>
                    <NavLink to ='/careers' activeStyle = {{fontWeight : 'bold' , color : 'blue'}}>
                        <li>
                            <WorkIcon className = 'icons'></WorkIcon>
                            <div className = 'menu-text'>
                                Careers
                            </div>
                        </li>
                    </NavLink>
                    <NavLink to ='/gallery' activeStyle = {{fontWeight : 'bold' , color : 'blue'}}>
                        <li>
                            <PermMediaIcon className = 'icons'></PermMediaIcon>
                            <div className = 'menu-text'>
                                Gallery
                            </div>
                        </li>
                    </NavLink>
                    <NavLink to ='/contact' activeStyle = {{fontWeight : 'bold' , color : 'blue'}}>
                        <li>
                            <ContactPageIcon className = 'icons'></ContactPageIcon>
                            <div className = 'menu-text'>
                                Contact us
                            </div>
                        </li>
                    </NavLink>
                </ul>
            </nav>
        </div>
    )
}

export default Sidenavmenubar
