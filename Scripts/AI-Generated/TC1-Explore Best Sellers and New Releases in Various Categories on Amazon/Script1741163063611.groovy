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

"Step 1: Navigate to /"

TrueTestScripts.navigate("/")

"Step 2: Click on link AllCategoriesMenu"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_home/link_AllCategoriesMenu'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 2-Click on link AllCategoriesMenu.png')

"Step 3: Click on link BestSellers -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_home/link_BestSellers'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 3-Click on link BestSellers - Navigate to page generic product listinggp.png')

"Step 4: Click on link AmazonLaunchpad -> Navigate to page 'product listing#gp/*/*/ref=zg bs nav boost 0'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_AmazonLaunchpad'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 4-Click on link AmazonLaunchpad - Navigate to page product listinggprefzg bs nav boost 0.png')

"Step 5: Click on link Collections -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 1'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bs_nav_boost_0?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Collections'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 5-Click on link Collections - Navigate to page product listinggprefzg bs nav boost 1.png')

"Step 6: Click on link DisruptiveInnovations -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 2 10894251031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_1?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_DisruptiveInnovations'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 6-Click on link DisruptiveInnovations - Navigate to page product listinggprefzg bs nav boost 2 10894251031.png')

"Step 7: Click on link LifeHacks -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 2 14091238031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_2_10894251031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_LifeHacks'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 7-Click on link LifeHacks - Navigate to page product listinggprefzg bs nav boost 2 14091238031.png')

"Step 8: Click on link FOOD -> Navigate to page 'single character path#*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_2_14091238031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_FOOD'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 8-Click on link FOOD - Navigate to page single character path.png')

"Step 9: Click on link BestSellerGrocery"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_single_character_path/link_BestSellerGrocery'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 9-Click on link BestSellerGrocery.png')

"Step 10: Click on link AllCategoriesMenu"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_single_character_path/link_AllCategoriesMenu'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 10-Click on link AllCategoriesMenu.png')

"Step 11: Click on link NewReleases -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_single_character_path/link_NewReleases'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 11-Click on link NewReleases - Navigate to page generic product listinggp.png')

"Step 12: Click on link ClothingAndAccessories -> Navigate to page 'product listing#gp/*/*/ref=zg bsnr nav apparel 0'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_ClothingAndAccessories'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 12-Click on link ClothingAndAccessories - Navigate to page product listinggprefzg bsnr nav apparel 0.png')

"Step 13: Click on link Baby -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav apparel 1'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsnr_nav_apparel_0?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Baby'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 13-Click on link Baby - Navigate to page product listinggprefzg bsnr nav apparel 1.png')

"Step 14: Click on link BabyBoys -> Navigate to page 'ecommerce product listing#gp/*/*/*/ref=zg bsnr nav apparel 2 1953148031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_apparel_1?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_BabyBoys'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 14-Click on link BabyBoys - Navigate to page ecommerce product listinggprefzg bsnr nav apparel 2 1953148031.png')

"Step 15: Click on link EthnicWear -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav apparel 3 1953149031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_apparel_2_1953148031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce_product_listing/link_EthnicWear'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 15-Click on link EthnicWear - Navigate to page product listinggprefzg bsnr nav apparel 3 1953149031.png')

"Step 16: Click on link Pyjamas -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav apparel 4 3723394031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_apparel_3_1953149031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Pyjamas'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 16-Click on link Pyjamas - Navigate to page product listinggprefzg bsnr nav apparel 4 3723394031.png')

"Step 17: Click on link Sherwanis -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav apparel 4 16085637031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_apparel_4_3723394031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Sherwanis'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 17-Click on link Sherwanis - Navigate to page product listinggprefzg bsnr nav apparel 4 16085637031.png')

"Step 18: Click on link BestsellersInBabyBoysEthnicSherwanis -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr tab t apparel bs'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_apparel_4_16085637031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_BestsellersInBabyBoysEthnicSherwanis'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 18-Click on link BestsellersInBabyBoysEthnicSherwanis - Navigate to page product listinggprefzg bsnr tab t apparel bs.png')

"Step 19: Click on link QtsyDapperSherwani -> Navigate to page 'product#*/dp/*/ref=zg bs g 16085638031 d sccl 1/261-4519587-9490508'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_tab_t_apparel_bs?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_QtsyDapperSherwani'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 19-Click on link QtsyDapperSherwani - Navigate to page productdprefzg bs g 16085638031 d sccl 1261-4519587-9490508.png')

"Step 20: Click on link AllCategoriesMenu"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/dp/.*/ref=zg_bs_g_16085638031_d_sccl_1/261-4519587-9490508?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product/link_AllCategoriesMenu'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 20-Click on link AllCategoriesMenu.png')

"Step 21: Click on link MoversAndShakers -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/dp/.*/ref=zg_bs_g_16085638031_d_sccl_1/261-4519587-9490508?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product/link_MoversAndShakers'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 21-Click on link MoversAndShakers - Navigate to page generic product listinggp.png')

"Step 22: Click on link CarlingtonWatch -> Navigate to page 'product#*/dp/*/ref=zg bsms c watches d sccl 1/261-4519587-9490508'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_CarlingtonWatch'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 22-Click on link CarlingtonWatch - Navigate to page productdprefzg bsms c watches d sccl 1261-4519587-9490508.png')

"Step 23: Click on input Skip -> Navigate to page 'ecommerce#cart/smart-wagon'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/dp/.*/ref=zg_bsms_c_watches_d_sccl_1/261-4519587-9490508?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product/input_Skip'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 23-Click on input Skip - Navigate to page ecommercecartsmart-wagon.png')

"Step 24: Click on link AllCategoriesMenu"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'cart/smart-wagon?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce/link_AllCategoriesMenu'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 24-Click on link AllCategoriesMenu.png')

"Step 25: Click on link EchoAndAlexa"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'cart/smart-wagon?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce/link_EchoAndAlexa'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 25-Click on link EchoAndAlexa.png')

"Step 26: Click on link MeetName -> Navigate to page 'generic browse#gp/browse.html'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'cart/smart-wagon?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce/link_MeetName'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 26-Click on link MeetName - Navigate to page generic browsegpbrowsehtml.png')

"Step 27: Click on link AmazonLogo -> Navigate to page 'navigation link#ref=nav logo'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/browse.html?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_browse/link_AmazonLogo'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 27-Click on link AmazonLogo - Navigate to page navigation linkrefnav logo.png')

"Step 28: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Explore Best Sellers and New Releases in Various Categories on Amazon_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}