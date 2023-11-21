import { useState } from 'react'
import './Login.css'
import Register from './Register'

const Login = () => {

    const [state, setState] = useState("Login")

  return (
    <>
        {state === "Register" ? <Register /> :
            <div className='container'>
                <div className='header'>
                    <div className="text">Log In</div>
                    <div className="underline"></div>
                </div>
                <div className="inputs">
                    <div className="input">
                        <input type="email" placeholder='Email' />
                    </div>
                    <div className="input">
                        <input type="password" placeholder='Password' />
                    </div>
                </div>
                <div className="register">Not Registered? <span onClick={ () => {setState('Register')}}>Sign Up Here</span></div>
                <div className="submit-container">
                    <div className="submit" onClick={ () => {}}>Log In</div>
                </div>
            </div>
        }
    </>
  )
}

export default Login