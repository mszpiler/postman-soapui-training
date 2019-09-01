//read properties from previous test
def animalUUIDProperty = testRunner.testCase.testSuite.getPropertyValue("animalUUID")
def imageUUIDProperty = testRunner.testCase.testSuite.getPropertyValue("imageUUID")

//get step object
def uploadFileStep = testRunner.testCase.getTestStepByName("Download file")


//setup properties in step
uploadFileStep.setPropertyValue("animalUUID", animalUUIDProperty)
uploadFileStep.setPropertyValue("imageUUID", imageUUIDProperty)