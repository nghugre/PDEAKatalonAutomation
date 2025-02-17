package pdeakeywords

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class dashboard {
	@Keyword
	def static void loginIntoApplication(String applicationURL) {
		WebUI.openBrowser(applicationURL)
		WebUI.waitForPageLoad(2)
		WebUI.maximizeWindow()
		WebUI.delay(2)
		WebUI.waitForElementVisible(findTestObject('Pages/DashboardPage/acceptAllCookies'),1)
		TestObject element = findTestObject('Pages/DashboardPage/acceptAllCookies');
		if (WebUI.verifyElementPresent(element, 1)) {
			println("Inside click on accept cookies")
			WebUI.click(findTestObject('Pages/DashboardPage/acceptAllCookies'))
		}
	}

	@Keyword
	def static void loginIntoApplicationWithGlobalVariable() {
		loginIntoApplication(GlobalVariable.urlLogin)
	}

	@Keyword
	def static void verifyDashboardHeaderIsDisplayed() {
		WebUI.waitForElementVisible(findTestObject('Pages/DashboardPage/dashboardHeader'), 1)
		WebUI.delay(1)
	}

	@Keyword
	def static void verifyLogoIsVisible() {
		TestObject testObject = findTestObject('Pages/DashboardPage/logo');
		if (WebUI.verifyElementPresent(testObject, 1)) {
			println "Element is displayed"
		}
	}

	@Keyword
	def static void verifyResourceSareDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/resources');
		if(WebUI.verifyElementPresent(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/resources'));
			TestObject testObject2 = findTestObject('Pages/DashboardPage/resourcesContent');
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Resources Elements are displayed"
			}
		}
	}

	@Keyword
	def static void verifyCommunityHelpPagesDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/CommunityHelpBtn');
		if(WebUI.verifyElementPresent(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/CommunityHelpBtn'));
			TestObject testObject2 = findTestObject('Pages/DashboardPage/CommunityHelpContent');
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Community Help Elements are displayed"
			}
		}
	}

	@Keyword
	def static void clickAndverifyLoginElementsAreDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/loginBtnInHeader');
		if(WebUI.verifyElementPresent(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/loginBtnInHeader'));
			WebUI.click(findTestObject('Pages/DashboardPage/ContinueWithEmail'));
			TestObject testObject2 = findTestObject('Pages/DashboardPage/signInForm');
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Sign in form is displayed"
			}
		}
	}

	@Keyword
	def static void validatePasswordField() {
		TestObject testObject = findTestObject('Pages/DashboardPage/signInForm');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			WebUI.sendKeys(findTestObject('Pages/DashboardPage/username'),'nitin_ghugare@persistent.com');
			WebUI.sendKeys(findTestObject('Pages/DashboardPage/password'),'@@');
			WebUI.click(findTestObject('Pages/DashboardPage/signInBtn'));

			TestObject testObject2 = findTestObject('Pages/DashboardPage/invalidUsernameAndPassword')
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Error message is displayed"
			}
		}
	}

	@Keyword
	def static void validateErrorMsgForEmptyFields() {
		TestObject testObject = findTestObject('Pages/DashboardPage/signInForm');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/signInBtn'));
			TestObject testObject2 = findTestObject('Pages/DashboardPage/invalidUsernameAndPassword')
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Error message is displayed"
			}
		}
	}

	@Keyword
	def static void verifySignUpBtnIsClickable() {
		TestObject testObject = findTestObject('Pages/DashboardPage/signUpBtn');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/signUpBtn'));
			TestObject testObject2 = findTestObject('Pages/DashboardPage/signUpWithWorkEmail')
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Sign up buttin is clickable"
			}
		}
	}

	@Keyword
	def static void verifySignUpFormDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/signUpBtn');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/signUpBtn'));

			WebUI.click(findTestObject('Pages/DashboardPage/signUpWithWorkEmail'));

			TestObject testObject2 = findTestObject('Pages/DashboardPage/signUpForm')
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Sign up FormIsDisplayed"
			}
		}
	}

	@Keyword
	def static void verifyErrorMsgIsDisplayedOnSignUpFormForEmptyFields() {
		TestObject testObject = findTestObject('Pages/DashboardPage/submitSignUpForm');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/submitSignUpForm'));

			TestObject testObject2 = findTestObject('Pages/DashboardPage/signUpFormErrorMsg')
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Error msg is displayed"
			}
		}
	}

	@Keyword
	def static void verifyArticleLinkIsClickable() {
		TestObject testObject = findTestObject('Pages/DashboardPage/signUpArticle');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/signUpArticle'));
			println "Clicked on sign up article"
		}
	}

	@Keyword
	def static void verifyViewDemoOptionIsDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/viewDemoBtn');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			WebUI.click(findTestObject('Pages/DashboardPage/viewDemoBtn'));
		}
	}

	@Keyword
	def static void verifyViewDemoVideoIsDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/demoVideo');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			println "demo video is displayed"
		}
	}

	@Keyword
	def static void verifyScheduleCallOptionIsDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/scheduleCallbtn');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			println "demo video is displayed"

			WebUI.click(findTestObject('Pages/DashboardPage/scheduleCallbtn'));

			TestObject testObject2 = findTestObject('Pages/DashboardPage/bookDemoOption')
			if(WebUI.verifyElementPresent(testObject2, 1)) {
				println "Book demo option is displayed"
			}
		}
	}

	@Keyword
	def static void verifyViewAllDemoIsClickable() {
		TestObject testObject = findTestObject('Pages/DashboardPage/viewAllDemo');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			println "demo video is displayed"

			WebUI.scrollToElement(testObject, 1)
			WebUI.click(testObject)
			println "Clicked on view All demo"
		}
	}

	@Keyword
	def static void verifyDemosAreDisplayed() {
		TestObject testObject = findTestObject('Pages/DashboardPage/allDemo');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			println "All demos are displayed"
		}
	}

	@Keyword
	def static void selectVideoFilter() {
		TestObject testObject = findTestObject('Pages/DashboardPage/demoFilter');
		if(WebUI.waitForElementVisible(testObject, 1)) {
			println "CLicked on filter demo option"
		}
	}

	@Keyword
	def static void verifySignInOperation() {
		TestObject testObject = findTestObject('Pages/DashboardPage/signInForm');
		if(WebUI.waitForElementVisible(testObject, 1)) {

			WebUI.sendKeys(findTestObject('Pages/DashboardPage/username'), 'nitin_ghugare@persistent.com')
			WebUI.sendKeys(findTestObject('Pages/DashboardPage/password'), 'Mumbai@23')

			WebUI.click(findTestObject('Pages/DashboardPage/signInBtn'))

			TestObject testObject2 = findTestObject('Pages/DashboardPage/welcomeBack');

			if(WebUI.waitForElementVisible(testObject2, 1)) {
				println "succesfully logged in"
			}
		}
	}

	@Keyword
	def static void validateUsernameField() {
		TestObject testObject = findTestObject('Pages/DashboardPage/signInForm');
		if(WebUI.waitForElementVisible(testObject, 1)) {

			WebUI.sendKeys(findTestObject('Pages/DashboardPage/username'), '@@')
			WebUI.sendKeys(findTestObject('Pages/DashboardPage/password'), 'Mumbai@23')

			WebUI.click(findTestObject('Pages/DashboardPage/signInBtn'))

			TestObject testObject2 = findTestObject('Pages/DashboardPage/invalidUsernameAndPassword');

			if(WebUI.waitForElementVisible(testObject2, 1)) {
				println "Error message is displayed"
			}
		}
	}
}
