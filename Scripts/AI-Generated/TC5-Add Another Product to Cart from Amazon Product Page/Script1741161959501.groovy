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

"Step 1: Navigate to */dp/*/ref=sr 1 6 with params (dib, dib tag, pf rd i, pf rd m, pf rd s, qid, refinements, rnid, rps, s, sr)"

TrueTestScripts.navigate("${GlobalVariable.path_param_1}/dp/${GlobalVariable.dp_id}/ref=sr_1_6", ["dib": GlobalVariable.ref_sr_1_6_dib, "dib_tag": GlobalVariable.ref_sr_1_6_dib_tag, "pf_rd_i": GlobalVariable.ref_sr_1_6_pf_rd_i, "pf_rd_m": GlobalVariable.ref_sr_1_6_pf_rd_m, "pf_rd_s": GlobalVariable.ref_sr_1_6_pf_rd_s, "qid": GlobalVariable.ref_sr_1_6_qid, "refinements": GlobalVariable.ref_sr_1_6_refinements, "rnid": GlobalVariable.ref_sr_1_6_rnid, "rps": GlobalVariable.ref_sr_1_6_rps, "s": GlobalVariable.ref_sr_1_6_s, "sr": GlobalVariable.ref_sr_1_6_sr])

"Step 2: Click on input AddToCart2 -> Navigate to page 'ecommerce#cart/smart-wagon'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/dp/.*/ref=sr_1_6?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product/input_AddToCart2'))

WebUI.takeScreenshot(reportLocation + '/TC5/Step 2-Click on input AddToCart2 - Navigate to page ecommercecartsmart-wagon.png')

"Step 3: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC5-Add Another Product to Cart from Amazon Product Page_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}