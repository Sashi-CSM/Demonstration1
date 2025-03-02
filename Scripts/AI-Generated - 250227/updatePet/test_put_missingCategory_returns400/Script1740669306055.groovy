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

def pet_data = [
    name: "TestPet__unique__",
    photoUrls: ["http://test.com/photo"],
    category: [id: 1, name: "TestCategory__unique__"],
    tags: [[id: 1, name: "TestTag__unique__"]],
    status: "available"
]

def updatePetRequest = findTestObject('Object Repository/Swagger Petstore/updatePet')
def updatePetPayload = new HttpTextBodyContent(replaceSuffixWithUUID(JsonOutput.toJson(pet_data)))
addHeaderConfiguration(updatePetRequest)
updatePetRequest.setBodyContent(updatePetPayload)
def updatePetResponse = WSBuiltInKeywords.sendRequest(updatePetRequest)
WSBuiltInKeywords.verifyResponseStatusCode(updatePetResponse, 400)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

