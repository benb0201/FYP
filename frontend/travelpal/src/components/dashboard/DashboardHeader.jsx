import { MdPostAdd } from "react-icons/md";

import "./DashboardHeader.css";

function DashboardHeader({ clientName, onCreateSampleItinerary }) {
  return (
    <header className="header">
      <h1>{clientName ? `${clientName}'s Dashboard` : "Dashboard"}</h1>
      <button
        onClick={onCreateSampleItinerary}
        className="sample-itinerary-btn"
      >
        + Sample Itinerary
      </button>
    </header>
  );
}

export default DashboardHeader;
