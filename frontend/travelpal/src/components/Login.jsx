import { useState } from "react";
import "./Login.css";
import Register from "./Register";
import ClientService from "../services/ClientService";

const Login = () => {
  const [state, setState] = useState("Login");
  const [client, setClient] = useState({
    email: "",
    password: "",
  });

  const changeHandler = (e) => {
    const value = e.target.value;
    setClient({ ...client, [e.target.name]: value });
  };

  const authenticateClient = (e) => {
    e.preventDefault();
    ClientService.authenticateClient(client)
      .then((response) => {
        console.log(response);
        alert(response.data.message);
      })

      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <>
      {state === "Register" ? (
        <Register />
      ) : (
        <div className="container">
          <div className="header">
            <div className="text">Log In</div>
            <div className="underline"></div>
          </div>
          <div className="inputs">
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
          </div>
          <div className="register">
            Not Registered?{" "}
            <span
              onClick={() => {
                setState("Register");
              }}
            >
              Sign Up Here
            </span>
          </div>
          <div className="submit-container">
            <div className="submit" onClick={(e) => authenticateClient(e)}>
              Log In
            </div>
          </div>
        </div>
      )}
    </>
  );
};

export default Login;
