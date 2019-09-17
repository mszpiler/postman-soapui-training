import groovy.json.JsonSlurper
import groovy.sql.Sql

def dbUrl      = "jdbc:postgresql://norad-beta.duckdns.org:8200/pkko_db"
def dbUser     = "pkko"
def dbPassword = "pkko"
def dbDriver   = "org.postgresql.Driver"

def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)

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
}
