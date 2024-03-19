import React from "react";
import styles from "./About.module.css";

const About = () => {
  return (
    <div className={styles.greetingWrapper}>
      <h2 className={styles.heading}>About travelpal</h2>
      <div className={styles.aboutWrapper}>
        <section className={styles.aboutSection}>
          <h3>Purpose & Motivation</h3>
          <p>
            Inspired by a previously proposed Weather Forecast application,
            TravelPal aims to provide a platform for users to plan their
            travels, integrating functionalities to create and manage
            itineraries.
          </p>
          <p>
            Initially, TravelPal was ambitious and wanted to go down the same
            road to create an all-in-one app that could handle everything. It
            aimed to provide users with the tools to plan trips, create dynamic
            itineraries, customize routes with real-time information, access
            destination-specific weather forecasts, etc, etc, etc. But I quickly
            realized that this "jack of all trades" approach might make the app
            less efficient and overwhelming for users.
          </p>
          <p>
            This realization sparked a change in direction. TravelPal is now
            about giving users a straightforward, easy-to-use app that takes the
            stress out of travel planning. It's about doing less, but better.
          </p>
        </section>
        <section className={styles.aboutSection}>
          <h3>Core Features</h3>
          <ul>
            <li>Seamless Itinerary Creation</li>
            <li>Displaying Itinerary Details</li>
            <li>Intuitive User Experience</li>
          </ul>
        </section>
        <section className={styles.aboutSection}>
          <h3>The Team</h3>
          <p>Benedict Obilom ...</p>
        </section>
      </div>
    </div>
  );
};

export default About;
