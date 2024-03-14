// NewItineraryActivity.jsx
import React, { useState } from "react";
import "./NewItinerary.css";

const NewActivity = ({ activity, onUpdateActivity, onRemove }) => {
  const [localActivity, setLocalActivity] = useState(activity);
  const [collapsed, setCollapsed] = useState(true);

  const handleCollapse = () => {
    setCollapsed(true);
  };
  const handleChange = (e) => {
    const { name, value } = e.target;
    const updatedActivity = {
      ...localActivity,
      [name]: name === "cost" ? parseFloat(value) || 0 : value,
    };
    setLocalActivity(updatedActivity);
    onUpdateActivity(updatedActivity);
  };

  return (
    <div className="activity-input-group">
      <button
        type="button"
        className="toggle-activity-btn"
        onClick={() => setCollapsed(!collapsed)}
      >
        {collapsed ? "Expand" : "Collapse"} Activity
      </button>

      {!collapsed && (
        <>
          <label htmlFor="name">Activity Name</label>
          <input
            type="text"
            name="name"
            placeholder="Activity Name"
            value={localActivity.name}
            onChange={handleChange}
          />
          <label htmlFor="description">Describe It</label>
          <textarea
            name="description"
            placeholder="Activity Description"
            value={localActivity.description}
            onChange={handleChange}
          />
          <label htmlFor="location">Where will it be taking place?</label>
          <input
            type="text"
            name="location"
            placeholder="Activity Location"
            value={localActivity.location}
            onChange={handleChange}
          />
          <label htmlFor="cost">Activity Cost</label>
          <input
            type="number"
            name="cost"
            placeholder="Activity Cost"
            value={localActivity.cost}
            onChange={handleChange}
          />
          <button
            type="button"
            onClick={handleCollapse}
            className="confrim-activity-btn"
          >
            Confirm Activity
          </button>
        </>
      )}

      <button type="button" onClick={onRemove} className="remove-activity-btn">
        Remove Activity
      </button>
    </div>
  );
};

export default NewActivity;
