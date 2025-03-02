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
def petPayload = '{"name": "pet__unique__", "photoUrls": ["url1", "url2"], "category": ${categoryPayload}, "status": "available"}'
def orderPayload = '{"petId": 1, "quantity": 1, "shipDate": "2022-01-01T00:00:00Z", "status": "placed", "complete": true}'
def userPayload = '{"username": "user__unique__", "userStatus": 1}'

def addCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def placeOrderRequest = findTestObject('Object Repository/Swagger Petstore/placeOrder')
def createUserRequest = findTestObject('Object Repository/Swagger Petstore/createUsersWithListInput')

addHeaderConfiguration(addCategoryRequest)
addHeaderConfiguration(addPetRequest)
addHeaderConfiguration(placeOrderRequest)
addHeaderConfiguration(createUserRequest)

addCategoryRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(categoryPayload)))
addPetRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(petPayload)))
placeOrderRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(orderPayload)))
createUserRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID("[${userPayload}]")))

def addCategoryResponse = WSBuiltInKeywords.sendRequest(addCategoryRequest)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
def placeOrderResponse = WSBuiltInKeywords.sendRequest(placeOrderRequest)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)

WSBuiltInKeywords.verifyResponseStatusCode(addCategoryResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(placeOrderResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

