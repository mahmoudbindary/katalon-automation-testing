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

WebUI.comment('Verify applied extra filters')

WebUI.click(findTestObject('ResultsPage_OR/btnMoreFilters'))

for (def i : (1..GlobalVariable.bedroomsNum)) {
    WebUI.click(findTestObject('ResultsPage_OR/btnBedroomsIncrease'))
}

WebUI.click(findTestObject('ResultsPage_OR/btnPoolToggle'))

WebUI.click(findTestObject('ResultsPage_OR/btnShowStays'))

propertiesOnFirstRow = WebUI.getText(findTestObject('Object Repository/ResultsPage_OR/firstRawOfProperties'))

filters = propertiesOnFirstRow.split('·')

bedroomsNumOnFirstRow = Integer.parseInt((filters[1]).trim().split(' ')[0])

WebUI.verifyGreaterThanOrEqual(bedroomsNumOnFirstRow, GlobalVariable.bedroomsNum)

WebUI.click(findTestObject('ResultsPage_OR/firstPropertyLink'))

WebUI.switchToWindowIndex(1)

WebUI.verifyTextPresent('pool', false)

WebUI.closeBrowser()

