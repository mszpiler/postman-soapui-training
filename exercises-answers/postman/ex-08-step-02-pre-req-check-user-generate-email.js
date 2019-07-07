var exUserUUID = pm.environment.get("EX8_USER_UUID");

console.log("exUserUUID = " + exUserUUID);

//first check if EX8_USER_UUID is set in environment
if (exUserUUID === null || exUserUUID === undefined) {
    var randomString = Math.random().toString(36).substring(7);
    console.log("Random string is " + randomString);
    var randomEmail = 'mszpiler+postman+' + randomString + '@norad.com';
    pm.environment.set("USER_EMAIL", randomEmail);
} else {
    postman.setNextRequest("Create new animal");
}

