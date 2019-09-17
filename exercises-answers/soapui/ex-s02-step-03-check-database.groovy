import groovy.sql.Sql

def dbUrl      = "jdbc:postgresql://norad-beta.duckdns.org:8200/pkko_db"
def dbUser     = "pkko"
def dbPassword = "pkko"
def dbDriver   = "org.postgresql.Driver"

def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)

def testCase = messageExchange.modelItem.testCase
def email = testCase.getPropertyValue("email")
log.info "Email=" + email
try {
    def row = sql.firstRow('select * from norad.users where email = :email', [email: email])
    assert row.email == email
} catch (Exception e) {
    log.info(e.getMessage())
    assert false
}
finally {
    sql.close()
}