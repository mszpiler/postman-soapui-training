def email = testRunner.testCase.testSteps['Run TestCase Register new user'].getPropertyValue('email')
log.info "email=" + email
testRunner.testCase.testSuite.setPropertyValue("email", email)