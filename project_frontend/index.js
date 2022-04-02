const signUpService = require('./signup/signupscript');
const loginService = require('./login/login');
const verifyService = require('./login/verify');
const util = require('./utils/util');

const signUpPath = '/signup';
const loginPath = '/login';
const verifyPath = '/verify';

exports.handler = async (event) => {
    console.log('Request Event: ',  event);
    let response;
    switch (true) {
        case event.httpMethod === 'POST' && event.path === signUpPath:
            const signUpBody = JSON.parse[event.body];
            response = await signUpService.signUp(signUpBody);
            break;
        case event.httpMethod === 'POST' && event.path === loginPath:
            const loginBody = JSON.parse[event.body];
            response = await loginService.login(loginBody);
            break;
        case event.httpMethod === 'POST' && event.path === verifyPath:
            const verifyBody = JSON.parse[event.body];
            response = verifyService.verify(verifyBody);
            break;
        default:
            response = util.buildResponse(404, '404 Not Found')
    }
    return response;
};

