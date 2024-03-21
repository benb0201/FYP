import axios from "axios";

const ITINERARY_API_BASE_URL = `${
  process.env.REACT_APP_BACKEND_URL || "http://localhost:8080"
}/api/v1/itinerary`;

class ItineraryService {
  // Fetch all itineraries for a specific client
  getItineraries(clientId) {
    const url = clientId
      ? `${ITINERARY_API_BASE_URL}?clientId=${clientId}`
      : ITINERARY_API_BASE_URL;
    return axios.get(url);
  }

  // Save a new itinerary
  saveItinerary(itinerary) {
    return axios.post(ITINERARY_API_BASE_URL, itinerary);
  }

  // Update an existing itinerary
  updateItinerary(itineraryId, itinerary) {
    return axios.put(`${ITINERARY_API_BASE_URL}/${itineraryId}`, itinerary);
  }

  // Delete an itinerary
  deleteItinerary(itineraryId) {
    return axios.delete(`${ITINERARY_API_BASE_URL}/${itineraryId}`);
  }
}

export default new ItineraryService();
