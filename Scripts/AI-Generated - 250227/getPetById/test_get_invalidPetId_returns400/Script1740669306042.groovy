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

def category_payload = new HttpTextBodyContent(replaceSuffixWithUUID('{"id": 1, "name": "category__unique__"}'))
def addCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(addCategoryRequest)
addCategoryRequest.setBodyContent(category_payload)
def addCategoryResponse = WSBuiltInKeywords.sendRequest(addCategoryRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addCategoryResponse, 200)

def pet_payload = new HttpTextBodyContent(replaceSuffixWithUUID('{"name": "pet__unique__", "photoUrls": ["url1", "url2"], "category": {"id": 1, "name": "category__unique__"}}'))
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(addPetRequest)
addPetRequest.setBodyContent(pet_payload)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)

def invalid_pet_id = 999999
def getPetRequest = findTestObject('Object Repository/Swagger Petstore/getPetById', ['petId': invalid_pet_id])
addHeaderConfiguration(getPetRequest)
def getPetResponse = WSBuiltInKeywords.sendRequest(getPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(getPetResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

