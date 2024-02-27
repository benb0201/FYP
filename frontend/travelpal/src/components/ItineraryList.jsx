import { useState } from "react";
import Itinerary from "./Itinerary";
import "./ItineraryList.css";
import NewItinerary from "./NewItinerary";
import Modal from "./Modal";

const ItineraryList = ({ isCreating, onStopCreating, onStartCreating }) => {
  const [itineraries, setItineraries] = useState([]);
  function addItineraryHandler(itineraryData) {
    setItineraries((existingItineraries) => [
      itineraryData,
      ...existingItineraries,
    ]);
  }
  return (
    <>
      {isCreating ? (
        <Modal onClose={onStopCreating}>
          <NewItinerary
            onCancel={onStopCreating}
            onAddItinerary={addItineraryHandler}
          />
        </Modal>
      ) : null}
      <div className="itinerary-wrapper">
        <h2 className="heading">My Itineraries</h2>
        {itineraries.length <= 3 ? (
          <div className="itinerary-slider">
            {itineraries.length < 1 ? (
              <div style={{ textAlign: "center" }}>
                <h2>You have no itineraries yet</h2>
                <p>Start creating some!</p>
              </div>
            ) : (
              itineraries.map((itinerary) => (
                <Itinerary title={itinerary.title} desc={itinerary.desc} />
              ))
            )}
          </div>
        ) : (
          <div className="itinerary-slider2">
            {itineraries.length < 1 ? (
              <div style={{ textAlign: "center" }}>
                <h2>You have no itineraries yet</h2>
                <p>Start creating some!</p>
              </div>
            ) : (
              itineraries.map((itinerary) => (
                <Itinerary title={itinerary.title} desc={itinerary.desc} />
              ))
            )}
          </div>
        )}

        <button className="add-itinerary-button" onClick={onStartCreating}>
          Create New Itinerary
        </button>
      </div>
    </>
  );
};
{
  /* <Itinerary
            title="Trip Title"
            desc="This is some text. Some more text"
          /> */
}

export default ItineraryList;
