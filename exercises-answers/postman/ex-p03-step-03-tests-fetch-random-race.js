var jsonData = pm.response.json();
var randomNumber = Math.floor((Math.random() * 10) + 1);
var selectedRaceId = jsonData[randomNumber].id
pm.environment.set("RACE_ID", selectedRaceId);