package com.workday.salesforce.actions.services;

import org.openqa.selenium.WebDriver;

import com.workday.salesforce.actions.services.BaseActions;

public class CsodTrainingManagementPageAction extends BaseActions {
	WebDriver driver;

	public CsodTrainingManagementPageAction(WebDriver driver){
			super(driver);
			this.driver = driver;
		}
		public void navigate_to_trainingmanagement()
		{
			click("CSOD_Administration_tab", "CSODModule");
			click("CsodCustomer_Lookup","CSODModule");
			switchToWindow("Csodcustomer_name");
			click("TrainingManagement_Link", "CSODModule");	
		}
		public void verify_Lod_susciptionUI()
		{
			isElementDisplayed("AgreementLineItemLod", "CSODModule");
			isElementDisplayed("OrderFormNumberlod", "CSODModule");
			isElementDisplayed("EffectiveDatelod", "CSODModule");
			isElementDisplayed("ExpiryDatelod", "CSODModule");
			isElementDisplayed("TotalCountlod", "CSODModule");
			isElementDisplayed("AssignedCountlod", "CSODModule");
			isElementDisplayed("Availablelod", "CSODModule");
		}
		public void Verify_AssignUnassign_buttonLOD()
		{
			click("AssignUnassignbutton", "CSODModule");
			click("AddrowButton_assignuser","CSODModule");
			click("Assignuser_lookup1","CSODModule");
			switchToWindow("Assignusername");
			click("AssignuserSavebutton", "CSODModule");
			click("Selectusertounassign", "CSODModule");
			click("DeleteCheckedbutton", "CSODModule");
		}
		public void Verify_DuplicateContact_AssignLod()
		{
			click("AssignUnassignbutton", "CSODModule");
			click("AddrowButton_assignuser","CSODModule");
			click("Assignuser_lookup1","CSODModule");
			switchToWindow("Assignusername");
			click("AssignUnassignbutton", "CSODModule");
			click("AddrowButton_assignuser","CSODModule");
			click("Assignuser_lookup2","CSODModule");
			switchToWindow("Assignusername");
			click("AssignuserSavebutton", "CSODModule");
			isElementDisplayed("DuplicateContactErrormessage", "CSODModule");
			
		}
		
		public void Add_KitUser_ButtonFunctionality()
		{
			click("AssignUnassignbuttonAKM", "CSODModule");
			click("AddAkUser","CSODModule");
			click("AddAKUserLookup","CSODModule");
			switchToWindow("AssignusernameAKM");
			click("SavebuttonAKM", "CSODModule");
			click("Selectusertodelete","CSODModule");
			click("DeleteAKuser","CSODModule");
		}
	
		


}
