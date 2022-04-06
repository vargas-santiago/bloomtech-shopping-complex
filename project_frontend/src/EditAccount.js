import React, {useState} from 'react';
import {getUserId, getUsername, setUserSession} from "./service/AuthService";
import axios from "axios";

const EditAccount = () => {

    const editAccountUrl = 'https://rzfy99sz8c.execute-api.us-west-2.amazonaws.com/testing2/accounts';

    const [email, setEmail] = useState([]);
    const [password, setPassword] = useState([]);

    let username = getUsername();
    let userId = getUserId();

    const submitHandler = async (event) => {
        event.preventDefault();

        const data = {
            userId: userId,
            password: password,
            email: email
        }

        try {
            let res = await axios({
                method: 'PUT',
                data: data,
                url: editAccountUrl,
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
            <form id="editAccountForm" onSubmit={submitHandler}>
                <h5>Please enter the information you wish to edit:</h5>
                <p>{username}</p>

                <label htmlFor="password">Password:</label>
                <input type="text" id="password" placeholder="password" value={password} onChange={event => setPassword(event.target.value)} />

                <label htmlFor="email">Email:</label>
                <input type="text" id="email" placeholder="email" value={email} onChange={event => setEmail(event.target.value)}/>

                <input type="submit" value="Edit Account" />
            </form>
        </div>
    )
}

export default EditAccount;
