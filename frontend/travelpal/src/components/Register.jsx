import { useState } from 'react'
import './Register.css'
import Login from './Login'

const Register = () => {

    const [state, setState] =useState("Register")

  return (
    <>
        {state === 'Login' ? <Login /> :
            <div className='container'>
                <div className='header'>
                    <div className="text">Sign Up</div>
                    <div className="underline"></div>
                </div>
                <div className="inputs">
                <div className='input'>
                    <input type='text' placeholder='Name' />
                </div>
                <div className="input">
                    <input type="email" placeholder='Email' />
                </div>
                <div className="input">
                    <input type="password" placeholder='Password' />
                </div>
                </div>
                <div className="login">Already registered? <span onClick={ () => {setState('Login')}}>Login Here</span></div>
                <div className="submit-container">
                    <div className="submit" onClick={ () => {}}>Sign Up</div>
                </div>
            </div>
        }
    </>
  )
}

export default Register