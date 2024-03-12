import axios from "axios";

const CLIENT_API_BASE_URL = process.env.REACT_APP_API || "http://localhost:8080/api/v1/client";
console.log(CLIENT_API_BASE_URL);

class ClientService {
  // Save a new client
  saveClient(client) {
    return axios.post(CLIENT_API_BASE_URL + "/register", client);
  }
  // Authenticate an existing client
  authenticateClient(client) {
    return axios.post(CLIENT_API_BASE_URL + "/login", client);
  }
  // Fetch all clients
  getClients() {
    return axios.get(CLIENT_API_BASE_URL);
  }

  // Delete a client by ID
  deleteClient(clientId) {
    return axios.delete(CLIENT_API_BASE_URL + "/" + clientId);
  }

  // Update a client's information
  updateClient(clientId, client) {
    return axios.put(CLIENT_API_BASE_URL + "/" + clientId, client);
  }
}

export default new ClientService();
