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

WebUI.takeScreenshot(reportLocation + '/TC2/Step 2-Click on link AllCategoriesMenu.png')

"Step 3: Click on link BestSellers -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_home/link_BestSellers'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 3-Click on link BestSellers - Navigate to page generic product listinggp.png')

"Step 4: Click on link AmazonLaunchpad -> Navigate to page 'product listing#gp/*/*/ref=zg bs nav boost 0'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_AmazonLaunchpad'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 4-Click on link AmazonLaunchpad - Navigate to page product listinggprefzg bs nav boost 0.png')

"Step 5: Click on link Body -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 1'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bs_nav_boost_0?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Body'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 5-Click on link Body - Navigate to page product listinggprefzg bs nav boost 1.png')

"Step 6: Click on link Beauty -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 2 10894224031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_1?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Beauty'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 6-Click on link Beauty - Navigate to page product listinggprefzg bs nav boost 2 10894224031.png')

"Step 7: Click on link Drugstore -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 2 10894225031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_2_10894224031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Drugstore'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 7-Click on link Drugstore - Navigate to page product listinggprefzg bs nav boost 2 10894225031.png')

"Step 8: Click on link Fashion -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 2 10894228031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_2_10894225031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Fashion'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 8-Click on link Fashion - Navigate to page product listinggprefzg bs nav boost 2 10894228031.png')

"Step 9: Click on link SportsAndOutdoors -> Navigate to page 'product listing#gp/*/*/*/ref=zg bs nav boost 2 10894226031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_2_10894228031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_SportsAndOutdoors'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 9-Click on link SportsAndOutdoors - Navigate to page product listinggprefzg bs nav boost 2 10894226031.png')

"Step 10: Click on link AllCategoriesMenu"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_2_10894226031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_AllCategoriesMenu'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 10-Click on link AllCategoriesMenu.png')

"Step 11: Click on link NewReleases -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bs_nav_boost_2_10894226031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_NewReleases'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 11-Click on link NewReleases - Navigate to page generic product listinggp.png')

"Step 12: Click on link AmazonLaunchpad2 -> Navigate to page 'product listing#gp/*/*/ref=zg bsnr nav boost 0'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_AmazonLaunchpad2'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 12-Click on link AmazonLaunchpad2 - Navigate to page product listinggprefzg bsnr nav boost 0.png')

"Step 13: Click on link Body2 -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav boost 1'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsnr_nav_boost_0?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Body2'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 13-Click on link Body2 - Navigate to page product listinggprefzg bsnr nav boost 1.png')

"Step 14: Click on link Beauty2 -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav boost 2 10894224031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_boost_1?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Beauty2'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 14-Click on link Beauty2 - Navigate to page product listinggprefzg bsnr nav boost 2 10894224031.png')

"Step 15: Click on link Drugstore2 -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav boost 2 10894225031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_boost_2_10894224031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Drugstore2'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 15-Click on link Drugstore2 - Navigate to page product listinggprefzg bsnr nav boost 2 10894225031.png')

"Step 16: Click on link Fashion2 -> Navigate to page 'product listing#gp/*/*/*/ref=zg bsnr nav boost 2 10894228031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_boost_2_10894225031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_Fashion2'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 16-Click on link Fashion2 - Navigate to page product listinggprefzg bsnr nav boost 2 10894228031.png')

"Step 17: Click on link SportsAndOutdoors2 -> Navigate to page 'ecommerce product listing#gp/*/*/*/ref=zg bsnr nav boost 2 10894226031'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_boost_2_10894228031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_SportsAndOutdoors2'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 17-Click on link SportsAndOutdoors2 - Navigate to page ecommerce product listinggprefzg bsnr nav boost 2 10894226031.png')

"Step 18: Click on link AllCategoriesMenu"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_boost_2_10894226031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce_product_listing/link_AllCategoriesMenu'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 18-Click on link AllCategoriesMenu.png')

"Step 19: Click on link MoversAndShakers -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*/ref=zg_bsnr_nav_boost_2_10894226031?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce_product_listing/link_MoversAndShakers'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 19-Click on link MoversAndShakers - Navigate to page generic product listinggp.png')

"Step 20: Click on link Books -> Navigate to page 'product category#gp/*/*/ref=zg bsms nav books 0'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_Books'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 20-Click on link Books - Navigate to page product categorygprefzg bsms nav books 0.png')

"Step 21: Click on link AmazonLaunchpad -> Navigate to page 'product listing#gp/*/*/ref=zg bsms nav boost 0 books'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsms_nav_books_0?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_category/link_AmazonLaunchpad'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 21-Click on link AmazonLaunchpad - Navigate to page product listinggprefzg bsms nav boost 0 books.png')

"Step 22: Click on link AmazonRenewed -> Navigate to page 'product category#gp/*/*/ref=zg bsms nav amazon-renewed 0 boost'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsms_nav_boost_0_books?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_AmazonRenewed'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 22-Click on link AmazonRenewed - Navigate to page product categorygprefzg bsms nav amazon-renewed 0 boost.png')

"Step 23: Click on link Beauty -> Navigate to page 'product category#gp/*/*/ref=zg bsms nav beauty 0 amazon-renewed'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsms_nav_amazon-renewed_0_boost?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_category/link_Beauty'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 23-Click on link Beauty - Navigate to page product categorygprefzg bsms nav beauty 0 amazon-renewed.png')

"Step 24: Click on link Books -> Navigate to page 'product listing#gp/*/*/ref=zg bsms nav books 0 beauty'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsms_nav_beauty_0_amazon-renewed?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_category/link_Books'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 24-Click on link Books - Navigate to page product listinggprefzg bsms nav books 0 beauty.png')

"Step 25: Click on link ClothingAndAccessories -> Navigate to page 'product category#gp/*/*/ref=zg bsms nav apparel 0 books'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsms_nav_books_0_beauty?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_ClothingAndAccessories'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 25-Click on link ClothingAndAccessories - Navigate to page product categorygprefzg bsms nav apparel 0 books.png')

"Step 26: Click on link diamondCraftUnisexTShirtKidsBoyDpB0dy -> Navigate to page 'product#*/dp/*/ref=zg bsms g apparel d sccl 1/261-4519587-9490508'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/ref=zg_bsms_nav_apparel_0_books?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_category/link_diamondCraftUnisexTShirtKidsBoyDpB0dy'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 26-Click on link diamondCraftUnisexTShirtKidsBoyDpB0dy - Navigate to page productdprefzg bsms g apparel d sccl 1261-4519587-9490508.png')

"Step 27: Click on input AddToCartButton -> Navigate to page 'ecommerce#cart/smart-wagon'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/dp/.*/ref=zg_bsms_g_apparel_d_sccl_1/261-4519587-9490508?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product/input_AddToCartButton'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 27-Click on input AddToCartButton - Navigate to page ecommercecartsmart-wagon.png')

"Step 28: Click on link AmazonLogo2 -> Navigate to page 'navigation link#ref=nav logo'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'cart/smart-wagon?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce/link_AmazonLogo'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 28-Click on link AmazonLogo2 - Navigate to page navigation linkrefnav logo.png')

"Step 29: Click on link AirConditioners -> Navigate to page 'single#s'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'ref=nav_logo?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_navigation_link/link_AirConditioners'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 29-Click on link AirConditioners - Navigate to page singles.png')

"Step 30: Click on link SingleProduct"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 's?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_single/link_SingleProduct'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 30-Click on link SingleProduct.png')

"Step 31: Click on link airConditionerFilters (DaikinFilter)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 's?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_single/link_airConditionerFilters"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_single/link_airConditionerFilters', ['link_airConditionerFilters_internalLabel': link_airConditionerFilters_internalLabel]))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 31-Click on link airConditionerFilters DaikinFilter.png')

"Step 32: Click on link LloydFilter"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 's?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_single/link_LloydFilter'))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 32-Click on link LloydFilter.png')

"Step 33: Click on link airConditionerFilters (BlueStarFilter)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 's?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_single/link_airConditionerFilters"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_single/link_airConditionerFilters', ['link_airConditionerFilters_internalLabel': link_airConditionerFilters_internalLabel_1]))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 33-Click on link airConditionerFilters BlueStarFilter.png')

"Step 34: Click on link airConditionerFilters (Carrier) -> Navigate to page ''"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 's?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_single/link_airConditionerFilters"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_single/link_airConditionerFilters', ['link_airConditionerFilters_internalLabel': link_airConditionerFilters_internalLabel_2]))

WebUI.takeScreenshot(reportLocation + '/TC2/Step 34-Click on link airConditionerFilters Carrier - Navigate to page .png')

"Step 35: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC2-Browse and Add Products to Cart on Amazon India_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}