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

def user_payload = [
    "id": 1,
    "username": "testUser__unique__",
    "firstName": "John",
    "lastName": "Doe",
    "email": "john.doe@example.com",
    "password": "password123",
    "phone": "1234567890",
    "userStatus": 1
]

def createUserRequest = findTestObject('Object Repository/Swagger Petstore/createUser')
def createUserPayload = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(user_payload)))
createUserRequest.setBodyContent(createUserPayload)
addHeaderConfiguration(createUserRequest)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 200)

def logoutUserRequest1 = findTestObject('Object Repository/Swagger Petstore/logoutUser')
addHeaderConfiguration(logoutUserRequest1)
def logoutUserResponse1 = WSBuiltInKeywords.sendRequest(logoutUserRequest1)
WSBuiltInKeywords.verifyResponseStatusCode(logoutUserResponse1, 200)

def logoutUserRequest2 = findTestObject('Object Repository/Swagger Petstore/logoutUser')
addHeaderConfiguration(logoutUserRequest2)
def logoutUserResponse2 = WSBuiltInKeywords.sendRequest(logoutUserRequest2)
WSBuiltInKeywords.verifyResponseStatusCode(logoutUserResponse2, 200)

println("Step 4 - Verify Status Codes:")
println("Logout User 1 Status Code: ${logoutUserResponse1.getStatusCode()}")
println("Logout User 2 Status Code: ${logoutUserResponse2.getStatusCode()}")

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

