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

def petPayload = '{"name": "Test Pet", "photoUrls": ["http://test.com/photo"]}'
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def addPetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(petPayload))
addPetRequest.setBodyContent(addPetPayload)
addHeaderConfiguration(addPetRequest)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)

def petId = new JsonSlurper().parseText(addPetResponse.getResponseText()).id

if (petId) {
    def invalidPetId = 999999999
    def deletePetRequest = findTestObject('Object Repository/Swagger Petstore/deletePet', ['petId': invalidPetId])
    addHeaderConfiguration(deletePetRequest)
    def deletePetResponse = WSBuiltInKeywords.sendRequest(deletePetRequest)
    
    if (WSBuiltInKeywords.verifyResponseStatusCode(deletePetResponse, 400)) {
        println("Test Passed: DELETE request with invalid petId returned status code 400")
    } else {
        println("Test Failed: DELETE request with invalid petId did not return status code 400")
    }
} else {
    println("Test Failed: Unable to extract Pet ID from the response")
}

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

