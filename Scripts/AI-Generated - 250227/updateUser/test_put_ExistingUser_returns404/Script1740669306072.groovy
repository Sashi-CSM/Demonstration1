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
def create_user_response = WSBuiltInKeywords.sendRequest(create_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(create_user_response, 200)

def update_user_payload = {"id": 1, "username": "test_user__unique__", "userStatus": 2}
def update_user_request = findTestObject('Object Repository/Swagger Petstore/updateUser', [:])
addHeaderConfiguration(update_user_request)
def update_user_response = WSBuiltInKeywords.sendRequest(update_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(update_user_response, 200)

def delete_user_request = findTestObject('Object Repository/Swagger Petstore/deleteUser', [:])
addHeaderConfiguration(delete_user_request)
def delete_user_response = WSBuiltInKeywords.sendRequest(delete_user_request)
WSBuiltInKeywords.verifyResponseStatusCode(delete_user_response, 200)

def update_user_after_delete_request = findTestObject('Object Repository/Swagger Petstore/updateUser', [:])
addHeaderConfiguration(update_user_after_delete_request)
def update_user_after_delete_response = WSBuiltInKeywords.sendRequest(update_user_after_delete_request)
WSBuiltInKeywords.verifyResponseStatusCode(update_user_after_delete_response, 404)

assert update_user_after_delete_response.getStatusCode() == 404

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

