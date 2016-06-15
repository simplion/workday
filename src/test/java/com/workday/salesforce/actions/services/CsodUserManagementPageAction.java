package com.workday.salesforce.actions.services;

import org.openqa.selenium.WebDriver;

import com.workday.salesforce.actions.services.BaseActions;

public class CsodUserManagementPageAction extends BaseActions {
	WebDriver driver;

	public CsodUserManagementPageAction(WebDriver driver){
			super(driver);
			this.driver = driver;
		}
		public void navigate_to_usermanagement()
		{
			click("CSOD_Administration_tab", "CSODModule");
			click("CsodCustomer_Lookup","CSODModule");
			switchToWindow("Csodcustomer_name");
			click("UserManagement_Link", "CSODModule");		
		}
	public boolean search_for_existinguser()
	{
		click("AddRow_button", "CSODModule");
		writeTextInto("LastName_txtbox", "CSODModule", "test");
		click("Search_button", "CSODModule");
		return isElementDisplayed("Select_link", "CSODModule");
	}

	public void create_new_contact_layout() 
	{
		click("AddRow_button", "CSODModule");
		isElementDisplayed("Firstname_dropdown", "CSODModule");
		isElementDisplayed("FirstName_txtbox", "CSODModule");
		isElementDisplayed("Email", "CSODModule");
		isElementDisplayed("LastName_txtbox", "CSODModule");
		isElementDisplayed("WorkdayRole_dropdown", "CSODModule");
		isElementDisplayed("TrainingCordinator_dropdown", "CSODModule");
		isElementDisplayed("Saveandexit_button", "CSODModule");
	}

	public void csod_pagination()
	{
		//code needs to be written
	}
}