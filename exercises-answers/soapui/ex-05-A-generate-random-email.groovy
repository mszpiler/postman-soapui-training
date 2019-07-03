import org.apache.commons.lang.RandomStringUtils

String charset = (('A'..'Z') + ('0'..'9')).join()
Integer length = 9
String randomString = RandomStringUtils.random(length, charset.toCharArray())
String value = "mszpiler+" + randomString + "@norad.com"
testRunner.testCase.setPropertyValue("email", value)
log.info value