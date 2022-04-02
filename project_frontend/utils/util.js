function buildResponse(statusCode, body) {
    return {
        statusCode: statusCode,
        headers: {
            'Access-Control-Allow-Origin': 'true',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    }
}

module.exports.buildResponse = buildResponse;