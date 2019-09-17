import groovy.sql.Sql

import java.sql.Driver
//import groovy.sql.Sql

def dbUrl      = "jdbc:postgresql://norad-beta.duckdns.org:8200/pkko_db"
def dbUser     = "pkko"
def dbPassword = "pkko"
def dbDriver   = "org.postgresql.Driver"

def sql = Sql.newInstance(dbUrl, dbUser, dbPassword, dbDriver)