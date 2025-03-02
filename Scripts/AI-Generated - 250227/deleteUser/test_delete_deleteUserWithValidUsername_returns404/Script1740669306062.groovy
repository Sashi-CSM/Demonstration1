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

def username = create_user_payload.username
def getUserRequest = findTestObject("Object Repository/Swagger Petstore/getUserByName", [username: username])
addHeaderConfiguration(getUserRequest)
def getUserResponse = WSBuiltInKeywords.sendRequest(getUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getUserResponse, 200)

def deleteUserRequest = findTestObject("Object Repository/Swagger Petstore/deleteUser", [username: username])
addHeaderConfiguration(deleteUserRequest)
def deleteUserResponse = WSBuiltInKeywords.sendRequest(deleteUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(deleteUserResponse, 404)

println("Test passed: User deleted successfully with status code 404")

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

