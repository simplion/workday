package com.workday.salesforce.actions;
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
	
	public void Click_On_CSODAdminstration_Tab(){
		click("CSOD_Administration_tab", "HomePage");
	}
}
