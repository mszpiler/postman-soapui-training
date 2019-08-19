pm.test("Status code is 200", function () {
    pm.response.to.have.status(200);
});
pm.test("Size is equal to 10", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.length).to.eql(10);
});

pm.test("Fifth position is Kot egzotyczny", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData[4].name).to.eql("Kot egzotyczny");
});