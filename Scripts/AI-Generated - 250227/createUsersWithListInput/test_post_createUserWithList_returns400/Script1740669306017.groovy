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

def userPayload = [
    id: 1,
    username: "test_username__unique__",
    userStatus: 1
]

def userPayloadIncomplete = [
    id: 1,
    username: "test_username__unique__"
]

def createWithListRequest = findTestObject("Object Repository/Swagger Petstore/createUsersWithListInput")
addHeaderConfiguration(createWithListRequest)
def createWithListPayload = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson([userPayload])))
createWithListRequest.setBodyContent(createWithListPayload)
def createWithListResponse = WSBuiltInKeywords.sendRequest(createWithListRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createWithListResponse, 200)

def createWithListIncompleteRequest = findTestObject("Object Repository/Swagger Petstore/createUsersWithListInput")
addHeaderConfiguration(createWithListIncompleteRequest)
def createWithListIncompletePayload = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson([userPayloadIncomplete])))
createWithListIncompleteRequest.setBodyContent(createWithListIncompletePayload)
def createWithListIncompleteResponse = WSBuiltInKeywords.sendRequest(createWithListIncompleteRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createWithListIncompleteResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

