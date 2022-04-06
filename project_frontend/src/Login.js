import React, {useState} from 'react';
import {getFavorites, setUserSession} from './service/AuthService';
import axios from 'axios';

const loginApiURL = 'https://rzfy99sz8c.execute-api.us-west-2.amazonaws.com/testing2/accounts/login';

const Login = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState(null);

    const submitHandler = async (event) => {
        event.preventDefault();
        if (username.trim() === '' || password.trim() === '') {
            setErrorMessage('Both fields are required');
            return;
        }
        setErrorMessage(null);

        const data = {
            username: username,
            password: password
        }

        try {
            let res = await axios({
                method: 'POST',
                data: data,
                url: loginApiURL,

            });
            if (res.status === 200) {
                setUserSession(res.data.accountModel.username, res.data.accountModel.userId, res.data.accountModel.email, res.data.accountModel.favorites);
                console.log(res);
                window.location.href = "./AccountDetails"
            }
        }
        catch (error) {

        }
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
