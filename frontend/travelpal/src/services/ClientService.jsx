import axios from "axios";

const CLIENT_API_BASE_URL = `${
  process.env.REACT_APP_BACKEND_URL || "http://localhost:8080"
}/api/v1/client`;

const axiosInstance = axios.create({
  baseURL: CLIENT_API_BASE_URL,
});

axiosInstance.interceptors.request.use(
  (config) => {
    // Attempt to retrieve the authentication token from local storage
    const token = localStorage.getItem("clientToken");
    if (token) {
      config.headers["Authorization"] = "Bearer " + token;
    }
    return config;
  },
  (error) => {
    return Promise.reject(error);
  }
);

class ClientService {
  saveClient(client) {
    return axiosInstance.post("/register", client);
  }
  authenticateClient(client) {
    return axiosInstance.post("/login", client);
  }
  getClients() {
    return axiosInstance.get("/");
  }
  deleteClient(clientId) {
    return axiosInstance.delete("/" + clientId);
  }
  updateClient(clientId, client) {
    return axiosInstance.put("/" + clientId, client);
  }
}

export default new ClientService();
