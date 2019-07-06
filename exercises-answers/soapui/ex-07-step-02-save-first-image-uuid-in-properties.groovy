import groovy.json.JsonSlurper

def res = context.expand('${Create new animal#response}')
slurperresponse = new JsonSlurper().parseText(res)
log.info "imageUUID=" + slurperresponse.images[0].uuid
testRunner.testCase.testSuite.setPropertyValue("imageUUID", slurperresponse.images[0].uuid)