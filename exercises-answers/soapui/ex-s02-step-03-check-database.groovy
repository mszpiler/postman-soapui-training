import groovy.sql.Sql

import java.sql.Driver

def driver = Class.forName('org.postgresql.Driver').newInstance() as Driver

def props = new Properties()
props.setProperty("user", "pkko")
props.setProperty("password", "pkko")

def conn = driver.connect("jdbc:postgresql://norad-beta.duckdns.org:8200/pkko_db", props)
def sql = new Sql(conn)

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
    conn.close()
}