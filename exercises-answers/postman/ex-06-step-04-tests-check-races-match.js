pm.test("Check if races match", function () {
    var jsonData = pm.response.json();
    var envRaceId = pm.environment.get("RACE_ID");
    pm.expect(jsonData.raceId).to.eql(envRaceId);
});