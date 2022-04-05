import React, {useState} from 'react';
import { setUserSession } from './service/AuthService';
import axios from 'axios';

const loginApiURL = 'https://rzfy99sz8c.execute-api.us-west-2.amazonaws.com/testing2/accounts/login';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState(null);

    const submitHandler = (event) => {
        event.preventDefault();
        if (username.trim() === '' || password.trim() === '') {
            setErrorMessage('Both fields are required');
            return;
        }
        setErrorMessage(null);
        const requestBody = {
            username: username,
            password: password
        }

        axios.post(loginApiURL, requestBody).then((response) => {
            setUserSession(response.data.user, response.data.token);
        }).catch((error) => {
            if (error.response.status === 401 || error.response.status === 403) {
                setErrorMessage(error.response.data.message);
            } else {
                setErrorMessage('server error');
            }
        })
    }

    return (
        <div>
            <form onSubmit={submitHandler}>
                <h5>Login</h5>
                username: <input type="text" value={username} onChange={event => setUsername(event.target.value)} />
                password: <input type="password" value={password} onChange={event => setPassword(event.target.value)} />
                <input type="submit" value="Login" />
            </form>
            {errorMessage && <p className="message">You are now logged in.</p>}
        </div>
    )

}

export default Login;