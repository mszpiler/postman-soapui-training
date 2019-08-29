import groovy.json.JsonSlurper
import org.apache.http.HttpResponse
import org.apache.http.NameValuePair
import org.apache.http.client.HttpClient
import org.apache.http.client.entity.UrlEncodedFormEntity
import org.apache.http.client.methods.HttpPost
import org.apache.http.impl.client.DefaultHttpClient
import org.apache.http.message.BasicNameValuePair
import org.apache.http.util.EntityUtils

def oauthProviderUrl = 'https://norad-beta.duckdns.org/auth/realms/pokakota/protocol/openid-connect/token'
def HttpClient httpClient = new DefaultHttpClient()

def email = testRunner.testCase.testSteps['Run TestCase Register new user'].getPropertyValue('email')

log.info "Email from properties: $email"

def params = [
        scope        : 'openid',
        grant_type   : 'password',
        username     : email,
        password     : 'password',
        client_id    : 'norad',
        client_secret: '0a62d507-181e-4e44-8c75-dca6665b34b2'
]

HttpPost httpPost = new HttpPost(oauthProviderUrl)
List<NameValuePair> postParams = params.collect {
    new BasicNameValuePair(it.key, it.value)
}

httpPost.entity = new UrlEncodedFormEntity(postParams)
HttpResponse response = httpClient.execute(httpPost)


String responseBody = response.entity.content.text
log.info "OAuth response: $responseBody"
EntityUtils.consume(response.entity)

def responseParsed = new JsonSlurper().parseText(responseBody)
def accessToken = responseParsed.access_token;
log.info "Retrieved ACCESS_TOKEN: $accessToken"

testRunner.testCase.setPropertyValue("ACCESS_TOKEN", accessToken)
