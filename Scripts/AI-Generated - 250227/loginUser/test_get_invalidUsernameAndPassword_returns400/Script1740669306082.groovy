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

def userPayload = '{"username": "testUser2", "password": "testPassword2"}'
def createUserRequest = findTestObject('Object Repository/Swagger Petstore/createUsersWithArrayInput')
def createUserPayload = new HttpTextBodyContent(replaceSuffixWithUUID(userPayload))
createUserRequest.setBodyContent(createUserPayload)
addHeaderConfiguration(createUserRequest)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 200)

def loginRequest = findTestObject('Object Repository/Swagger Petstore/loginUser')
def loginParams = ['username': 'testUser2', 'password': 'incorrectPassword']
def loginRequestWithParams = findTestObject('Object Repository/Swagger Petstore/loginUser', loginParams)
addHeaderConfiguration(loginRequestWithParams)
def loginResponse = WSBuiltInKeywords.sendRequest(loginRequestWithParams)
WSBuiltInKeywords.verifyResponseStatusCode(loginResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

