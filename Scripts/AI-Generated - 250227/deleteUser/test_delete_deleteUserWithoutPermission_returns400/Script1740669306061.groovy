import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import groovy.json.JsonSlurper
import groovy.json.JsonOutput

def addHeaderConfiguration(request) {
    def content_type_header = new TestObjectProperty("content-type", ConditionType.EQUALS, "application/json")
    request.getHttpHeaderProperties().add(content_type_header)
}

uuid = UUID.randomUUID().toString()

def create_user_payload = [{"id": 1, "username": "test_user__unique__", "userStatus": 1}]
def create_user_request = findTestObject('Object Repository/Swagger Petstore/createUsersWithArrayInput')
addHeaderConfiguration(create_user_request)
def create_user_payload_content = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(create_user_payload)))
create_user_request.setBodyContent(create_user_payload_content)
def create_user_response = WSBuiltInKeywords.sendRequest(create_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(create_user_response, 200)

def login_payload = {"username": "different_user", "password": "password"}
def login_request = findTestObject('Object Repository/Swagger Petstore/loginUser')
addHeaderConfiguration(login_request)
def login_request_url = login_request.getRestUrl() + "?username=${login_payload.username}&password=${login_payload.password}"
def login_response = WSBuiltInKeywords.sendRequest(login_request_url)
WSBuiltInKeywords.verifyResponseStatusCode(login_response, 200)

def delete_user_request = findTestObject('Object Repository/Swagger Petstore/deleteUser', ['username': 'test_user__unique__'])
addHeaderConfiguration(delete_user_request)
def delete_user_response = WSBuiltInKeywords.sendRequest(delete_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(delete_user_response, 400)
WSBuiltInKeywords.verifyResponseStatusCode(delete_user_response, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

