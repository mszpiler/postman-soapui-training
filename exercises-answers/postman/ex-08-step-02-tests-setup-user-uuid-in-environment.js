var jsonData = pm.response.json();
pm.environment.set("EX8_USER_UUID", jsonData.uuid);