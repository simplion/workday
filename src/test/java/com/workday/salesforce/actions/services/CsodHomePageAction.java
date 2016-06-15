package com.workday.salesforce.actions.services;

import org.openqa.selenium.WebDriver;

import com.workday.salesforce.actions.services.BaseActions;
public class CsodHomePageAction extends BaseActions{
	
	WebDriver driver;
	
	public CsodHomePageAction(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	public void verifyCsodlinks()
	{
		click("CSOD_Administration_tab", "CSODModule");
		isElementDisplayed("UserManagement_Link", "CSODModule");
		isElementDisplayed("TrainingManagement_Link", "CSODModule");
		
	}
	

}
