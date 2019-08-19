pm.test("Check if users match", function () {
    var jsonData = pm.response.json();
    var envUserUuid = pm.environment.get("USER_UUID");
    pm.expect(jsonData.uuid).to.eql(envUserUuid);
});