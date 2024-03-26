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
            TravelPal aims to provide a platform for users to plan their
            travels, integrating functionalities to create and manage
            itineraries.
          </p>
          <p>
            Initially, TravelPal was ambitious and wanted to go down the road of
            being an all-in-one app that could handle everything. It aimed to
            provide users with the tools to plan trips, create dynamic
            itineraries, customize routes with real-time information, access
            destination-specific weather forecasts, etc. But experience from
            many users tells us that this "jack of all trades" approach can make
            the app less efficient and overwhelming for users.
          </p>
          <p>
            This realization sparked a change in direction. TravelPal is now
            about giving users a straightforward, simplistic app that takes the
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
        {/* <section className={styles.aboutSection}>
          <h3>The Team</h3>
          <p>Benedict Obilom ...</p>
        </section> */}
        <section className={styles.aboutSection}>
          <h3 className={styles.documentationHeader}>
            Want to read up on the Code Documentation?:
          </h3>
          <a
            href="https://benb0201.github.io/travelpal-code-documentation/"
            target="_blank"
            rel="noopener noreferrer" // for security reasons
            className={styles.docLink}
          >
            Link to the Backend Code Documentation webpage
          </a>
        </section>
        <section className={styles.aboutSection}>
          <h3 className={styles.documentationHeader}>Leave some Feedback:</h3>
          <a
            href="https://forms.gle/rk3NfUj6U5v1EHy5A"
            target="_blank"
            rel="noopener noreferrer" // for security reasons
            className={styles.docLink}
          >
            Link to TravelPal Survey :)
          </a>
        </section>
      </div>
    </div>
  );
};

export default About;
