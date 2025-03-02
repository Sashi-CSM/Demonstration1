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
createWithArrayRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson([create_user_payload]))))
def createWithArrayResponse = WSBuiltInKeywords.sendRequest(createWithArrayRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createWithArrayResponse, 200)

def non_existing_username = "nonExistingUser__unique__"
def update_user_payload = [
    id: 1,
    username: non_existing_username,
    firstName: "Jane",
    lastName: "Smith",
    email: "jane.smith@example.com",
    password: "newpassword456",
    phone: "9876543210",
    userStatus: 2
]

def updateUserRequest = findTestObject("Object Repository/Swagger Petstore/updateUser", [username: non_existing_username])
addHeaderConfiguration(updateUserRequest)
updateUserRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(update_user_payload))))
def updateUserResponse = WSBuiltInKeywords.sendRequest(updateUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(updateUserResponse, 404)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

