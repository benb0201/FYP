import "./NewItinerary.css";

const NewItinerary = (props) => {
  return (
    <form className="form">
      <p>
        <label htmlFor="body">Text</label>
        <textarea id="body" required rows={3} onChange={props.onDescChange} />
      </p>
      <p>{props.onDescChange}</p>
      <p>
        <label htmlFor="name">Your name</label>
        <input type="text" id="name" required onChange={props.onTitleChange} />
      </p>
    </form>
  );
};

export default NewItinerary;
