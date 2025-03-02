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
def addPetRequest = findTestObject('addPet')
addHeaderConfiguration(addPetRequest)
def category_payload = new HttpTextBodyContent(replaceSuffixWithUUID('{"name": "TestCategory__unique__"}'))
addPetRequest.setBodyContent(category_payload)
def categoryResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(categoryResponse, 200)

// Step 2: Create a new Pet
def updatePetRequest = findTestObject('updatePet')
addHeaderConfiguration(updatePetRequest)
def pet_payload = new HttpTextBodyContent(replaceSuffixWithUUID('{"name": "TestPet__unique__", "photoUrls": ["http://test.com/photo"], "category": {"id": 1, "name": "TestCategory__unique__"}}'))
updatePetRequest.setBodyContent(pet_payload)
def petResponse = WSBuiltInKeywords.sendRequest(updatePetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(petResponse, 200)

// Step 3: Create a new Order
def placeOrderRequest = findTestObject('placeOrder')
addHeaderConfiguration(placeOrderRequest)
def order_payload = new HttpTextBodyContent(replaceSuffixWithUUID('{"petId": 1, "quantity": 1, "shipDate": "2022-01-01T00:00:00.000Z", "status": "placed", "complete": false}'))
placeOrderRequest.setBodyContent(order_payload)
def orderResponse = WSBuiltInKeywords.sendRequest(placeOrderRequest)
WSBuiltInKeywords.verifyResponseStatusCode(orderResponse, 200)

// Step 4: Make a POST request with negative petId
def uploadFileRequest = findTestObject('uploadFile')
addHeaderConfiguration(uploadFileRequest)
def negative_pet_id = -1
def uploadFileResponse = WSBuiltInKeywords.sendRequest(uploadFileRequest, ['petId': negative_pet_id])
WSBuiltInKeywords.verifyResponseStatusCode(uploadFileResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

