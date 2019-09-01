import groovy.json.JsonSlurper

//get saved map with animal uuid and race id
def animalUUIDMap = context.getProperty("animalUUIDMap")

for (entry in animalUUIDMap) {

    def animalUUID = entry.key
    def expectedAnimalRaceId = new Integer(entry.value)

    //setup params for specific step
    def getAnimalDetailsStep = testRunner.testCase.getTestStepByName("Get animal details")
    getAnimalDetailsStep.setPropertyValue("uuid", animalUUID)

    //run specific step
    testRunner.runTestStepByName("Get animal details")

    //read and parse response
    def response = context.expand('${Get animal details#Response}')
    slurperresponse = new JsonSlurper().parseText(response)

    //expected race id should be equal to raceId from response
    assert expectedAnimalRaceId == slurperresponse.raceId
}