import React, { useEffect, useState } from "react";
import ClientService from "../../services/ClientService";
import ItineraryService from "../../services/ItineraryService";
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
          setClientName(response.data.name); // Assuming the response has a data object with a name property
          console.log(clientName);
        } catch (error) {
          console.error("Error fetching client details:", error);
        }
      }
    };
    fetchClientDetails();
  }, []);

  const createSampleItineraryHandler = async () => {
    const clientId = localStorage.getItem("clientId");
    const sampleItinerary = {
      name: "Family trip to the Netherlands (Sample)",
      description:
        "Travelling with the family for the summer. A much needed break!",
      startDate: "2025-06-15",
      endDate: "2025-06-22",
      location: "Amsterdam",
      notes: "Don't forget to bring dad's camera!",
      accommodation: "Eden Hotel Amsterdam",
      accommodationCost: 304,
      client: { id: clientId },
      activities: [
        {
          name: "Sight seeing",
          description: "Exploring popular monuments",
          location: "Amsterdam",
          cost: 20,
        },
        {
          name: "Bowling",
          description: "I stay winning",
          location: "Race Planet Amsterdam",
          cost: 35,
        },
      ],
    };

    try {
      await ItineraryService.saveItinerary(sampleItinerary);
      window.location.reload();
      console.log("Sample itinerary created successfully!");
    } catch (err) {
      console.error("Error creating sample itinerary:", err.message);
    }
  };

  function showModalHandler() {
    setModalIsVisible(true);
  }

  function hideModalHandler() {
    setModalIsVisible(false);
  }

  return (
    <>
      <DashboardHeader
        clientName={clientName}
        onCreateSampleItinerary={createSampleItineraryHandler}
      />
      <div className="background">
        <ItineraryList
          isCreating={modalIsVisible}
          onStartCreating={showModalHandler}
          onStopCreating={hideModalHandler}
        />
      </div>
      <section className="aboutSection">
        <h3 className="documentationHeader">Leave some Feedback:</h3>
        <a
          href="https://forms.gle/rk3NfUj6U5v1EHy5A"
          target="_blank"
          rel="noopener noreferrer" // for security reasons
          className="docLink"
        >
          Link to TravelPal Survey :)
        </a>
      </section>
    </>
  );
};

export default Dashboard;
