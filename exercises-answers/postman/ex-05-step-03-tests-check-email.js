pm.test("Check if email the same", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.email).to.eql(pm.environment.get("USER_EMAIL"));

    //required for Step 4
    pm.environment.set("USER_UUID", jsonData.uuid);
});
