package com.workday.salesforce.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.workday.salesforce.actions.BaseActions;
import com.workday.salesforce.actions.HomePageActions;
import com.workday.salesforce.actions.LoginPageActions;
import com.workday.salesforce.utils.BasePage;

/**
 * @author NeerajAgarwal
 */
public class TestSessionInitiator{
	
	public TestSessionInitiator() {
		launchBrowserSession();
	}
			
	protected static WebDriver driver = null;
	private WebDriverFactory wdf = new WebDriverFactory();
	
	//Define all the page objects will null
	public BasePage baseui = null;
	public HomePageActions homepage = null;
	public BaseActions baseAction = null;
	public LoginPageActions loginPage = null;
	
	/**
	 * Initialize all the page objects for all action classes
	 */
	private void _initActions(){
		homepage = new HomePageActions(driver);
		baseAction = new BaseActions(driver);
		loginPage = new LoginPageActions(driver);
	}
	
	/**
	 * Launching browser instance
	 */
	private void launchBrowserSession(){
		_browserConfig();
		_initActions();	
	}
	
	/**
	 * This method is to configure the browser setting.
	 */
	private void _browserConfig(){
		driver = wdf.getBrowser("firefox");	
		driver.manage().deleteAllCookies();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Integer.parseInt("15"), TimeUnit.SECONDS);
	}
	
	/**
	 * This keyword is used to launch applications that use authentication
	 * to validate user
	 * @param applicationpath
	 * @param authUser
	 * @param authPed
	 */
	public void launchApplication(String applicationpath, String authUser, String authPwd, String browser) {
		System.out.println("browser name=="+ browser);
		if(!browser.equalsIgnoreCase("IE")){
		 applicationpath = applicationpath.replace(
		 "http://",
		 "http://" + authUser.replaceAll("@", "%40") + ":"
		 + authPwd.replaceAll("@", "%40") + "@");
		 Reporter.log("The application url is :- " + applicationpath, true);
		driver.get(applicationpath);
		}
	}
	
	public void getURL(String URL){
		driver.get(URL);
	}
	public void close(){
		driver.close();
	}
}
	

