package com.workday.salesforce.actions.services;
import org.openqa.selenium.WebDriver;

public class HomePageActions extends BaseActions{
	
	WebDriver driver;
	
	public HomePageActions(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	public boolean verify_Home_Page_Loaded(){
		return isElementDisplayed("workDayLogo", "HomePage");
			//return false;
	}
	
	public boolean verify_CP_Home_Page_Loaded(){
		return isElementDisplayed("CP_CustomerCenter_txt", "HomePage");
	}
	public void Click_On_CSODAdminstration_Tab(){
		click("CSOD_Administration_tab", "HomePage");
	}
	public void navigate_to_Accounts()
	{
		click("Accounts_tab","HomePage");
		click("AccountName","HomePage");
	}
	
	/**
	 This method is to navigate to Deployment edit page.
	 */
	public void navigateToDeploymenteditpage()
	{
		click("CustomerScorecard_button","CustomerScorecardPage");
		//click("NewDeployments_button","CustomerScorecardPage");
	}

}
