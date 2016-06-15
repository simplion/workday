package com.workday.salesforce.setup;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.workday.salesforce.actions.services.BaseActions;
import com.workday.salesforce.actions.services.CsodCreateAggrementLineItemPageAction;
import com.workday.salesforce.actions.services.CsodHomePageAction;
import com.workday.salesforce.actions.services.CsodTrainingManagementPageAction;
import com.workday.salesforce.actions.services.CsodUserManagementPageAction;
import com.workday.salesforce.actions.services.HomePageActions;
import com.workday.salesforce.actions.services.LoginPageActions;
import com.workday.salesforce.actions.services.MarketPlacePageAction;
import com.workday.salesforce.actions.services.SCCaseAdditionalReducedCostTenantPageAction;
import com.workday.salesforce.actions.services.SCCaseAdditionalTenantRequestPageAction;
import com.workday.salesforce.actions.services.SCCaseDetailPageAction;
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
	public MarketPlacePageAction marketPlace=null;
	public SCCaseAdditionalTenantRequestPageAction serivicecareatr=null;
	public SCCaseAdditionalReducedCostTenantPageAction servicecarerct=null;
	public SCCaseDetailPageAction sccasedetailpage=null;
	public CsodHomePageAction csodhomepage=null;
	public CsodUserManagementPageAction usermgmtpage=null;
	public CsodTrainingManagementPageAction trainingmgmtpage=null;
	public CsodCreateAggrementLineItemPageAction aggrementlineitempage=null;
	
	
	/**
	 * Initialize all the page objects for all action classes
	 */
	private void _initActions()
	{
		homepage = new HomePageActions(driver);
		baseAction = new BaseActions(driver);
		loginPage = new LoginPageActions(driver);
		marketPlace = new MarketPlacePageAction(driver);
		serivicecareatr =new SCCaseAdditionalTenantRequestPageAction(driver);
		servicecarerct = new SCCaseAdditionalReducedCostTenantPageAction (driver);
		sccasedetailpage=new SCCaseDetailPageAction(driver);
		csodhomepage = new CsodHomePageAction(driver);
		usermgmtpage=new CsodUserManagementPageAction(driver);
		trainingmgmtpage=new CsodTrainingManagementPageAction(driver);
		aggrementlineitempage=new CsodCreateAggrementLineItemPageAction(driver);
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
		driver = wdf.getBrowser();	
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
	

