import React from "react";
import "./Hero.css";

const Hero = function ({ imageSrc }) {
  return (
    <div className="hero">
      <img src={imageSrc} alt="Travel" className="hero_image" />
      <h1 className="hero_title">Easy travels</h1>{" "}
      {/* Randomly generated planning quotes (future implementation) */}
      <p className="scroll_prompt">Scroll for more</p> {/* Scroll prompt */}
    </div>
  );
};

export default Hero;
