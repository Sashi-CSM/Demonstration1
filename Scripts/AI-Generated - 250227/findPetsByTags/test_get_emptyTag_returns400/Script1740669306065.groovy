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

def categoryPayload = new HttpTextBodyContent(replaceSuffixWithUUID('{"name": "category_name__unique__"}'))
def addCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(addCategoryRequest)
addCategoryRequest.setBodyContent(categoryPayload)
def addCategoryResponse = WSBuiltInKeywords.sendRequest(addCategoryRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addCategoryResponse, 200)
def categoryId = new JsonSlurper().parseText(addCategoryResponse.getResponseText())['id']

def petPayload = new HttpTextBodyContent(replaceSuffixWithUUID('{"name": "pet_name__unique__", "photoUrls": ["photo_url__unique__"], "category": {"id": ' + categoryId + ', "name": "category_name__unique__"}}'))
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(addPetRequest)
addPetRequest.setBodyContent(petPayload)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)
def petId = new JsonSlurper().parseText(addPetResponse.getResponseText())['id']

def findByTagsRequest = findTestObject('Object Repository/Swagger Petstore/findPetsByTags')
def findByTagsResponse = WSBuiltInKeywords.sendRequest(findByTagsRequest)
WSBuiltInKeywords.verifyResponseStatusCode(findByTagsResponse, 400)
assert findByTagsResponse.getStatusCode() == 400

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

