import "./Itinerary.css";
import planeImg from "../assets/images/plane_window.jpg";
function Itinerary({ name, description }) {
  return (
    <div className="itinerary">
      <img className="itThumbnail" src={planeImg} alt="img" />
      <div className="itPreview">
        <h4 className="itTitle">{name}</h4>
        <p className="itDesc">{description}</p>
        <a href="#">View Itinerary</a>
      </div>
    </div>
  );
}

export default Itinerary;
