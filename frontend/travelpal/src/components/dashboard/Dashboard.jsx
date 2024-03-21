import React, { useEffect, useState } from "react";
import ClientService from "../../services/ClientService";
import ItineraryList from "./ItineraryList";
import DashboardHeader from "./DashboardHeader";
import "./Dashboard.css";

const Dashboard = () => {
  const [modalIsVisible, setModalIsVisible] = useState(false);
  const [clientName, setClientName] = useState("");

  useEffect(() => {
    const fetchClientDetails = async () => {
      const clientId = localStorage.getItem("clientId");
      console.log(clientId);
      if (clientId) {
        try {
          const response = await ClientService.getClient(clientId);
          console.log(response.data);
          console.log(response.data.name);
          setClientName(response.data.name); // Assuming the response has a data object with a name property
          console.log(clientName);
        } catch (error) {
          console.error("Error fetching client details:", error);
        }
      }
    };
    fetchClientDetails();
  }, []);

  function showModalHandler() {
    setModalIsVisible(true);
  }

  function hideModalHandler() {
    setModalIsVisible(false);
  }

  return (
    <>
      <DashboardHeader clientName={clientName} />
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
