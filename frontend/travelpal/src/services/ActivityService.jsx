import axios from "axios";

const ACTIVITY_API_BASE_URL = `${
  process.env.REACT_APP_BACKEND_URL || "http://localhost:8080"
}/api/v1/activity`;

class ActivityService {
  // Fetch all activities
  getActivities() {
    return axios.get(ACTIVITY_API_BASE_URL);
  }

  // Save a new activity
  saveActivity(activity) {
    return axios.post(ACTIVITY_API_BASE_URL, activity);
  }

  // Update an existing activity
  updateActivity(activityId, activity) {
    return axios.put(`${ACTIVITY_API_BASE_URL}/${activityId}`, activity);
  }

  // Delete an activity
  deleteActivity(activityId) {
    return axios.delete(`${ACTIVITY_API_BASE_URL}/${activityId}`);
  }
}

export default new ActivityService();
