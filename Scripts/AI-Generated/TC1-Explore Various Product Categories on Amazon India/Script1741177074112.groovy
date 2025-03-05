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

"Step 3: Click on link EchoAndAlexa"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_home/link_EchoAndAlexa'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 3-Click on link EchoAndAlexa.png')

"Step 4: Click on link SeeAllDevicesWithAlexa -> Navigate to page 'generic browse#gp/browse.html'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_home/link_SeeAllDevicesWithAlexa'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 4-Click on link SeeAllDevicesWithAlexa - Navigate to page generic browsegpbrowsehtml.png')

"Step 5: Click on link KindleEBooks"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/browse.html?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_browse/link_KindleEBooks'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 5-Click on link KindleEBooks.png')

"Step 6: Click on link KindleEBooks -> Navigate to page 'ecommerce#*/storefront'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/browse.html?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_browse/link_KindleEBooks'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 6-Click on link KindleEBooks - Navigate to page ecommercestorefront.png')

"Step 7: Click on link Categories"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/storefront?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce/link_Categories'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 7-Click on link Categories.png')

"Step 8: Click on link ActionAndAdventure -> Navigate to page 'homepage#*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/storefront?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce/link_ActionAndAdventure'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 8-Click on link ActionAndAdventure - Navigate to page homepage.png')

"Step 9: Click on link BestSellers -> Navigate to page 'product listing#gp/*/*/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_homepage/link_BestSellers'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 9-Click on link BestSellers - Navigate to page product listinggp.png')

"Step 10: Click on link IndianLanguageEBooks -> Navigate to page 'homepage#*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*/.*/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_listing/link_IndianLanguageEBooks'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 10-Click on link IndianLanguageEBooks - Navigate to page homepage.png')

"Step 11: Click on link FreeKindleReadingApps -> Navigate to page 'generic browse#gp/browse.html'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_homepage/link_FreeKindleReadingApps'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 11-Click on link FreeKindleReadingApps - Navigate to page generic browsegpbrowsehtml.png')

"Step 12: Click on link BestSellers -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/browse.html?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_browse/link_BestSellers'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 12-Click on link BestSellers - Navigate to page generic product listinggp.png')

"Step 13: Click on link TodaysDeals -> Navigate to page 'deals page#*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_TodaysDeals'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 13-Click on link TodaysDeals - Navigate to page deals page.png')

"Step 14: Click on link Mobiles -> Navigate to page 'product category pages#*/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_deals_page/link_Mobiles'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 14-Click on link Mobiles - Navigate to page product category pages.png')

"Step 15: Click on link CustomerService -> Navigate to page 'help#gp/help/customer/display.html'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_category_pages/link_CustomerService'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 15-Click on link CustomerService - Navigate to page helpgphelpcustomerdisplayhtml.png')

"Step 16: Click on link NewReleases -> Navigate to page 'generic product listing#gp/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/help/customer/display.html?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_help/link_NewReleases'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 16-Click on link NewReleases - Navigate to page generic product listinggp.png')

"Step 17: Click on link Electronics -> Navigate to page 'product category pages#*/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'gp/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_generic_product_listing/link_Electronics'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 17-Click on link Electronics - Navigate to page product category pages.png')

"Step 18: Click on link AmazonPay -> Navigate to page 'ecommerce home#amazonpay/home'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_category_pages/link_AmazonPay'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 18-Click on link AmazonPay - Navigate to page ecommerce homeamazonpayhome.png')

"Step 19: Click on link AmazonLogo -> Navigate to page 'navigation link#ref=nav logo'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'amazonpay/home?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce_home/link_AmazonLogo'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 19-Click on link AmazonLogo - Navigate to page navigation linkrefnav logo.png')

"Step 20: Click on link boAt -> Navigate to page 'single#s'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 'ref=nav_logo?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_navigation_link/link_boAt'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 20-Click on link boAt - Navigate to page singles.png')

"Step 21: Click on link Electronics -> Navigate to page 'product category pages#*/*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + 's?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_single/link_Electronics'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 21-Click on link Electronics - Navigate to page product category pages.png')

"Step 22: Click on link MobilesAndAccessories -> Navigate to page 'homepage#*'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_product_category_pages/link_MobilesAndAccessories'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 22-Click on link MobilesAndAccessories - Navigate to page homepage.png')

"Step 23: Click on link productCategories (LaptopsAndAccessories)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_homepage/link_productCategories"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_homepage/link_productCategories', ['link_productCategories_internalLabel': link_productCategories_internalLabel]))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 23-Click on link productCategories LaptopsAndAccessories.png')

"Step 24: Click on link productCategories (TVAndHomeEntertainment)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_homepage/link_productCategories"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_homepage/link_productCategories', ['link_productCategories_internalLabel': link_productCategories_internalLabel_1]))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 24-Click on link productCategories TVAndHomeEntertainment.png')

"Step 25: Click on link productCategories (Audio)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_homepage/link_productCategories"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_homepage/link_productCategories', ['link_productCategories_internalLabel': link_productCategories_internalLabel_2]))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 25-Click on link productCategories Audio.png')

"Step 26: Click on link productCategories (Cameras)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_homepage/link_productCategories"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_homepage/link_productCategories', ['link_productCategories_internalLabel': link_productCategories_internalLabel_3]))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 26-Click on link productCategories Cameras.png')

"Step 27: Click on link productCategories (ComputerPeripherals)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_homepage/link_productCategories"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_homepage/link_productCategories', ['link_productCategories_internalLabel': link_productCategories_internalLabel_4]))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 27-Click on link productCategories ComputerPeripherals.png')

"Step 28: Click on link productCategories (SmartTechnology)"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

// Bind values to the variables in the locators of "AI-Generated/Dynamic Objects/Page_homepage/link_productCategories"
WebUI.enhancedClick(findTestObject('AI-Generated/Dynamic Objects/Page_homepage/link_productCategories', ['link_productCategories_internalLabel': link_productCategories_internalLabel_5]))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 28-Click on link productCategories SmartTechnology.png')

"Step 29: Click on link SmartTVs -> Navigate to page 'ecommerce#*/ref=s9 acss bw cg revamp1 3b1 w'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_homepage/link_SmartTVs'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 29-Click on link SmartTVs - Navigate to page ecommercerefs9 acss bw cg revamp1 3b1 w.png')

"Step 30: Click on link AmazonLogo -> Navigate to page 'navigation link#ref=nav logo'"

// WebUI.verifyMatch(WebUI.getUrl(), GlobalVariable.application_domain + '.*/ref=s9_acss_bw_cg_revamp1_3b1_w?/?(?:#.*)?(?:\\?.*)?$', true)

WebUI.enhancedClick(findTestObject('AI-Generated/Page_ecommerce/link_AmazonLogo'))

WebUI.takeScreenshot(reportLocation + '/TC1/Step 30-Click on link AmazonLogo - Navigate to page navigation linkrefnav logo.png')

"Step 31: Take full page screenshot as checkpoint"

WebUI.takeFullPageScreenshotAsCheckpoint('TC1-Explore Various Product Categories on Amazon India_visual_checkpoint')

'Terminate test session: Close browser'

@com.kms.katalon.core.annotation.TearDown
def teardown() {
	WebUI.closeBrowser()
}