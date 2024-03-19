import React from "react";
import { useNavigate } from "react-router-dom"; // Import useNavigate hook for redirection
import { useAuth } from "../AuthContext"; // Ensure you import useAuth
import Navbar from "./Navbar";

const NavBarLinks = () => {
  const { isAuthenticated, logout } = useAuth(); // Destructure logout from useAuth
  const navigate = useNavigate(); // Hook to programmatically navigate

  const handleLogout = () => {
    logout(); // Call the logout function from your auth context
    navigate("/"); // Redirect user to the home page after logout
  };

  const navbarLinks = isAuthenticated
    ? [
        { url: "/home", title: "Home" },
        { url: "/about", title: "About" },
        { url: "/settings", title: "Profile & Settings" },
        { url: "/", title: "Sign Out", action: handleLogout }, // Modify this to include logout action
      ]
    : [
        { url: "/", title: "Home" },
        { url: "/about", title: "About" },
        { url: "/login", title: "Sign Up / Log in" },
      ];

  // Modify Navbar component to handle actions if provided
  return <Navbar navbarLinks={navbarLinks} onLogout={handleLogout} />;
};

export default NavBarLinks;
