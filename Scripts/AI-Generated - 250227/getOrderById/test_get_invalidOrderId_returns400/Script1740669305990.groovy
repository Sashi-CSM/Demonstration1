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

def endpoint = "/store/order/0"
def requestObject = findTestObject("Object Repository/Swagger Petstore/getOrderById")
def request = new RequestObject(requestObject)
request.setRestUrl("https://petstore.swagger.io/v2" + endpoint)
addHeaderConfiguration(request)

def response = WSBuiltInKeywords.sendRequest(request)
def expectedStatusCode = 400
WSBuiltInKeywords.verifyResponseStatusCode(response, expectedStatusCode)

def replaceSuffixWithUUID(payload) {
    replacedString = payload.replaceAll('unique__', uuid)
    return replacedString
}

