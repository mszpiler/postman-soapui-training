import groovy.json.JsonSlurper

def res = context.expand('${Create new animal#response}')
slurperresponse = new JsonSlurper().parseText(res)
log.info "animalUUID=" + slurperresponse.uuid
testRunner.testCase.testSuite.setPropertyValue("animalUUID", "" + slurperresponse.uuid)
