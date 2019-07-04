import groovy.json.JsonSlurper

def res = context.expand('${Register user#response}')
slurperresponse = new JsonSlurper().parseText(res)
log.info "userUUID=" + slurperresponse.uuid
testRunner.testCase.testSuite.setPropertyValue("userUUID", slurperresponse.uuid)
