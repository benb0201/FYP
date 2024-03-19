import React from "react";
import { Link } from "react-router-dom";
import "./Navbar.css";
import { useState } from "react";
import { FiMenu, FiX } from "react-icons/fi";

const Navbar = ({ navbarLinks, onLogout }) => {
  const [menuClicked, setMenuClicked] = useState(false);

  const clickMenuHandler = () => {
    setMenuClicked(!menuClicked);
  };

  const handleItemClick = (item) => {
    if (item.title === "Sign Out") {
      onLogout && onLogout(); // Call onLogout if it's provided and item is "Sign Out"
    }
  };

  return (
    <nav className="navbar">
      <span className="navbar_logo">travelpal</span>
      {menuClicked ? (
        <FiX size={25} className="navbar_menu" onClick={clickMenuHandler} />
      ) : (
        <FiMenu size={25} className="navbar_menu" onClick={clickMenuHandler} />
      )}
      <ul className={menuClicked ? "navbar_list--active" : "navbar_list"}>
        {navbarLinks.map((item) => {
          return (
            <li
              className="navbar_item"
              key={item.title}
              onClick={() => handleItemClick(item)}
            >
              {/* Use Link for navigation or span for action */}
              {item.title !== "Sign Out" ? (
                <Link to={item.url} className="navbar_link">
                  {item.title}
                </Link>
              ) : (
                <span className="navbar_link">{item.title}</span>
              )}
            </li>
          );
        })}
      </ul>
    </nav>
  );
};

export default Navbar;
