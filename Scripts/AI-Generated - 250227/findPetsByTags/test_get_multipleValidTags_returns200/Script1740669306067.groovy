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

def categoryPayload = new HttpTextBodyContent(replaceSuffixWithUUID('{"name": "TestCategory__unique__"}'))
def createCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
createCategoryRequest.setBodyContent(categoryPayload)
addHeaderConfiguration(createCategoryRequest)
def createCategoryResponse = WSBuiltInKeywords.sendRequest(createCategoryRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createCategoryResponse, 200)

def categoryId = new JsonSlurper().parseText(createCategoryResponse.getResponseText())['id']

def petPayload = new HttpTextBodyContent(replaceSuffixWithUUID('{"name": "TestPet__unique__", "photoUrls": ["http://test.com/photo"], "category": {"id": ' + categoryId + ', "name": "TestCategory__unique__"}}'))
def createPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
createPetRequest.setBodyContent(petPayload)
addHeaderConfiguration(createPetRequest)
def createPetResponse = WSBuiltInKeywords.sendRequest(createPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(createPetResponse, 200)

def tags = ["tag1", "tag2"]
def findByTagsRequest = findTestObject('Object Repository/Swagger Petstore/findPetsByTags')
findByTagsRequest.addParameter('tags', tags.join(','))
addHeaderConfiguration(findByTagsRequest)
def findByTagsResponse = WSBuiltInKeywords.sendRequest(findByTagsRequest)
WSBuiltInKeywords.verifyResponseStatusCode(findByTagsResponse, 200)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

