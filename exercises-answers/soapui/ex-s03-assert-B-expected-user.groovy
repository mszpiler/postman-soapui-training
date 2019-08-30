import groovy.json.JsonSlurper
import groovy.sql.Sql

import java.sql.Driver

def driver = Class.forName('org.postgresql.Driver').newInstance() as Driver

def props = new Properties()
props.setProperty("user", "pkko")
props.setProperty("password", "pkko")
def conn = driver.connect("jdbc:postgresql://51.38.129.181:8200/pkko_db", props)
def sql = new Sql(conn)

def testCase = messageExchange.modelItem.testCase

def tcUserUUID = testCase.testSuite.getPropertyValue("userUUID")
def userUUID = UUID.fromString(tcUserUUID)
log.info "userUUID=" + userUUID

def res = context.expand('${Create new animal#response}')
slurperresponse = new JsonSlurper().parseText(res)

def animalUUID = UUID.fromString(slurperresponse.uuid)
log.info "animalUUID=" + animalUUID

try {
    def animalRow = sql.firstRow('select * from norad.animals where uuid = :uuid', [uuid: animalUUID])
    def userRow = sql.firstRow('select * from norad.users where uuid = :uuid', [uuid: userUUID])

    assert animalRow.user_id == userRow.id

} catch (Exception e) {
    log.info(e.getMessage())
    assert false
}
finally {
    sql.close()
    conn.close()
}
