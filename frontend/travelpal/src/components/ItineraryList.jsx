// import { useState, useEffect } from "react";
// import ItineraryService from "../services/ItineraryService";
// import Itinerary from "./Itinerary";
// import "./ItineraryList.css";
// import NewItinerary from "./NewItinerary";
// import Modal from "./Modal";

// const ItineraryList = ({ isCreating, onStopCreating, onStartCreating }) => {
//   const [itineraries, setItineraries] = useState([]);
//   useEffect(() => {
//     const fetchItineraries = async () => {
//       try {
//         const response = await ItineraryService.getItineraries();
//         // Reverse the fetched itineraries before setting the state (so they appear as latest first)
//         setItineraries(response.data.reverse());
//       } catch (err) {
//         console.log(err);
//         alert("Issues recieving itinerary data: " + err.message);
//       }
//     };
//     // Call the async function
//     fetchItineraries();
//   }, []); // Empty dependency array means this runs once on component mount

//   async function addItineraryHandler(itineraryData) {
//     try {
//       await ItineraryService.saveItinerary(itineraryData);
//       setItineraries((existingItineraries) => [
//         itineraryData,
//         ...existingItineraries,
//       ]);
//     } catch (err) {
//       console.log(err);
//       alert("Issues saving itinerary: " + err.message);
//     }
//   }
//   return (
//     <>
//       {isCreating ? (
//         <Modal onClose={onStopCreating}>
//           <NewItinerary
//             onCancel={onStopCreating}
//             onAddItinerary={addItineraryHandler}
//           />
//         </Modal>
//       ) : null}
//       <div className="itinerary-wrapper">
//         <h2 className="heading">My Itineraries</h2>
//         {itineraries.length <= 3 ? (
//           <div className="itinerary-slider">
//             {itineraries.length < 1 ? (
//               <div style={{ textAlign: "center" }}>
//                 <h2>You have no itineraries yet</h2>
//                 <p>Start creating some!</p>
//               </div>
//             ) : (
//               itineraries.map((itinerary) => (
//                 <Itinerary
//                   name={itinerary.name}
//                   description={itinerary.description}
//                 />
//               ))
//             )}
//           </div>
//         ) : (
//           <div className="itinerary-slider2">
//             {itineraries.length < 1 ? (
//               <div style={{ textAlign: "center" }}>
//                 <h2>You have no itineraries yet</h2>
//                 <p>Start creating some!</p>
//               </div>
//             ) : (
//               itineraries.map((itinerary) => (
//                 <Itinerary
//                   name={itinerary.name}
//                   description={itinerary.description}
//                 />
//               ))
//             )}
//           </div>
//         )}

//         <button className="add-itinerary-button" onClick={onStartCreating}>
//           Create New Itinerary
//         </button>
//       </div>
//     </>
//   );
// };

// export default ItineraryList;

import { useState, useEffect } from "react";
import ItineraryService from "../services/ItineraryService";
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
                <Itinerary
                  name={itinerary.name}
                  description={itinerary.description}
                />
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
                <Itinerary
                  name={itinerary.name}
                  description={itinerary.description}
                />
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

export default ItineraryList;
