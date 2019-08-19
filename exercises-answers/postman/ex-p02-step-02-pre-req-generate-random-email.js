var randomString = Math.random().toString(36).substring(7);

console.log("Random string is " + randomString);

var randomEmail = 'mszpiler+postman+'+randomString+'@norad.com';

pm.environment.set("USER_EMAIL", randomEmail);