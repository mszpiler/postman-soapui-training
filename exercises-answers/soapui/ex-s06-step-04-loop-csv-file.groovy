def csvFilePath = "/home/mszpiler/enotion/repo/postman-soapui-training/data/cat-data.csv"
def fileReader = new BufferedReader(new FileReader(csvFilePath))
def rowsData = fileReader.readLines()
int rowsize = rowsData.size()

//start from i = 1 because first row is a header in CSV file
for (int i = 1; i < rowsize; i++) {
    rowdata = rowsData[i]
    String[] data = rowdata.split(",")
    log.info "CSV animalName=" + data[0] + " raceId=" + data[1]
    testRunner.testCase.setPropertyValue("animalName", "mszpiler+" + data[0])
    testRunner.testCase.setPropertyValue("raceId", data[1])
    testRunner.runTestStepByName("Create one animal")
}