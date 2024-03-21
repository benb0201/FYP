import { useState } from "react";
import { useNavigate } from "react-router-dom";
import { useAuth } from "../AuthContext";
import "./Login.css";
import ClientService from "../../services/ClientService";

const Login = () => {
  const [isLoginView, setIsLoginView] = useState(true); // Toggle view
  const navigate = useNavigate();
  const { login } = useAuth();
  const [showPassword, setShowPassword] = useState(false);
  const [client, setClient] = useState({
    name: "",
    email: "",
    password: "",
    dob: "",
  });

  // Function to toggle between login and signup view
  const toggleView = () => {
    setIsLoginView(!isLoginView);

    // Reset client state to clear the form fields
    setClient({
      name: "",
      email: "",
      password: "",
      dob: "",
    });

    // Also, reset the password visibility
    setShowPassword(false);
  };

  //Function to toggle password visibility
  const togglePasswordVisibility = () => {
    setShowPassword(!showPassword);
  };

  // Function to check password strength
  const checkPasswordStrength = (password) => {
    const conditions = [];
    if (password.length < 8) {
      conditions.push("at least 8 characters");
    }
    if (!/\d/.test(password)) {
      conditions.push("1 number");
    }
    if (!/[A-Z]/.test(password)) {
      conditions.push("1 uppercase letter");
    }
    if (!/[a-z]/.test(password)) {
      conditions.push("1 lowercase letter");
    }
    if (!/[!@#$%^&*(),.?":{}|<>]/.test(password)) {
      conditions.push("1 special character");
    }

    if (conditions.length > 0) {
      const conditionString = conditions.join(", ");
      alert(
        `Please strengthen your password with the following: ${conditionString}.`
      );
      return false;
    }
    return true;
  };

  const changeHandler = (e) => {
    const { name, value } = e.target;
    setClient((prevState) => ({ ...prevState, [name]: value }));
  };

  const isFormValid = () => {
    if (isLoginView) {
      return client.email && client.password;
    }
    return client.name && client.email && client.password && client.dob;
  };

  const authenticateClient = async (e) => {
    e.preventDefault();
    if (!isFormValid()) {
      alert("Please fill out all required fields.");
      return;
    }
    if (!isLoginView) {
      // During registration, check the password strength
      const isPasswordStrong = checkPasswordStrength(client.password);
      if (!isPasswordStrong) {
        // If the password is not strong, stop the form submission
        return;
      }
    }
    try {
      const response = isLoginView
        ? await ClientService.authenticateClient(client)
        : await ClientService.saveClient(client);
      console.log(response);
      alert(response.data.message);
      if (response.data.status === true) {
        localStorage.setItem("clientId", response.data.id);
        login(); // Update authentication state
        navigate("/home");
      } else {
        alert(response.data.message);
      }
    } catch (err) {
      console.error("Authentication error:", err);
      alert("Error: " + err.message);
    }
  };

  return (
    <div className="auth-container">
      <h2>{isLoginView ? "Log In" : "Sign Up"}</h2>
      <form onSubmit={authenticateClient} className="auth-form">
        {!isLoginView && (
          <input
            type="text"
            name="name"
            placeholder="Name"
            value={client.name}
            onChange={changeHandler}
          />
        )}
        <input
          type="email"
          name="email"
          placeholder="Email"
          value={client.email}
          onChange={changeHandler}
        />
        <div className="password-container">
          <input
            type={showPassword ? "text" : "password"}
            name="password"
            placeholder="Password"
            value={client.password}
            onChange={changeHandler}
          />
          <button type="button" onClick={togglePasswordVisibility}>
            {showPassword ? "Hide" : "Show"}
          </button>
        </div>
        {!isLoginView && (
          <input
            type="date"
            name="dob"
            placeholder="Date of Birth"
            value={client.dob}
            onChange={changeHandler}
          />
        )}
        <button type="submit">{isLoginView ? "Log In" : "Sign Up"}</button>
      </form>
      <button onClick={toggleView}>
        {isLoginView ? "Need an account? Sign Up" : "Have an account? Log In"}
      </button>
    </div>
  );
};

export default Login;
