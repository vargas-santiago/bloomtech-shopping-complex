import React, {useState} from 'react';

const EditAccount = () => {

    const [email, setEmail] = useState([]);
    const [password, setPassword] = useState([]);

    return (
        <div>
            <form id="editAccountForm">
                <h5>Please enter the information you wish to edit:</h5>

                <div id="displayUsername">~display username~</div>

                <label for="password">Password:</label>
                <input type="text" id="password" placeholder="password" value={password}/>

                <label for="email">Email:</label>
                <input type="text" id="email" placeholder="email" value={email}/>

                <input type="submit" value="Edit Account"/>
            </form>
        </div>
    )
}

export default EditAccount;