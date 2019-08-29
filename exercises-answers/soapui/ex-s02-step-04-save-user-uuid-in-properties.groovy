import groovy.json.JsonSlurper

def res = context.expand('${Register new user#response}')
slurperresponse = new JsonSlurper().parseText(res)
log.info "userUUID=" + slurperresponse.uuid
testRunner.testCase.testSuite.setPropertyValue("userUUID", slurperresponse.uuid)
