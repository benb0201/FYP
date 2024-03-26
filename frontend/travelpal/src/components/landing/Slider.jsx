import React from "react";
import "./Slider.css";
import { useInView } from "react-intersection-observer";
import { useNavigate } from "react-router-dom";

const Slider = ({ imageSrc, title, subtitle, flipped }) => {
  const { ref, inView } = useInView({
    threshold: 0.4,
  });
  const navigate = useNavigate(); //this function will help me use react router to navigate

  const renderContent = () => {
    const content = (
      <>
        <h1 className="slider_title">{title}</h1>
        <p className="slider_subtitle">{subtitle}</p>
        <button
          className="get_started_button"
          onClick={() => navigate("/login")}
        >
          Get Started
        </button>
      </>
    );

    if (flipped) {
      return (
        <>
          <img src={imageSrc} alt="Travel" className="slider_image" />
          <div className="slider_content">{content}</div>
        </>
      );
    } else {
      return (
        <>
          <div className="slider_content">{content}</div>
          <img src={imageSrc} alt="Travel" className="slider_image" />
        </>
      );
    }
  };

  return (
    <div className={inView ? "slider slider_zoom" : "slider"} ref={ref}>
      {renderContent()}
    </div>
  );
};

export default Slider;
