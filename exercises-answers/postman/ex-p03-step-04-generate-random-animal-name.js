var randomString = Math.random().toString(36).substring(7);

var randomAnimalName = 'mszpiler+postman+animal+' + randomString;

pm.environment.set("ANIMAL_NAME", randomAnimalName);