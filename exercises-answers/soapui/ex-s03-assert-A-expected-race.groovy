import groovy.json.JsonSlurper
import groovy.sql.Sql

def dbUrl      = "jdbc:postgresql://norad-beta.duckdns.org:8200/pkko_db"
def dbUser     = "pkko"
def dbPassword = "pkko"
def dbDriver   = "org.postgresql.Driver"

def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)

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
}