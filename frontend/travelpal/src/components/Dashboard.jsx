import React, { useEffect, useState } from "react";
import ItineraryList from "./ItineraryList";
import DashboardHeader from "./DashboardHeader";
import "./Dashboard.css";
import planeImg from "../assets/images/plane_window.jpg";

const Dashboard = ({ handleNavbarLinks }) => {
  useEffect(() => {
    // This code will run when the component mounts
    // console.log(handleNavbarLinks());
  }); //, [handleNavbarLinks]); // Include handleNavbarLinks as a dependency

  const [itineraries, setItineraries] = useState([]);

  // Function to add a new itinerary
  const addItinerary = () => {
    const newItinerary = {
      // Include necessary details for an itinerary
      // Example: name, date, locations, etc.
    };

    setItineraries([...itineraries, newItinerary]);
  };

  const [modalIsVisible, setModalIsVisible] = useState(false);

  function showModalHandler() {
    setModalIsVisible(true);
  }

  function hideModalHandler() {
    setModalIsVisible(false);
  }

  return (
    <>
      <DashboardHeader />
      <div className="background">
        <ItineraryList
          isCreating={modalIsVisible}
          onStartCreating={showModalHandler}
          onStopCreating={hideModalHandler}
        />
      </div>
    </>
  );
};

export default Dashboard;

/*               
<div className="itinerary-slider">
                {itineraries.length === 0 ? (
                  <p className="empty-slider-message">
                    No itineraries yet. Create one!
                  </p>
                ) : (
                  // Render your slider with itineraries
                  // Example: Map through itineraries and display them in the slider
                  itineraries.map((itinerary, index) => (
                    <div key={index} className="itinerary-card">
                      {/* Render the details of each itinerary here /}
                      <h3>{itinerary.name}</h3>
                      {/* Include other details like date, locations, etc. /}
                    </div>
                  ))
                )}
              </div> 
*/
