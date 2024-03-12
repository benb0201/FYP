import "./Itinerary.css";
import planeImg from "../assets/images/plane_window.jpg";

function Itinerary({ name, description, totalCost, onClick }) {
  return (
    <div className="itinerary" onClick={onClick}>
      <img className="itThumbnail" src={planeImg} alt="Plane window view" />
      <div className="itPreview">
        <h4 className="itTitle">{name}</h4>
        <p className="itDesc">{description}</p>
        <div className="itTotalCost">Total Cost: €{totalCost}</div>
      </div>
    </div>
  );
}

export default Itinerary;
