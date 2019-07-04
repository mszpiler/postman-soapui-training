import groovy.json.JsonSlurper
import groovy.sql.Sql

import java.sql.Driver

def driver = Class.forName('org.postgresql.Driver').newInstance() as Driver

def props = new Properties()
props.setProperty("user", "pkko")
props.setProperty("password", "pkko")
def conn = driver.connect("jdbc:postgresql://localhost:8200/pkko_db", props)
def sql = new Sql(conn)

def testCase = messageExchange.modelItem.testCase

def raceId = testCase.getPropertyValue("raceId")

def res = context.expand('${Create new animal#response}')
slurperresponse = new JsonSlurper().parseText(res)
def animalUUID = UUID.fromString(slurperresponse.uuid)

log.info "animalUUID=" + animalUUID + " raceId=" + raceId

try {
    def row = sql.firstRow('select * from norad.animals where uuid = :uuid', [uuid: animalUUID])
    log.info "row.race_id=" + row.race_id
    assert row.race_id == raceId.toInteger()
} catch (Exception e) {
    log.info(e.getMessage())
    assert false
}
finally {
    sql.close()
    conn.close()
}