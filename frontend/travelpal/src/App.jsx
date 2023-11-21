import './App.css';
import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'

import hero_image from './assets/images/plane_window.jpg'
import slider_image1 from './assets/images/passports.jpg'
import slider_image2 from './assets/images/climbing.jpg'

import Hero from './components/Hero';
import Slider from './components/Slider';
import Navbar from './components/Navbar';

import Login from './components/Login';

function App() {
  const navbarLinks = [
    {url: '/', title: 'Home'},
    {url: '/plan', title: 'Plan'},
    {url: '/about', title: 'About'},
    {url: '/login', title: 'Sign Up / Log in'}
  ]
  return (
    <Router>
      <>
        <Navbar navbarLinks={navbarLinks} />
        <Routes>
          <Route
            exact
            path='/'
            element={
              <>
                <Hero imageSrc={hero_image} />
                <Slider
                  imageSrc={slider_image1}
                  title='Create your itinerary'
                  subtitle='Create and manage itineraries'
                  flipped={true}
                />
                <Slider
                  imageSrc={slider_image2}
                  title='Discover'
                  subtitle='Discover new locations'
                  flipped={false}
                />
              </>
            }
          />
          <Route path='/login' element={<Login />} />
        </Routes>
      </>
    </Router>
  );
}

export default App;
