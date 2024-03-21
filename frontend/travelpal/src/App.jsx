import "./App.css";
import React, { useState, useEffect } from "react";
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { AuthProvider, useAuth } from "./components/AuthContext";

import ProtectedRoute from "./components/ProtectedRoute";

import hero_image from "./assets/images/plane_window.jpg";
import slider_image1 from "./assets/images/passports.jpg";
import slider_image2 from "./assets/images/climbing.jpg";

import Hero from "./components/landing/Hero";
import Slider from "./components/landing/Slider";
import NavbarLinks from "./components/common/NavBarLinks";

import Login from "./components/authentication/Login";
import Dashboard from "./components/dashboard/Dashboard";
import UserSettings from "./components/dashboard/UserSettings";
import About from "./components/common/About";

function App() {
  return (
    <AuthProvider>
      <Router basename={process.env.PUBLIC_URL}>
        <NavbarLinks />
        <Routes>
          <Route
            path="/"
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
          <Route path="/about" element={<About />} />
          <Route path="/login" element={<Login />} />
          <Route
            path="/home"
            element={
              <ProtectedRoute>
                <Dashboard />
              </ProtectedRoute>
            }
          />
          <Route
            path="/settings"
            element={
              <ProtectedRoute>
                <UserSettings />
              </ProtectedRoute>
            }
          />
        </Routes>
      </Router>
    </AuthProvider>
  );
}

export default App;
