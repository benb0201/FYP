import { useState } from "react";
import { useNavigate } from "react-router-dom";
import "./Register.css";
import Login from "./Login";
import ClientService from "../services/ClientService";

const Register = () => {
  const [state, setState] = useState("Register");
  const navigate = useNavigate();
  const [client, setClient] = useState({
    name: "",
    email: "",
    password: "",
    dob: "",
  });

  const changeHandler = (e) => {
    const value = e.target.value;
    setClient({ ...client, [e.target.name]: value });
  };

  const saveClient = async (e) => {
    e.preventDefault();
    try {
      const response = await ClientService.saveClient(client);
      console.log(response);
      alert(response.data.message);
      if (response.data.status === true) {
        navigate("/home");
      }
    } catch (error) {
      console.log(error);
      alert("Error with servers"); //If theres bugs delete this
    }
  };

  return (
    <>
      {state === "Login" ? (
        <Login />
      ) : (
        <div className="container">
          <div className="header">
            <div className="text">Sign Up</div>
            <div className="underline"></div>
          </div>
          <div className="inputs">
            <div className="input">
              <input
                type="text"
                name="name"
                value={client.name}
                placeholder="Name"
                onChange={(e) => changeHandler(e)}
              />
            </div>
            <div className="input">
              <input
                type="email"
                name="email"
                value={client.email}
                placeholder="Email"
                onChange={(e) => changeHandler(e)}
              />
            </div>
            <div className="input">
              <input
                type="password"
                name="password"
                value={client.password}
                placeholder="Password"
                onChange={(e) => changeHandler(e)}
              />
            </div>
            <div className="input">
              {/* <label>DOB:</label> */}
              <input
                type="date"
                name="dob"
                value={client.dob}
                onChange={(e) => changeHandler(e)}
              />
            </div>
          </div>
          <div className="login">
            Already registered?{" "}
            <span
              onClick={() => {
                setState("Login");
              }}
            >
              Login Here
            </span>
          </div>
          <div className="submit-container">
            <div className="submit" onClick={(e) => saveClient(e)}>
              Sign Up
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Register;
