import React, { useEffect, useState } from "react";
import ItineraryList from "./ItineraryList";
import DashboardHeader from "./DashboardHeader";
import "./Dashboard.css";

const Dashboard = () => {
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
