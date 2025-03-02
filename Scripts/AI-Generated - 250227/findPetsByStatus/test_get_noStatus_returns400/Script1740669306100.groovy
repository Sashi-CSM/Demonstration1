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

def categoryPayload = '{"id": 1, "name": "category_name__unique__"}'
def petPayload = '{"name": "pet_name__unique__", "photoUrls": ["url1", "url2"], "category": ' + categoryPayload + '}'

def createCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(createCategoryRequest)
def createCategoryPayload = new HttpTextBodyContent(replaceSuffixWithUUID(categoryPayload))
createCategoryRequest.setBodyContent(createCategoryPayload)
def createCategoryResponse = WSBuiltInKeywords.sendRequest(createCategoryRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createCategoryResponse, 200)

def createPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(createPetRequest)
def createPetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(petPayload))
createPetRequest.setBodyContent(createPetPayload)
def createPetResponse = WSBuiltInKeywords.sendRequest(createPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createPetResponse, 200)

def findByStatusRequest = findTestObject('Object Repository/Swagger Petstore/findPetsByStatus')
addHeaderConfiguration(findByStatusRequest)
def findByStatusResponse = WSBuiltInKeywords.sendRequest(findByStatusRequest)
WSBuiltInKeywords.verifyResponseStatusCode(findByStatusResponse, 200)

assert findByStatusResponse.getStatusCode() == 400
println("Step 4 - Verify Status Code 400: Test ${findByStatusResponse.getStatusCode() == 400 ? 'Passed' : 'Failed'}")

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

