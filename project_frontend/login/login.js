const AWS = require('aws-sdk');
AWS.config.update({
    region: 'us-west-2'
})
const util = require('../utils/util');
const bcrypt = require('bcrypt');
const auth = require('../utils/auth');

const dynamodb = new AWS.DynamoDB.DocumentClient();
const accounts = 'accounts';

async function login (user) {
    const username = user.username;
    const password = user.password;
    if(!user || !username || !password) {
        return util.buildResponse(401, {
            message: 'Username and Password required'
        })
    }

    const dynamoUser = await getUser(username);
    if(!dynamoUser || !dynamoUser.username) {
        return util.buildResponse(403, {
            message: 'User does not exist'
        });
    }

    if (!bcrypt.compareSync(password, dynamoUser.password)) {
        return util.buildResponse(403, {
            message:  'Incorrect password'
        });
    }

    const userInfo = {
        username: dynamoUser.username,
        email: dynamoUser.email
    }
    const token = auth.generateToken(userInfo);
    const response = {
        user: userInfo,
        token: token
    }
    return util.buildResponse(200, response);
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

module.exports.login = login;