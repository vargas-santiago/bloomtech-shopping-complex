import AWS from "aws-sdk";
AWS.config.update({
    region: 'us-west-2'
})
const {buildResponse} = require('../utils/util');
const {hashSync} = require('bcrypt');
const dynamodb = new AWS.DynamoDB.DocumentClient();
const accounts = 'accounts';

async function signUp(userInfo) {
    const username = userInfo.username;
    const password = userInfo.password;
    const email = userInfo.email;
    if (!username || !password || !email) {
        return buildResponse(401, {
            message: 'All fields are required'
        })
    }

    const dynamoUser = await getUser(username);
    if (dynamoUser && dynamoUser.username) {
        return buildResponse(401, {
            message: 'Username already exists'
        })
    }

    const encryptedPW = hashSync(password.trim(), 10);
    const user = {
        username: username,
        password: encryptedPW,
        email: email
    }

    const saveUserResponse = await saveUser(user);
    if (!saveUserResponse) {
        return buildResponse(503, {
            message: 'Server Error, try again later'
        })
    }

    return buildResponse(200, { username: username });
}

async function getUser(username) {
    const params = {
        TableName: accounts,
        key: {
            username: username
        }
    }

    return await dynamodb.get(params).promise().then(response => {
        return response.Item;
    }, error => {
        console.error('There is an error getting user: ', error);
    })
}

async function saveUser(user) {
    const params = {
        TableName: accounts,
        Item: user
    }
    return await dynamodb.put(params).promise().then(() => {
        return true;
    }, error => {
        console.error('There is an error saving user: ', error);
    });
}

module.exports.signUp = signUp;
