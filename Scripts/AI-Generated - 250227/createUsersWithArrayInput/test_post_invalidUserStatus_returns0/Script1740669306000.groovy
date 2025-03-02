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
def petPayload = '{"name": "pet__unique__", "photoUrls": ["url1", "url2"], "category": ${categoryPayload}}'
def orderPayload = '{"petId": 1, "quantity": 1, "shipDate": "2022-01-01T00:00:00Z", "status": "placed", "complete": true}'
def userPayload = '{"username": "user__unique__"}'
def arrayPayload = '[${userPayload}]'

def addPetRequest = findTestObject('addPet')
def addPetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(petPayload))
addHeaderConfiguration(addPetRequest)
addPetRequest.setBodyContent(addPetPayload)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)

def addCategoryRequest = findTestObject('addPet')
def addCategoryPayload = new HttpTextBodyContent(replaceSuffixWithUUID(categoryPayload))
addHeaderConfiguration(addCategoryRequest)
addCategoryRequest.setBodyContent(addCategoryPayload)
def addCategoryResponse = WSBuiltInKeywords.sendRequest(addCategoryRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addCategoryResponse, 200)

def addOrderRequest = findTestObject('placeOrder')
def addOrderPayload = new HttpTextBodyContent(replaceSuffixWithUUID(orderPayload))
addHeaderConfiguration(addOrderRequest)
addOrderRequest.setBodyContent(addOrderPayload)
def addOrderResponse = WSBuiltInKeywords.sendRequest(addOrderRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addOrderResponse, 200)

def addUserRequest = findTestObject('createUser')
def addUserPayload = new HttpTextBodyContent(replaceSuffixWithUUID(userPayload))
addHeaderConfiguration(addUserRequest)
addUserRequest.setBodyContent(addUserPayload)
def addUserResponse = WSBuiltInKeywords.sendRequest(addUserRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addUserResponse, 200)

def addUserArrayRequest = findTestObject('createUsersWithArrayInput')
def addUserArrayPayload = new HttpTextBodyContent(replaceSuffixWithUUID(arrayPayload))
addHeaderConfiguration(addUserArrayRequest)
addUserArrayRequest.setBodyContent(addUserArrayPayload)
def addUserArrayResponse = WSBuiltInKeywords.sendRequest(addUserArrayRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addUserArrayResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

