import React, { useState } from 'react';
import axios from 'axios';

const registerURL = 'https://rzfy99sz8c.execute-api.us-west-2.amazonaws.com/testing2/accounts';

const SignUp = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [email, setEmail] = useState('');
    const [message, setMessage] = useState(null);


    const submitHandler = (event) => {
        event.preventDefault();
        if (username.trim() === '' || email.trim() === '' || password.trim() === '') {
            setMessage('All fields are required');
            return;
        }

        setMessage(null);
        const requestBody = {
            username: username,
            password: password,
            email: email
        }
        axios.post(registerURL, requestBody).then(response => {
            setMessage('Sign Up Successful');
        }).catch(error => {
            if (error.response.status === 401 || error.response.status === 403) {
                setMessage(error.response.data.message);
            } else {
                setMessage('server error');
            }
        })

        console.log('submit button pressed');
    }

    return (
        <div>
            <form onSubmit={submitHandler}>
                <h5>Please enter the following information to sign up:</h5>
                <label htmlFor="username"><b>Username:</b></label>
                <input type="text" id="username" required placeholder="username" value={username} onChange={event => setUsername(event.target.value)}/>

                <label htmlFor="password"><b>Password:</b></label>
                <input type="password" id="password" required placeholder="password" value={password} onChange={event => setPassword(event.target.value)}/>

                <label htmlFor="email"><b>Email:</b></label>
                <input type="text" id="email" required placeholder="email" value={email} onChange={event => setEmail(event.target.value)}/>

                <input type="submit" value="SignUp" />
            </form>
            {message && <p className="message">You are now registered. Please login.</p>}
        </div>
    )
}

export default SignUp;