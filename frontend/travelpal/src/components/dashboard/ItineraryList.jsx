import { useState, useEffect } from "react";
import ItineraryService from "../../services/ItineraryService";
import Itinerary from "./Itinerary";
import "./ItineraryList.css";
import NewItinerary from "../NewItinerary";
import ItineraryDetails from "./ItineraryDetails";
import Modal from "../common/Modal";

const ItineraryList = ({ isCreating, onStopCreating, onStartCreating }) => {
  const [itineraries, setItineraries] = useState([]);
  const [selectedItinerary, setSelectedItinerary] = useState(null);

  // Defining fetchItineraries outside of useEffect to make it reusable
  const fetchItineraries = async () => {
    try {
      const clientId = localStorage.getItem("clientId");
      const response = await ItineraryService.getItineraries(clientId);
      // Reverse the fetched itineraries before setting the state (so they appear as latest first)
      setItineraries(response.data.reverse());
    } catch (err) {
      console.log(err);
      alert("Issues recieving itinerary data: " + err.message);
    }
  };

  useEffect(() => {
    // Call the async function
    fetchItineraries();
  }, []); // Empty dependency array means this runs once on component mount

  const editingHandler = (itinerary) => {
    setSelectedItinerary(itinerary);
    onStartCreating(); // Assuming onStartCreating can now handle edit mode too
  };

  const addItineraryHandler = async (itineraryData) => {
    try {
      await ItineraryService.saveItinerary(itineraryData);
      const response = await ItineraryService.getItineraries();
      const newItineraryWithId = response.data[response.data.length - 1];
      setItineraries((existingItineraries) => [
        newItineraryWithId,
        ...existingItineraries,
      ]);
      console.log(`newItineraryWithId: ${JSON.stringify(newItineraryWithId)}`);
    } catch (err) {
      console.log(err);
      alert("Issues saving itinerary: " + err.message);
    }
  };

  const updateItineraryHandler = async (updatedItinerary) => {
    try {
      await ItineraryService.updateItinerary(
        updatedItinerary.id,
        updatedItinerary
      );
      // Update the itineraries array with the updated itinerary
      setItineraries(
        itineraries.map((itinerary) =>
          itinerary.id === updatedItinerary.id
            ? { updatedItinerary }
            : itinerary
        )
      );
      window.location.reload(); //Temporarily added for update
    } catch (err) {
      console.error("Issues updating itinerary: ", err.message);
      alert("Issues updating itinerary: " + err.message);
    }
  };

  const deleteItineraryHandler = async (itineraryId, itinerarytitle) => {
    try {
      const response = await ItineraryService.deleteItinerary(itineraryId);
      setItineraries(
        itineraries.filter((itinerary) => itinerary.id !== itineraryId)
      );
      alert(`Deleted Itinerary: ${itinerarytitle}`);
    } catch (err) {
      console.log(err);
      alert("Issues deleting itinerary: " + err.message);
    }
  };

  const calculateDaysUntilStart = (startDate) => {
    const now = new Date();
    const start = new Date(startDate);
    return Math.max(Math.ceil((start - now) / (1000 * 60 * 60 * 24)), 0); // Ensure it's at least 0
  };

  const calculateTripDuration = (startDate, endDate) => {
    const start = new Date(startDate);
    const end = new Date(endDate);
    return Math.ceil((end - start) / (1000 * 60 * 60 * 24));
  };

  const selectItinerary = (itinerary) => {
    setSelectedItinerary(itinerary);
  };

  const closeDetailsHandler = () => {
    setSelectedItinerary(null);
  };

  return (
    <>
      {isCreating ? (
        <Modal onClose={onStopCreating}>
          <NewItinerary
            onCancel={onStopCreating}
            onAddItinerary={addItineraryHandler}
            onUpdateItinerary={updateItineraryHandler} //For update
            itinerary={selectedItinerary} //For update
          />
        </Modal>
      ) : null}
      <div className="itinerary-wrapper">
        <h2 className="heading">My Itineraries</h2>
        <div
          className={
            itineraries.length <= 3 ? "itinerary-slider" : "itinerary-slider2"
          }
        >
          {itineraries.length === 0 ? (
            <div style={{ textAlign: "center" }}>
              <h2>You have no itineraries yet</h2>
              <p>Start creating some!</p>
            </div>
          ) : (
            itineraries.map((itinerary) => (
              <Itinerary
                key={itinerary.id} // Assuming each itinerary has a unique id for React keys
                name={itinerary.name}
                description={itinerary.description}
                totalCost={itinerary.estimatedCost}
                daysUntilStart={calculateDaysUntilStart(itinerary.startDate)}
                tripDuration={calculateTripDuration(
                  itinerary.startDate,
                  itinerary.endDate
                )}
                onClick={() => selectItinerary(itinerary)} // Pass the function to select an itinerary
              />
            ))
          )}
        </div>
        <button className="add-itinerary-button" onClick={onStartCreating}>
          Create New Itinerary
        </button>
      </div>
      {selectedItinerary && (
        <ItineraryDetails
          itinerary={selectedItinerary}
          onDelete={deleteItineraryHandler}
          onClose={closeDetailsHandler}
          onUpdate={editingHandler} //For update
        />
      )}
    </>
  );
};

export default ItineraryList;
