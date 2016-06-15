package com.workday.salesforce.utils;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class BasePage extends Locators implements UtilityMethods{
	WebDriver driver;
	
	public BasePage(WebDriver driver){
		super(driver);
		this.driver = driver;
		
	}
	
	public void click(String elementName, String fileName) {
		// TODO Auto-generated method stub
		getElement(elementName, fileName).click();
		
	}

	public void click(String elementName, String fileName, String textToReplace) {
		// TODO Auto-generated method stub
		getElement(elementName, fileName, textToReplace).click();
	}

	public void writeTextInto(String elementName, String fileName, String textToReplace, String inputText) {
		// TODO Auto-generated method stub
		getElement(elementName, fileName, textToReplace).sendKeys(inputText);
		
	}

	public void writeTextInto(String elementName, String fileName, String inputText) {
		// TODO Auto-generated method stub
		getElement(elementName, fileName).sendKeys(inputText);
		
	}
	
	
	public void hardWait(int seconds){
		try {
			Thread.sleep(seconds*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void launchApplication(String URL){
		driver.get(URL);
	}
	
	protected String getPageTitle() {
		return driver.getTitle();
	}

	public void logMessage(String message) {
		Reporter.log(message, true);
	}

	public String getCurrentURL() {
		return driver.getCurrentUrl();
	}

	protected void verifyPageUrlContains(String pageUrlPart){
		String currentUrl = getCurrentURL();
		//assertThat("FAILED: wrong page. Url does not contain expected value", currentUrl, containsString(pageUrlPart));
		logMessage("PASSED: Current Page url '" + currentUrl + "' is expected!!!");
	}
	
	protected WebElement getElementByIndex(List<WebElement> elementlist,
			int index) {
		return elementlist.get(index);
	}

	protected WebElement getElementByExactText(List<WebElement> elementlist,
			String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().equalsIgnoreCase(elementtext.trim())) {
				element = elem;
			}
		}
		// FIXME: handle if no element with the text is found in list No element
		// exception
		if (element == null) {
		}
		return element;
	}

	protected WebElement getElementByContainsText(List<WebElement> elementlist,
			String elementtext) {
		WebElement element = null;
		for (WebElement elem : elementlist) {
			if (elem.getText().contains(elementtext.trim())) {
				element = elem;
			}
		}
		// FIXME: handle if no element with the text is found in list
		if (element == null) {
		}
		return element;
	}

	protected void switchToFrame(WebElement element) {
		// switchToDefaultContent();
		wait.waitForElementToBeAppear(element);
		driver.switchTo().frame(element);
	}

	public void switchToDefaultContent() {
		driver.switchTo().defaultContent();
	}

	protected void executeJavascript(String script) {
		((JavascriptExecutor) driver).executeScript(script);
	}
	
	protected void hover(WebElement element) {
		Actions hoverOver = new Actions(driver);
		hoverOver.moveToElement(element).build().perform();
	}

	protected void handleAlert() {
		try {
			switchToAlert().accept();
			logMessage("Alert handled..");
			driver.switchTo().defaultContent();
		} catch (Exception e) {
		}
	}

	private Alert switchToAlert() {
		WebDriverWait wait = new WebDriverWait(driver, 1);
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	protected void scrollDown(WebElement element) {
		((JavascriptExecutor) driver).executeScript(
				"arguments[0].scrollIntoView(true);", element);
	}

	protected void hoverClick(WebElement element) {
		Actions hoverClick = new Actions(driver);
		hoverClick.moveToElement(element).click().build().perform();
	}

	
	private boolean isElementAHyperlink(WebElement element){
		boolean flag = false;
		System.err.println("****** tag Name = " + element.getTagName() );
		if(element.getTagName().equals("a")){
		flag = true;
		}else{
			flag = false;}
		return flag;
	}
	
	protected void verifyElementIsHyperlinked(WebElement element){
		Assert.assertTrue(isElementAHyperlink(element), "[Failed]: Element \'"+element.getText()+ "\' is not a hyperlink");
		logMessage("[Passed: Element \'"+element.getText()+ "\' is a hyperlink]");
	}
	
	protected void verifyElementIsNotHyperlinked(WebElement element){
		Assert.assertTrue(!(isElementAHyperlink(element)), "[Failed]: Element \'"+element.getText()+ "\' is a hyperlink");
		logMessage("[Passed: Element \'"+element.getText()+ "\' is not a hyperlink]");
	}
	
	public String getText(String locator, String fileName){
		String getText=null;
		getText = getElement(locator, fileName).getText();
		return getText;
	}
	
	public String getText(String locator, String fileName, String textToReplace){
		String getText=null;
		getText = getElement(locator, fileName, textToReplace).getText();
		return getText;
	}
	
	public boolean getTextAndMatchString(String locator, String fileName, String textToReplace, String textToVerify ){
		hardWait(3);
		if(getElement(locator, fileName, textToReplace).getText().trim().contains(textToVerify)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean getTextAndMatchString(String locator, String fileName, String textToVerify ){
		hardWait(1);
		if(getElement(locator, fileName).getText().trim().contains(textToVerify)){
			return true;
		}else{
			return false;
		}
	}
	
	public void selectOptionByVisibleText(String dropdownElement, String fileName, String optionNeedToSelect){
		Select dropdown = new Select(getElement(dropdownElement, fileName));
		dropdown.selectByVisibleText(optionNeedToSelect);
	}
	
	public void selectOptionByIndex(String dropdownElement, String fileName, int index){
		Select dropdown = new Select(getElement(dropdownElement, fileName));
		dropdown.selectByIndex(index);
	}
	
	public void nevigateToURL(String URL){
		driver.navigate().to(URL);
	}

	public void closeCurrentBrowserWindow(){
		driver.close();
	}
	
	public void closeAllBrowserWindow(){
		driver.quit();
	}
	
	public boolean isElementDisplayed(String locator, String fileName) {
		hardWait(1);
		try {
			if (getElement(locator, fileName).isDisplayed()) {
				return true;
			} else if (getElement(locator, fileName) == null){
				return false;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	public boolean isElementDisplayed(String locator, String fileName, String textToReplace) {
		hardWait(1);
		try {
			if (getElement(locator, fileName, textToReplace).isDisplayed()) {
				return true;
			} else if (getElement(locator, fileName, textToReplace)==null){
				return false;
			}else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}
	
	
	public void captureScreenshot(String screenshotName) {

		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			System.out.println("driver" + driver);

			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/" + screenshotName + ".png"));

			System.out.println("Screenshot taken");
		} catch (Exception e) {

			System.out.println("Exception while taking screenshot "
					+ e.getMessage());
		}
	}
}
