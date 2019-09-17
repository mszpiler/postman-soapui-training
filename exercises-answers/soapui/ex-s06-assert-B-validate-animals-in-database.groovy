import groovy.sql.Sql

import java.sql.Driver

//reading csv file
def csvFilePath = "/home/mszpiler/enotion/repo/postman-soapui-training/data/cat-data.csv"
def fileReader = new BufferedReader(new FileReader(csvFilePath))
def rowsData = fileReader.readLines()
int rowsize = rowsData.size()

//database connection
def driver = Class.forName('org.postgresql.Driver').newInstance() as Driver
def props = new Properties()
props.setProperty("user", "pkko")
props.setProperty("password", "pkko")
def conn = driver.connect("jdbc:postgresql://51.38.129.181:8200/pkko_db", props)
def sql = new Sql(conn)

def userUUIDLocal = testRunner.testCase.testSuite.getPropertyValue("userUUID")

//userUUIDLocal is a String, we have to change to UUID object
def userUUIDObj = UUID.fromString(userUUIDLocal)

log.info "userUUID = " + userUUIDLocal

//start from i = 1 because first row is a header in CSV file
try {
    for (int i = 1; i < rowsize; i++) {

        rowdata = rowsData[i]
        String[] data = rowdata.split(",")

        //data[1] is a String we have to change to Integer
        def raceId = new Integer(data[1])


        def row = sql.firstRow(
                'select count(*) from norad.animals a ' +
                        'join norad.users u on u.id = a.user_id ' +
                        'where a.name = :animalName and a.race_id = :animalRaceId and u.uuid = :userUUID',
                [animalName: "mszpiler+" + data[0], animalRaceId: raceId, userUUID: userUUIDObj])

        def rowCount = row.count
        log.info "CSV animalName=" + data[0] + " raceId=" + data[1] + " count=" + rowCount

        assert rowCount > 0

    }
} catch (Exception e) {
    log.info(e.getMessage())
    assert false
}
finally {
    sql.close()
    conn.close()
}