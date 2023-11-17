import React from 'react'
import './Navbar.css'
import { useState } from 'react'
import {FiMenu, FiX} from 'react-icons/fi'

const Navbar = ({navbarLinks}) => {

    const [menuClicked, setMenuClicked] = useState(false)

    const clickMenuHandler = () => {
        setMenuClicked(!menuClicked);
    }

    return (
        <nav className='navbar'>
            <span className='navbar_logo'>travelpal</span>
            {menuClicked ? (<FiX size={25} className='navbar_menu' onClick={clickMenuHandler} />
            ) : (
            <FiMenu size={25} className='navbar_menu' onClick={clickMenuHandler} />
            )}
            <ul className='navbar_list'>
                {navbarLinks.map(item => {
                    return (
                        <li className="navbar_item" key={item.title}>
                            <a href={item.url} className="navbar_link">
                                {item.title}
                            </a>
                        </li>
                    )
                })}
            </ul>
        </nav>
    )
}

export default Navbar