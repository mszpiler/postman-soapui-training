import org.apache.commons.lang3.RandomStringUtils

String charset = (('A'..'Z') + ('0'..'9')).join()
Integer length = 9
String randomString = RandomStringUtils.random(length, charset.toCharArray())
String value = "mszpiler+animal+" + randomString
testRunner.testCase.setPropertyValue("animalName", value)
log.info value
