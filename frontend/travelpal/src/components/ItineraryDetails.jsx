import React, { useState } from "react";
import Modal from "./Modal"; // Assuming Modal is in the same directory
import "./ItineraryDetails.css"; // Create a CSS file for styling if needed

const ItineraryDetails = ({ itinerary, onDelete, onClose, onUpdate }) => {
  const deleteHandler = () => {
    onDelete(itinerary.id, itinerary.name);
    onClose();
  };

  const editHandler = () => {
    onUpdate(itinerary); // For update
    setTimeout(() => onClose(), 0); // A slight delay to ensure NewItinerary gets the data before this modal is closed
  };

  if (!itinerary) return null; // Render nothing if no itinerary is provided

  return (
    <Modal onClose={onClose}>
      <div className="itinerary-details">
        <h2>{itinerary.name}</h2>
        <p>{itinerary.description}</p>
        <div className="itinerary-dates">
          <strong>Start Date:</strong> {itinerary.startDate}
          <br />
          <strong>End Date:</strong> {itinerary.endDate}
        </div>
        <p>
          <strong>Location:</strong> {itinerary.location}
        </p>
        <p>
          <strong>Accommodation:</strong> {itinerary.accommodation}
        </p>
        <p>
          <strong>Accommodation Cost:</strong> €{itinerary.accommodationCost}
        </p>
        <p>
          <strong>Total Cost:</strong> €{itinerary.estimatedCost}
        </p>
        <p>
          <strong>Notes:</strong> {itinerary.notes}
        </p>
        <div className="button-container">
          <div className="edit-buttons">
            <button id="delete" onClick={deleteHandler}>
              Delete
            </button>
            <button id="edit" onClick={editHandler}>
              Edit
            </button>
          </div>
          <button id="close" onClick={onClose}>
            Close
          </button>
        </div>
      </div>
    </Modal>
  );
};

export default ItineraryDetails;
