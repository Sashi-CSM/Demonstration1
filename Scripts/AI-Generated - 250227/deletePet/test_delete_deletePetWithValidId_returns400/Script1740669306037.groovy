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

def addPetRequest = findTestObject('Object Repository/Swagger Petstore/addPet')
def pet_data = '{"name": "Test Pet", "photoUrls": ["http://test.com/photo"]}'
def addPetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(pet_data))
addPetRequest.setBodyContent(addPetPayload)
addHeaderConfiguration(addPetRequest)
def addPetResponse = WSBuiltInKeywords.sendRequest(addPetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(addPetResponse, 200)

def pet_id = new JsonSlurper().parseText(addPetResponse.getResponseText()).id

if (pet_id == null) {
    println("Failed to create a new Pet")
    return
}

def deletePetRequest = findTestObject('Object Repository/Swagger Petstore/deletePet', ['petId': pet_id])
addHeaderConfiguration(deletePetRequest)
def deletePetResponse = WSBuiltInKeywords.sendRequest(deletePetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(deletePetResponse, 200)

def deletePetRequestSecond = findTestObject('Object Repository/Swagger Petstore/deletePet', ['petId': pet_id])
addHeaderConfiguration(deletePetRequestSecond)
def deletePetResponseSecond = WSBuiltInKeywords.sendRequest(deletePetRequestSecond)
WSBuiltInKeywords.verifyResponseStatusCode(deletePetResponseSecond, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

