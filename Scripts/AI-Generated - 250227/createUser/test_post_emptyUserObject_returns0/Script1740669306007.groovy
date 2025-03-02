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
def orderPayload = '{"petId": ${petPayload.id}}'
def userPayload = '{}'

def createCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def createPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def createOrderRequest = findTestObject('Object Repository/Swagger Petstore/placeOrder')
def createUserRequest = findTestObject('Object Repository/Swagger Petstore/createUser')

addHeaderConfiguration(createCategoryRequest)
addHeaderConfiguration(createPetRequest)
addHeaderConfiguration(createOrderRequest)
addHeaderConfiguration(createUserRequest)

def createCategoryResponse = WSBuiltInKeywords.sendRequest(createCategoryRequest)
def createPetResponse = WSBuiltInKeywords.sendRequest(createPetRequest)
def createOrderResponse = WSBuiltInKeywords.sendRequest(createOrderRequest)
def createUserResponse = WSBuiltInKeywords.sendRequest(createUserRequest)

WSBuiltInKeywords.verifyResponseStatusCode(createCategoryResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createPetResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createOrderResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createUserResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

