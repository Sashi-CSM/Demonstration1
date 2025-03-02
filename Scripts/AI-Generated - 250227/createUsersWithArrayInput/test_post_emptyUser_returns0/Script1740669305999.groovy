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

def category_payload = '{"id": 1, "name": "category__unique__"}'
def pet_payload = '{"name": "pet__unique__", "photoUrls": ["url1", "url2"], "category": ' + category_payload + '}'
def order_payload = '{"petId": 1, "quantity": 1, "shipDate": "2022-01-01T00:00:00Z", "status": "placed", "complete": true}'
def empty_user_payload = '{}'

def createCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def createPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def createOrderRequest = findTestObject('Object Repository/Swagger Petstore/placeOrder')
def createEmptyUserRequest = findTestObject('Object Repository/Swagger Petstore/createUsersWithListInput')
def createEmptyUserArrayRequest = findTestObject('Object Repository/Swagger Petstore/createUsersWithArrayInput')

addHeaderConfiguration(createCategoryRequest)
addHeaderConfiguration(createPetRequest)
addHeaderConfiguration(createOrderRequest)
addHeaderConfiguration(createEmptyUserRequest)
addHeaderConfiguration(createEmptyUserArrayRequest)

createCategoryRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(category_payload)))
createPetRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(pet_payload)))
createOrderRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(order_payload)))
createEmptyUserRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(empty_user_payload)))
createEmptyUserArrayRequest.setBodyContent(new HttpTextBodyContent(replaceSuffixWithUUID(empty_user_payload)))

def createCategoryResponse = WSBuiltInKeywords.sendRequest(createCategoryRequest)
def createPetResponse = WSBuiltInKeywords.sendRequest(createPetRequest)
def createOrderResponse = WSBuiltInKeywords.sendRequest(createOrderRequest)
def createEmptyUserResponse = WSBuiltInKeywords.sendRequest(createEmptyUserRequest)
def createEmptyUserArrayResponse = WSBuiltInKeywords.sendRequest(createEmptyUserArrayRequest)

WSBuiltInKeywords.verifyResponseStatusCode(createCategoryResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createPetResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createOrderResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createEmptyUserResponse, 200)
WSBuiltInKeywords.verifyResponseStatusCode(createEmptyUserArrayResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

