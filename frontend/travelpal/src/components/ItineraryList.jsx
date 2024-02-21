import { useState } from "react";
import Itinerary from "./Itinerary";
import "./ItineraryList.css";
import NewItinerary from "./NewItinerary";
import Modal from "./Modal";

const ItineraryList = ({ isCreating, onStopCreating, onStartCreating }) => {
  const [enteredTitle, setEnteredTitle] = useState("Trip Title");
  const [enteredDesc, setEnteredDesc] = useState(
    "This is some text. Some more text"
  );

  function titleChangeHandler(event) {
    setEnteredTitle(event.target.value);
  }
  function descChangeHandler(event) {
    setEnteredDesc(event.target.value);
  }
  return (
    <>
      {isCreating ? (
        <Modal onClose={onStopCreating}>
          <NewItinerary
            onTitleChange={titleChangeHandler}
            onDescChange={descChangeHandler}
          />
        </Modal>
      ) : null}
      <div className="itinerary-wrapper">
        <h2 className="heading">My Itineraries</h2>
        <div className="itinerary-slider">
          {/*Placeholder Itineraries */}
          <Itinerary title={enteredTitle} desc={enteredDesc} />
          <Itinerary
            title="Trip Title"
            desc="This is some text. Some more text"
          />
          <Itinerary
            title="Trip Title"
            desc="This is some text. Some more text"
          />
          <Itinerary
            title="Trip Title"
            desc="This is some text. Some more text"
          />
          <Itinerary
            title="Trip Title"
            desc="This is some text. Some more text"
          />
        </div>

        <button className="add-itinerary-button" onClick={onStartCreating}>
          Create New Itinerary
        </button>
      </div>
    </>
  );
};

export default ItineraryList;
