package com.workday.salesforce.actions.services;

import org.openqa.selenium.WebDriver;
import com.workday.salesforce.actions.services.BaseActions;
import com.workday.salesforce.utils.DataIO;

public class MarketPlacePageAction extends BaseActions {

	WebDriver driver;

	public MarketPlacePageAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void Click_OnCases_Tab() {
		click("CPCases_tab", "MarketPlacePage");
	}

	public void Click_On_CreateNewCases() {
		click("CPCreateNewCase_button", "MarketPlacePage");
	}

	public void Click_On_ProffesionalServicesRequest() {
		click("PSRcase_link", "MarketPlacePage");
	}

	public void select_Area() {
		selectOptionByVisibleText("CPArea_dropdown", "MarketPlacePage",
				"Data Load");
	}

	public void select_Product() {
		selectOptionByVisibleText("CPProduct_dropdown", "MarketPlacePage",
				"Product001");
	}

	public void Click_On_SubProduct() {
		click("CPSubproduct_checkbox", "MarketPlacePage");
	}

	public void EnterSubjectandDescription(String subject, String description) {
		// Enter User Name into textBox
		writeTextInto("CPSubject_txtbox", "MarketPlacePage", subject);

		// Enter password into textBox
		writeTextInto("CPDescription_txtbox", "MarketPlacePage", description);

		// Clicking on login Button
		click("CPSubmit_button", "MarketPlacePage");
	}
	
	/**
	 * This method is to verify that PS request submitted or Not
	 * @return boolean
	 */
	public boolean verify_PS_Request_Submit_successfully(){
		return isElementDisplayed("verify_CP_Request_Submitted_txt", "MarketPlacePage");
	}
	
	public void get_CP_Request_CaseID(){
		DataIO.overwritePropertiesFile("professionalRequestCaseID", getText("CP_Request_CaseID_txt", "MarketPlacePage"), "TestData");
	}
	
	public boolean Verify_Given_CP_CaseID_Listed_In_CaseList(String caseID){
		return isElementDisplayed("CP_CaseID_inList_txt", "MarketPlacePage", caseID);
	}
}
