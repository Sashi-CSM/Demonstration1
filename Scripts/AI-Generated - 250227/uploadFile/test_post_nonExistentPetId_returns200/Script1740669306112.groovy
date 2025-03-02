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

// Step 1: Create a new Category
def categoryPayload = '{"name": "category_name__unique__"}'
def addCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def categoryBodyContent = new HttpTextBodyContent(replaceSuffixWithUUID(categoryPayload))
addCategoryRequest.setBodyContent(categoryBodyContent)
addHeaderConfiguration(addCategoryRequest)
def addCategoryResponse = WSBuiltInKeywords.sendRequest(addCategoryRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addCategoryResponse, 200)

// Step 2: Create a new Pet
def petPayload = '{"name": "pet_name__unique__", "photoUrls": ["photo_url__unique__"], "category": {"id": 1, "name": "category_name__unique__"}}'
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def petBodyContent = new HttpTextBodyContent(replaceSuffixWithUUID(petPayload))
addPetRequest.setBodyContent(petBodyContent)
addHeaderConfiguration(addPetRequest)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)

// Step 3: Create a new Order
def orderPayload = '{"petId": 1, "quantity": 1, "shipDate": "2022-01-01T00:00:00.000Z", "status": "placed", "complete": true}'
def placeOrderRequest = findTestObject('Object Repository/Swagger Petstore/placeOrder')
def orderBodyContent = new HttpTextBodyContent(replaceSuffixWithUUID(orderPayload))
placeOrderRequest.setBodyContent(orderBodyContent)
addHeaderConfiguration(placeOrderRequest)
def placeOrderResponse = WSBuiltInKeywords.sendRequest(placeOrderRequest)
WSBuiltInKeywords.verifyResponseStatusCode(placeOrderResponse, 200)

// Step 4: Make a POST request to /pet/{nonExistentPetId}/uploadImage with a non-existent petId
def nonExistentPetId = 999999
def uploadImageRequest = findTestObject('Object Repository/Swagger Petstore/uploadFile', ['petId': nonExistentPetId])
addHeaderConfiguration(uploadImageRequest)
def uploadImageResponse = WSBuiltInKeywords.sendRequest(uploadImageRequest)
WSBuiltInKeywords.verifyResponseStatusCode(uploadImageResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

