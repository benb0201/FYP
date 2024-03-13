import "./App.css";
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import hero_image from "./assets/images/plane_window.jpg";
import slider_image1 from "./assets/images/passports.jpg";
import slider_image2 from "./assets/images/climbing.jpg";

import Hero from "./components/Hero";
import Slider from "./components/Slider";
import Navbar from "./components/Navbar";

import Login from "./components/Login";
import Dashboard from "./components/Dashboard";
import UserProfile from "./components/UserProfile";

function App() {
  const preLogin = [
    { url: "/", title: "Home" },
    { url: "/about", title: "About" },
    { url: "/login", title: "Sign Up / Log in" },
  ];

  const postLogin = [
    { url: "/home", title: "Home" },
    { url: "/about", title: "About" },
    { url: "/settings", title: "Profile & Settings" },
    { url: "/", title: "Sign Out" },
  ];

  const [navbarLinks, setNavbarLinks] = useState(preLogin);

  const handleNavbarLinks = () => {
    setNavbarLinks(navbarLinks === preLogin ? postLogin : preLogin);
    // window.location.reload();
  };

  return (
    <Router basename={process.env.PUBLIC_URL}>
      <>
        <Navbar navbarLinks={navbarLinks} />
        <Routes>
          <Route
            path={preLogin[0].url}
            element={
              <>
                <Hero imageSrc={hero_image} />
                <Slider
                  imageSrc={slider_image1}
                  title="Create your itinerary"
                  subtitle="Create and manage itineraries"
                  flipped={true}
                />
                <Slider
                  imageSrc={slider_image2}
                  title="Simplicity"
                  subtitle="Focus on simplicity"
                  flipped={false}
                />
              </>
            }
          />
          <Route
            path={postLogin[0].url}
            element={
              <>
                <Dashboard onHandleNavbarLinks={handleNavbarLinks} />
              </>
            }
          />
          <Route
            path={postLogin[2].url}
            element={
              <>
                <UserProfile />
              </>
            }
          />
          <Route path="/login" element={<Login />} />
        </Routes>
      </>
    </Router>
  );
}

export default App;
