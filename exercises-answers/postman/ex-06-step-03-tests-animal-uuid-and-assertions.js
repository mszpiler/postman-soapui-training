var jsonData = pm.response.json();

pm.environment.set("ANIMAL_UUID", jsonData.uuid);

pm.test("Should contain 3 images in response", function () {
    var jsonData = pm.response.json();
    pm.expect(jsonData.images.length).to.eql(3);
});

pm.test("Every image uuid should not be null", function () {
    var jsonData = pm.response.json();

    for (i = 0; i < jsonData.images.length; i++) {
        pm.expect(jsonData.images[i].uuid).not.eql(null);
    }

});

pm.environment.set("FIRST_IMAGE_UUID", jsonData.images[0].uuid);