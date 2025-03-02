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

def create_user_payload = '{"id": 1, "username": "testUser", "firstName": "John", "lastName": "Doe", "email": "john.doe@example.com", "password": "password123", "phone": "1234567890", "userStatus": 1}'
def create_user_request = findTestObject('Object Repository/Swagger Petstore/createUser')
def create_user_payload_content = new HttpTextBodyContent(replaceSuffixWithUUID(create_user_payload))
create_user_request.setBodyContent(create_user_payload_content)
addHeaderConfiguration(create_user_request)
def create_user_response = WSBuiltInKeywords.sendRequest(create_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(create_user_response, 200)

def logout_request = findTestObject('Object Repository/Swagger Petstore/logoutUser')
addHeaderConfiguration(logout_request)
def logout_response = WSBuiltInKeywords.sendRequest(logout_request)
WSBuiltInKeywords.verifyResponseStatusCode(logout_response, 0)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

