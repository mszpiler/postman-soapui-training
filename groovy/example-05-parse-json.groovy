//Example how to parse JSON to easy to read structure in Groovy.

import groovy.json.JsonSlurper

//REST_request_name is a custom REST request name
def res = '{"key":"My Value of this key"}'

groovyData = new JsonSlurper().parseText(res)

println(groovyData.key)
