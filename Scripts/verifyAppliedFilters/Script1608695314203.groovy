import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
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
import org.testng.Assert as Assert

WebUI.comment('Setup first test steps')

CustomKeywords.'utilities.setupTest.setupTestData'()

WebUI.comment('Verify applied filters when setting test data')

WebUI.verifyElementText(findTestObject('ResultsPage_OR/div_location'), GlobalVariable.filteredLocation)

dates = WebUI.getText(findTestObject('ResultsPage_OR/div_dates'))

Assert.assertTrue(dates.contains(GlobalVariable.checkInExactDate))

Assert.assertTrue(dates.contains(GlobalVariable.checkOutExactDate))

WebUI.verifyElementText(findTestObject('ResultsPage_OR/div_guests'), GlobalVariable.guestsNumString)

propertiesOnFirstRow = WebUI.getText(findTestObject('Object Repository/ResultsPage_OR/firstRawOfProperties'))

guestsNumOnFirstRow = Integer.parseInt(propertiesOnFirstRow.split(' ')[0])

WebUI.verifyGreaterThanOrEqual(guestsNumOnFirstRow, GlobalVariable.guestsNum)

WebUI.closeBrowser()

