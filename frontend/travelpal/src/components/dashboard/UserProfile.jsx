import React, { useState, useEffect } from "react";
import "./UserProfile.css";
import ClientService from "../../services/ClientService";

const UserProfile = ({ clientId }) => {
  const [clientInfo, setClientInfo] = useState({
    name: "",
    email: "",
    // You can add more fields based on your Client model
  });

  useEffect(() => {
    const fetchClientInfo = async () => {
      try {
        const response = await ClientService.getClients();
        const client = response.data.find((client) => client.id === clientId);
        if (client) {
          setClientInfo(client);
        }
      } catch (err) {
        console.error("Error fetching client info:", err.message);
      }
    };

    fetchClientInfo();
  }, [clientId]);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setClientInfo((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      await ClientService.updateClient(clientId, clientInfo);
      alert("Profile updated successfully!");
    } catch (err) {
      console.error("Error updating client profile:", err.message);
    }
  };

  return (
    <div className="user-profile">
      <form onSubmit={handleSubmit}>
        <div className="form-group">
          <label>Name:</label>
          <input
            type="text"
            name="name"
            value={clientInfo.name || ""}
            onChange={handleChange}
          />
        </div>
        <div className="form-group">
          <label>Email:</label>
          <input
            type="email"
            name="email"
            value={clientInfo.email || ""}
            onChange={handleChange}
          />
        </div>
        {/* Add more input fields as needed */}
        <button type="submit" className="btn-update">
          Update Profile
        </button>
      </form>
    </div>
  );
};

export default UserProfile;
