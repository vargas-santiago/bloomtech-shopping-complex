import React from 'react';
import AuthService, {getEmail, getUserId, getUsername} from './service/AuthService';

const AccountDetails = () => {

    let userId = getUserId();
    let username = getUsername();
    let email = getEmail();

    return (
        <div>
            <h5>Your Account</h5>
            <p>UserId: {userId}</p>
            <p>Username: {username}</p>
            <p>Email: {email}</p>
        </div>
    );

}

export default AccountDetails;