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

def create_user_request = findTestObject('Object Repository/Swagger Petstore/createUsersWithArrayInput')
addHeaderConfiguration(create_user_request)
def create_user_payload = new HttpTextBodyContent(replaceSuffixWithUUID('[{"id": 1, "username": "test_user__unique__", "userStatus": 1}]'))
create_user_request.setBodyContent(create_user_payload)
def create_user_response = WSBuiltInKeywords.sendRequest(create_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(create_user_response, 200)

def invalid_user_object = new JsonSlurper().parseText('{"id": 1, "username": "test_user__unique__"}')
def update_user_request = findTestObject('Object Repository/Swagger Petstore/updateUser', ['username': invalid_user_object.username])
addHeaderConfiguration(update_user_request)
def update_user_payload = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(invalid_user_object)))
update_user_request.setBodyContent(update_user_payload)
def update_user_response = WSBuiltInKeywords.sendRequest(update_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(update_user_response, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

