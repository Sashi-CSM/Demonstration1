import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import truetest.custom.TrueTestScripts

def reportLocation = RunConfiguration.getReportFolder()

'Initialize test session: Open browser and set view port'

@com.kms.katalon.core.annotation.SetUp
def setup() {
	WebUI.openBrowser('')
	WebUI.setViewPortSize(1920, 1080)	
}

"Step 1: Navigate to */dp/*/ref=lp 10894230031 1 1 with params (pf rd p, pf rd r, sbo, th)"

TrueTestScripts.navigate("${GlobalVariable.path_param_1}/dp/${GlobalVariable.dp_id}/ref=lp_10894230031_1_1", ["pf_rd_p": GlobalVariable.ref_lp_10894230031_1_1_pf_rd_p, "pf_rd_r": GlobalVariable.ref_lp_10894230031_1_1_pf_rd_r, "sbo": GlobalVariable.ref_lp_10894230031_1_1_sbo, "th": GlobalVariable.ref_lp_10894230031_1_1_th])

"Step 2: Click on input AddToCart -> Navigate to page 'ecommerce#cart/smart-wagon'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/dp/.*/ref=lp_10894230031_1_1?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product/input_AddToCart'))

WebUI.takeScreenshot(reportLocation + '/TC3/Step 2-Click on input AddToCart - Navigate to page ecommercecartsmart-wagon.png')

"Step 3: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC3-Add Product to Cart from Amazon Product Page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}