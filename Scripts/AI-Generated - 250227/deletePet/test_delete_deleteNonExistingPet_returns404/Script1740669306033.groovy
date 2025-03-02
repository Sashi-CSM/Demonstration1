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

def petData = '{"name": "Test Pet", "photoUrls": ["http://test.com/photo"]}'
def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def addPetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(petData))
addPetRequest.setBodyContent(addPetPayload)
addHeaderConfiguration(addPetRequest)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)

def petId = new JsonSlurper().parseText(addPetResponse.getResponseText()).id

if (!petId) {
    println("Failed to create a new Pet")
    return
}

def deletePetRequest = findTestObject('Object Repository/Swagger Petstore/deletePet', ["petId": petId])
addHeaderConfiguration(deletePetRequest)
def deletePetResponse = WSBuiltInKeywords.sendRequest(deletePetRequest)
println("Step 3 - Status Code: ${deletePetResponse.getStatusCode()}")

def secondDeletePetRequest = findTestObject('Object Repository/Swagger Petstore/deletePet', ["petId": petId])
addHeaderConfiguration(secondDeletePetRequest)
def secondDeletePetResponse = WSBuiltInKeywords.sendRequest(secondDeletePetRequest)
println("Step 4 - Status Code: ${secondDeletePetResponse.getStatusCode()}")

if (secondDeletePetResponse.getStatusCode() == 404) {
    println("Step 5 - Test Passed")
} else {
    println("Step 5 - Test Failed")
}

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

