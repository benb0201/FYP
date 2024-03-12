import { useState, useEffect } from "react";
import "./NewItinerary.css";

const NewItinerary = ({
  onCancel,
  onAddItinerary,
  onUpdateItinerary,
  itinerary,
}) => {
  const [step, setStep] = useState(1);
  const [tempItinerary, setTempItinerary] = useState(itinerary);
  const [itineraryData, setItineraryData] = useState({
    name: "",
    description: "",
    startDate: "",
    endDate: "",
    location: "",
    notes: "",
    accommodation: "",
    accommodationCost: 0,
  });

  useEffect(() => {
    if (itinerary) {
      // If an itinerary prop is passed, we're in edit mode
      setItineraryData(itinerary); // Pre-fill the form with itinerary data
      setStep(1); // Reset to the first step or to a specific step as needed
    }
  }, [itinerary]);

  const nextStep = () => {
    setStep(step + 1);
  };
  const prevStep = () => {
    setStep(step - 1);
  };

  // const changeHandler = (e) => {
  //   setItineraryData({ ...itineraryData, [e.target.name]: e.target.value });
  // };

  const changeHandler = (e) => {
    const { name, value } = e.target;
    if (name === "accommodationCost") {
      setItineraryData({ ...itineraryData, [name]: parseFloat(value) || 0 });
    } else {
      setItineraryData({ ...itineraryData, [name]: value });
    }
  };

  const submitHandler = (e) => {
    e.preventDefault();
    if (tempItinerary) {
      // Update existing itinerary
      onUpdateItinerary({ ...itineraryData, id: tempItinerary.id });
    } else {
      // Add new itinerary
      onAddItinerary(itineraryData);
    }
    onCancel();
  };

  if (step === 1) {
    return (
      // Basic Details Form
      <form className="form" onSubmit={(e) => e.preventDefault()}>
        <p>
          <label htmlFor="name">{"Name your Itinerary :)"}</label>
          <input
            type="text"
            name="name"
            value={itineraryData.name}
            id="name"
            required
            onChange={changeHandler}
            placeholder="Itinerary Name"
          />
        </p>
        <p>
          <label htmlFor="body">Give it a description</label>
          <textarea
            name="description"
            value={itineraryData.description}
            id="body"
            rows={3}
            onChange={changeHandler}
            placeholder="Description"
          />
        </p>
        <p className="actions">
          <button type="button" onClick={onCancel}>
            Cancel
          </button>
          <button type="button" onClick={nextStep}>
            Next
          </button>
        </p>
      </form>
    );
  } else if (step === 2) {
    return (
      // Date and Location Form
      <form className="form" onSubmit={(e) => e.preventDefault()}>
        <p>
          <label htmlFor="name">When does your journey begin and end?</label>
          <input
            type="date"
            name="startDate"
            value={itineraryData.startDate}
            onChange={changeHandler}
          />
          <input
            type="date"
            name="endDate"
            value={itineraryData.endDate}
            onChange={changeHandler}
          />
        </p>
        <p>
          <label htmlFor="body">Location</label>
          <input
            type="text"
            name="location"
            value={itineraryData.location}
            onChange={changeHandler}
            placeholder="Location"
          />
        </p>
        <p className="actions">
          <button type="button" onClick={onCancel}>
            Cancel
          </button>
          <button type="button" onClick={prevStep}>
            Back
          </button>
          <button type="button" onClick={nextStep}>
            Next
          </button>
        </p>
      </form>
    );
  } else if (step === 3) {
    // New Step for Accommodation and Cost
    return (
      <form className="form" onSubmit={(e) => e.preventDefault()}>
        <p>
          <label htmlFor="accommodation">Accommodation</label>
          <input
            type="text"
            name="accommodation"
            value={itineraryData.accommodation}
            onChange={changeHandler}
            placeholder="Accommodation"
          />
        </p>
        <p>
          <label htmlFor="accommodationCost">Accommodation Cost</label>
          <input
            type="number"
            name="accommodationCost"
            value={itineraryData.accommodationCost}
            onChange={changeHandler}
            placeholder="Accommodation Cost"
          />
        </p>
        <p className="actions">
          <button type="button" onClick={onCancel}>
            Cancel
          </button>
          <button type="button" onClick={prevStep}>
            Back
          </button>
          <button type="button" onClick={nextStep}>
            Next
          </button>
        </p>
      </form>
    );
  } else {
    return (
      // Notes Form
      <form className="form" onSubmit={submitHandler}>
        <p>
          <label htmlFor="body">Take notes</label>
          <textarea
            name="notes"
            value={itineraryData.notes}
            rows={8}
            onChange={changeHandler}
            placeholder="Notes"
          />
        </p>
        <p className="actions">
          <button type="button" onClick={onCancel}>
            Cancel
          </button>
          <button type="button" onClick={prevStep}>
            Back
          </button>
          <button type="submit">Submit</button>
        </p>
      </form>
    );
  }
};

export default NewItinerary;
