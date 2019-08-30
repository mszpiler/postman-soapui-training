import groovy.json.JsonSlurper

def res = context.expand('${Create new animal#response}')
slurperresponse = new JsonSlurper().parseText(res)

for (i = 0; i < slurperresponse.images.size(); i++) {
    log.info slurperresponse.images[i].uuid
    assert slurperresponse.images[i].uuid != null
}
