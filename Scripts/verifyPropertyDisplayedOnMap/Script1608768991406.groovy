import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import org.testng.Assert as Assert
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import static org.junit.Assert.*
import org.junit.Test as Test
import org.openqa.selenium.By as By
import org.openqa.selenium.By.ByXPath as ByXPath
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement

WebUI.comment('Setup first test steps')

CustomKeywords.'utilities.setupTest.setupTestData'()

WebUI.comment('Verify property color changes on map when hover over the property link on search list')

WebUI.mouseOver(findTestObject('ResultsPage_OR/firstPropertyLink'))

firstPropertyOnMapStyle = WebUI.getAttribute(findTestObject('Object Repository/ResultsPage_OR/firstPropertyOnMapStyle'), 
    'style')

backgroundColors = (firstPropertyOnMapStyle.split(';')[1]).trim()

WebUI.verifyMatch(backgroundColors, expectedBackgroundColors, false)

WebUI.comment('Verify properties are the same on search list and map')

WebUI.click(findTestObject('ResultsPage_OR/firstPropertyOnMap'))

ratingString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyRating'))

ratingOnMapString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyRatingOnMap'))

WebUI.verifyMatch(ratingOnMapString, ratingString, false)

nameString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyName'))

nameOnMapString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyNameOnMap'))

WebUI.verifyMatch(nameOnMapString, nameString, false)

priceString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyPrice'))

priceOnMapString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyPriceOnMap'))

WebUI.verifyMatch(priceOnMapString, priceString, false)

cityOnMapString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyCityOnMap'))

cityOnMapString = (cityOnMapString.split('·')[1]).trim()

typeOnMapString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyTypeOnMap'))

typeAndCityString = WebUI.getText(findTestObject('ResultsPage_OR/firstPropertyTypeAndCity'))

Assert.assertTrue(typeAndCityString.contains(cityOnMapString))

Assert.assertTrue(typeAndCityString.contains(typeOnMapString))

WebUI.closeBrowser(FailureHandling.STOP_ON_FAILURE)

