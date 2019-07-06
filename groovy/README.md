### Here you can find Groovy examples which can help you solve exercise during training.

##### Example-01. How to generate random string?
##### Example-02. How to concatenate strings?
##### Example-03. How to setup property in test case context?
`testRunner.testCase.setPropertyValue("name", value)`

##### Example-04. How to read REST response?
`def res = context.expand('${REST_request_name#response}')`

##### Example-05. How to parse JSON string to Groovy data?

##### Example-06. How to setup property in test case context?
`testRunner.testCase.setPropertyValue("name", value)`

##### Example-07. How to setup property in test suite context?
`testRunner.testCase.testSuite.setPropertyValue("name", value)`

##### Example-08. How to setup global property?
`com.eviware.soapui.SoapUI.globalProperties.setPropertyValue( "name", value)`

##### Example-09. Where I can find more about property management?

https://www.soapui.org/scripting-properties/tips-tricks.html

##### Example-10. How to loop in Groovy?

##### Example-11. How to get testCase object in assertion section?
`def testCase = messageExchange.modelItem.testCase`





