pm.test("Check if users match", function () {
    var jsonData = pm.response.json();
    var envUserId = pm.environment.get("USER_ID");
    pm.expect(jsonData.id).to.eql(envUserId);
});