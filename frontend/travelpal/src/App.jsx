import './App.css';
import hero_image from './assets/images/plane_window.jpg'
import slider_image1 from './assets/images/passports.jpg'
import slider_image2 from './assets/images/climbing.jpg'

import Hero from './components/Hero';
import Slider from './components/Slider';
import Navbar from './components/Navbar';
// import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
function App() {
  const navbarLinks = [
    {url: '/home', title: 'Home'},
    {url: '/plan', title: 'Plan'},
    {url: '/about', title: 'About'},
    {url: '/sign-up', title: 'Sign Up / Log in'}
  ]
  return (
    <>
    <Navbar navbarLinks={navbarLinks}/>
    <Hero imageSrc={hero_image}/>
    <Slider imageSrc={slider_image1}
     title='Create your itinerary'
     subtitle='Create and manage itineraries'
      flipped={true}
      />
     <Slider imageSrc={slider_image2}
      title='Discover'
     subtitle='Discover new locations'
      flipped={false}
      />
    </>
  );
}

export default App;
