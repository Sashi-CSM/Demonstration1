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

def createWithArrayRequest = findTestObject('Object Repository/Swagger Petstore/createUsersWithArrayInput')
def createWithArrayPayload = new HttpTextBodyContent(replaceSuffixWithUUID('[{"id": 1, "username": "test_user__unique__", "userStatus": 1}]'))
createWithArrayRequest.setBodyContent(createWithArrayPayload)
addHeaderConfiguration(createWithArrayRequest)
def createWithArrayResponse = WSBuiltInKeywords.sendRequest(createWithArrayRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createWithArrayResponse, 200)

def updateUserRequest = findTestObject('Object Repository/Swagger Petstore/updateUser')
def updateUserPayload = new HttpTextBodyContent(replaceSuffixWithUUID('{"id": 1, "username": "", "userStatus": 1}'))
updateUserRequest.setBodyContent(updateUserPayload)
addHeaderConfiguration(updateUserRequest)
def updateUserResponse = WSBuiltInKeywords.sendRequest(updateUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(updateUserResponse, 400)

println(updateUserResponse.getStatusCode())

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

