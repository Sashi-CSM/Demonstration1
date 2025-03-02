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
def orderPayload = '{"petId": ${petPayload.id}, "quantity": 1, "shipDate": "2022-01-01T00:00:00Z", "status": "placed", "complete": true}'
def userPayload = '{"userStatus": 1}'

def addCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def placeOrderRequest = findTestObject('Object Repository/Swagger Petstore/placeOrder')
def createUserRequest = findTestObject('Object Repository/Swagger Petstore/createUser')

addHeaderConfiguration(addCategoryRequest)
addHeaderConfiguration(addPetRequest)
addHeaderConfiguration(placeOrderRequest)
addHeaderConfiguration(createUserRequest)

def addCategoryPayload = new HttpTextBodyContent(replaceSuffixWithUUID(categoryPayload))
def addPetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(petPayload))
def placeOrderPayload = new HttpTextBodyContent(replaceSuffixWithUUID(orderPayload))
def createUserPayload = new HttpTextBodyContent(replaceSuffixWithUUID(userPayload))

addCategoryRequest.setBodyContent(addCategoryPayload)
addPetRequest.setBodyContent(addPetPayload)
placeOrderRequest.setBodyContent(placeOrderPayload)
createUserRequest.setBodyContent(createUserPayload)

def addCategoryResponse = WSBuiltInKeywords.sendRequest(addCategoryRequest)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
def placeOrderResponse = WSBuiltInKeywords.sendRequest(placeOrderRequest)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)

WSBuiltInKeywords.verifyResponseStatusCode(addCategoryResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(placeOrderResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 0)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

