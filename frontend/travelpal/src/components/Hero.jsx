import React from 'react'
import './Hero.css'

const Hero = function ({imageSrc}) {
  return (
    <div className="hero">
    <img src={imageSrc} alt="Travel" className='hero_image' />
    <h1 className="hero_title" >Travel made simple</h1>
    </div>
  )
}

export default Hero