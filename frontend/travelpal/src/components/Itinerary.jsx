import "./Itinerary.css";
import planeImg from "../assets/images/plane_window.jpg";
function Itinerary({ title, desc }) {
  return (
    <div className="itinerary">
      <img className="itThumbnail" src={planeImg} alt="img" />
      <div className="itPreview">
        <h4 className="itTitle">{title}</h4>
        <p className="itDesc">{desc}</p>
        <a href="#">View Itinerary</a>
      </div>
    </div>
  );
}

export default Itinerary;