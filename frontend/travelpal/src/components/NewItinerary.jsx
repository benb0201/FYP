import { useState } from "react";
import "./NewItinerary.css";

const NewItinerary = ({ onCancel, onAddItinerary }) => {
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
  function submitHandler(event) {
    event.preventDefault();
    const itineraryData = {
      // id: Math.random().toString(),
      title: enteredTitle,
      desc: enteredDesc,
    };
    onAddItinerary(itineraryData);
    onCancel();
  }
  return (
    <form className="form" onSubmit={submitHandler}>
      <p>
        <label htmlFor="name">Trip name</label>
        <input type="text" id="name" required onChange={titleChangeHandler} />
      </p>
      <p>
        <label htmlFor="body">Trip description</label>
        <textarea id="body" required rows={3} onChange={descChangeHandler} />
      </p>
      <p className="actions">
        <button type="button" onClick={onCancel}>
          Cancel
        </button>
        <button type="submit">Submit</button>
      </p>
    </form>
  );
};

export default NewItinerary;
