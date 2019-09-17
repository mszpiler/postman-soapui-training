var jsonString = '{ "name" : "Ala", "action" : "Ma kota"}'

var jsonObject = JSON.parse(jsonString);

console.log("name = " + jsonObject.name);
console.log("action = " + jsonObject.action)