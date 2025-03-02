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

def categoryPayload = '{"id": 1, "name": "category__unique__"}'
def petPayload = '{"name": "pet__unique__", "photoUrls": ["url1", "url2"], "category": ' + categoryPayload + '}'
def orderPayload = '{"petId": 1, "quantity": 1, "shipDate": "2022-01-01T00:00:00Z", "status": "placed", "complete": true}'
def userPayload = '{"username": "user__unique__"}'
def arrayPayload = '[' + userPayload + ']'

def addPetRequest = findTestObject('addPet')
def addPetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(petPayload))
addHeaderConfiguration(addPetRequest)
addPetRequest.setBodyContent(addPetPayload)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)

def placeOrderRequest = findTestObject('placeOrder')
def placeOrderPayload = new HttpTextBodyContent(replaceSuffixWithUUID(orderPayload))
addHeaderConfiguration(placeOrderRequest)
placeOrderRequest.setBodyContent(placeOrderPayload)
def placeOrderResponse = WSBuiltInKeywords.sendRequest(placeOrderRequest)
WSBuiltInKeywords.verifyResponseStatusCode(placeOrderResponse, 200)

def createUserRequest = findTestObject('createUser')
def createUserPayload = new HttpTextBodyContent(replaceSuffixWithUUID(userPayload))
addHeaderConfiguration(createUserRequest)
createUserRequest.setBodyContent(createUserPayload)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 200)

def createUsersWithArrayInputRequest = findTestObject('createUsersWithArrayInput')
def createUsersWithArrayInputPayload = new HttpTextBodyContent(replaceSuffixWithUUID(arrayPayload))
addHeaderConfiguration(createUsersWithArrayInputRequest)
createUsersWithArrayInputRequest.setBodyContent(createUsersWithArrayInputPayload)
def createUsersWithArrayInputResponse = WSBuiltInKeywords.sendRequest(createUsersWithArrayInputRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createUsersWithArrayInputResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

