import axios from "axios";

const CLIENT_API_BASE_URL = "http://localhost:8080/api/v1/client";

class ClientService {
  saveClient(client) {
    return axios.post(CLIENT_API_BASE_URL + "/register", client);
  }
  authenticateClient(client) {
    return axios.post(CLIENT_API_BASE_URL + "/login", client);
  }
}

export default new ClientService();
