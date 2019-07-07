import groovy.json.JsonSlurper

def csvFilePath = "/home/mszpiler/enotion/repo/postman-soapui-jmeter-qa-training/data/many-steps-data.csv"
def fileReader = new BufferedReader(new FileReader(csvFilePath))
def rowsData = fileReader.readLines()
int rowsize = rowsData.size()

def animalUUIDMap = new HashMap()
context.setProperty("animalUUIDMap", animalUUIDMap)

//start from i = 1 because first row is a header in CSV file
for (int i = 1; i < rowsize; i++) {
    rowdata = rowsData[i]
    String[] data = rowdata.split(",")
    def raceId = data[1]
    log.info "CSV animalName=" + data[0] + " raceId=" + raceId
    def animalName = "mszpiler+" + data[0]
    testRunner.testCase.setPropertyValue("animalName", animalName)
    testRunner.testCase.setPropertyValue("raceId", raceId)
    testRunner.runTestStepByName("Create one animal")

    //get response for request "Create one animal"
    def response = context.expand('${Create one animal#Response}')

    //parse response to structure easy to read
    slurperresponse = new JsonSlurper().parseText(response)

    log.info("Animal name =" + animalName + " raceId=" + raceId + " created animal uuid=" + slurperresponse.uuid)

    //setup in context information about created animal uuid and raceId assocciated with this animal
    animalUUIDMapLocal = context.getProperty("animalUUIDMap")
    animalUUIDMapLocal.put(slurperresponse.uuid, raceId)

    //not required
    //context.setProperty("animalUUIDMap", animalUUIDMapLocal)

}

log.info "animal uuid list = " + context.getProperty("animalUUIDMap")