// import { useState } from "react";
// import "./NewItinerary.css";

// const NewItinerary = ({ onCancel, onAddItinerary }) => {
//   const [step, setStep] = useState(1);
//   const [itineraryData, setItineraryData] = useState({
//     name: "",
//     description: "",
//     startDate: "",
//     endDate: "",
//     location: "",
//     notes: "",
//   });

//   const nextStep = () => {
//     setStep(step + 1);
//   };
//   const prevStep = () => {
//     setStep(step - 1);
//   };

//   const changeHandler = (e) => {
//     setItineraryData({ ...itineraryData, [e.target.name]: e.target.value });
//   };

//   const submitHandler = (e) => {
//     e.preventDefault();
//     onAddItinerary(itineraryData);
//     onCancel();
//   };

//   if (step === 1) {
//     return (
//       // Basic Details Form
//       <form className="form" onSubmit={(e) => e.preventDefault()}>
//         <p>
//           <label htmlFor="name">{"Name your Itinerary :)"}</label>
//           <input
//             type="text"
//             name="name"
//             value={itineraryData.name}
//             id="name"
//             required
//             onChange={changeHandler}
//             placeholder="Itinerary Name"
//           />
//         </p>
//         <p>
//           <label htmlFor="body">Give it a description</label>
//           <textarea
//             name="description"
//             value={itineraryData.description}
//             id="body"
//             rows={3}
//             onChange={changeHandler}
//             placeholder="Description"
//           />
//         </p>
//         <p className="actions">
//           <button type="button" onClick={onCancel}>
//             Cancel
//           </button>
//           <button type="button" onClick={nextStep}>
//             Next
//           </button>
//         </p>
//       </form>
//     );
//   } else if (step === 2) {
//     return (
//       // Date and Location Form
//       <form className="form" onSubmit={(e) => e.preventDefault()}>
//         <p>
//           <label htmlFor="name">When does your journey begin and end?</label>
//           <input
//             type="date"
//             name="startDate"
//             value={itineraryData.startDate}
//             onChange={changeHandler}
//           />
//           <input
//             type="date"
//             name="endDate"
//             value={itineraryData.endDate}
//             onChange={changeHandler}
//           />
//         </p>
//         <p>
//           <label htmlFor="body">Location</label>
//           <input
//             type="text"
//             name="location"
//             value={itineraryData.location}
//             onChange={changeHandler}
//             placeholder="Location"
//           />
//         </p>
//         <p className="actions">
//           <button type="button" onClick={onCancel}>
//             Cancel
//           </button>
//           <button type="button" onClick={prevStep}>
//             Back
//           </button>
//           <button type="button" onClick={nextStep}>
//             Next
//           </button>
//         </p>
//       </form>
//     );
//   } else {
//     return (
//       // Notes Form
//       <form className="form" onSubmit={submitHandler}>
//         <p>
//           <label htmlFor="body">Take notes</label>
//           <textarea
//             name="notes"
//             value={itineraryData.notes}
//             rows={8}
//             onChange={changeHandler}
//             placeholder="Notes"
//           />
//         </p>
//         <p className="actions">
//           <button type="button" onClick={onCancel}>
//             Cancel
//           </button>
//           <button type="button" onClick={prevStep}>
//             Back
//           </button>
//           <button type="submit">Submit</button>
//         </p>
//       </form>
//     );
//   }
// };

// export default NewItinerary;

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
      name: enteredTitle,
      description: enteredDesc,
    };
    onAddItinerary(itineraryData);
    onCancel();
  }
  return (
    <form className="form" onSubmit={submitHandler}>
      <p>
        <label htmlFor="name">{"Name your Itinerary :)"}</label>
        <input type="text" id="name" required onChange={titleChangeHandler} />
      </p>
      <p>
        <label htmlFor="body">Give it a description</label>
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
