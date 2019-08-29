import groovy.json.JsonSlurper

def res = context.expand('${Get races#response}')
slurperresponse = new JsonSlurper().parseText(res)

Random random = new Random()
def randomIndex = random.nextInt(10)

log.info "raceId=" + slurperresponse[randomIndex].id

testRunner.testCase.setPropertyValue("raceId", "" + slurperresponse[randomIndex].id)
