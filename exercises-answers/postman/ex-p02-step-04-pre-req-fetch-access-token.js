let tokenUrl = pm.environment.get("API_HOST") + pm.environment.get("API_PORT") + pm.environment.get("AUTH_TOKEN_PATH");
let clientId = pm.environment.get("AUTH_CLIENT_ID");
let clientSecret = pm.environment.get("AUTH_SECRET");
let scope = pm.environment.get("AUTH_SCOPE");
let grantType = 'password';
let userName = pm.environment.get("USER_EMAIL");
let password = 'password';

console.log('tokenUrl: ' + tokenUrl);

let getTokenRequest = {
    method: 'POST',
    header: {
        'Accept': 'application/json',
        'Content-Type': 'application/x-www-form-urlencoded'
    },
    url: tokenUrl,
    body: {
        mode: 'urlencoded',
        urlencoded: [
            {key: 'grant_type', value: grantType, disabled: false},
            {key: 'username', value: userName, disabled: false},
            {key: 'password', value: password, disabled: false},
            {key: 'scope', value: scope, disabled: false},
            {key: 'client_id', value: clientId, disabled: false},
            {key: 'client_secret', value: clientSecret, disabled: false}
        ]
    }
};

pm.sendRequest(getTokenRequest, (err, response) => {
    let jsonResponse = response.json(),
        newAccessToken = jsonResponse.access_token;

    console.log({err, jsonResponse, newAccessToken})

    pm.environment.set('ACCESS_TOKEN', newAccessToken);
});

console.log('ACCESS_TOKEN: ' + pm.environment.get('ACCESS_TOKEN'));
