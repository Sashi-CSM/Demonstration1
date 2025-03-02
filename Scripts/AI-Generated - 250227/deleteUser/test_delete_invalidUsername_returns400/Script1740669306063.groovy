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

def create_user_payload = [
    id: 1,
    username: "test_user__unique__",
    firstName: "John",
    lastName: "Doe",
    email: "john.doe@example.com",
    password: "password123",
    phone: "1234567890",
    userStatus: 1
]

def createWithArrayRequest = findTestObject("Object Repository/Swagger Petstore/createUsersWithArrayInput")
addHeaderConfiguration(createWithArrayRequest)
def createWithArrayPayload = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson([create_user_payload])))
createWithArrayRequest.setBodyContent(createWithArrayPayload)
def createWithArrayResponse = WSBuiltInKeywords.sendRequest(createWithArrayRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createWithArrayResponse, 200)

def invalid_username = "special_characters__!@#$"
def deleteUserRequest = findTestObject("Object Repository/Swagger Petstore/deleteUser", [username: invalid_username])
addHeaderConfiguration(deleteUserRequest)
def deleteUserResponse = WSBuiltInKeywords.sendRequest(deleteUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(deleteUserResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

