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

def categoryPayload = new HttpTextBodyContent(replaceSuffixWithUUID('{"id": 1, "name": "category__unique__"}'))
def addCategoryRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(addCategoryRequest)
addCategoryRequest.setBodyContent(categoryPayload)
def addCategoryResponse = WSBuiltInKeywords.sendRequest(addCategoryRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addCategoryResponse, 200)

def petPayload = new HttpTextBodyContent(replaceSuffixWithUUID('{"category": {"id": 1, "name": "category__unique__"}, "photoUrls": ["photoUrl__unique__"]}'))
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
addHeaderConfiguration(addPetRequest)
addPetRequest.setBodyContent(petPayload)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 405)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

