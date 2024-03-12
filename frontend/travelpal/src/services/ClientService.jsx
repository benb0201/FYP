import axios from "axios";

const CLIENT_API_BASE_URL = process.env.REACT_APP_API || "http://localhost:8080/api/v1/client";
console.log(CLIENT_API_BASE_URL);

class ClientService {
  saveClient(client) {
    return axios.post(CLIENT_API_BASE_URL + "/register", client);
  }
  authenticateClient(client) {
    return axios.post(CLIENT_API_BASE_URL + "/login", client);
  }
}

export default new ClientService();
