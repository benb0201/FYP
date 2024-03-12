import React, { useEffect, useState } from "react";
import ItineraryList from "./ItineraryList";
import DashboardHeader from "./DashboardHeader";
import "./Dashboard.css";

const Dashboard = ({ onHandleNavbarLinks }) => {
  useEffect(() => {
    // This code will run when the component mounts
    console.log(onHandleNavbarLinks());
  }, []);

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
