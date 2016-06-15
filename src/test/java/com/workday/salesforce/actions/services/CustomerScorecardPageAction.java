package com.workday.salesforce.actions.services;

import org.openqa.selenium.WebDriver;

import com.workday.salesforce.actions.services.BaseActions;

/**
 * @author Jrani
 * 
 */
public class CustomerScorecardPageAction extends BaseActions {
	WebDriver driver;

	public CustomerScorecardPageAction(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * this method is to create new deployment.
	 */
	public void CreateNewDeployment() {
		selectOptionByVisibleText("ContractType_dropdown",
				"CustomerScorecardPage", "Fixed Bid");
		hardWait(2);
		selectOptionByVisibleText("ServicesType_dropdown",
				"CustomerScorecardPage", "Post Go-Live");
		hardWait(2);
		selectOptionByVisibleText("ServicesApproach_dropdown",
				"CustomerScorecardPage", "Spec Based");
		hardWait(4);
		selectOptionByVisibleText("Deploymentstage_dropdown",
				"CustomerScorecardPage", "Plan");
		hardWait(2);
		selectOptionByVisibleText("PrimingPartner_dropdown",
				"CustomerScorecardPage", "Hima Test Partner Account");
		hardWait(2);
		selectOptionByVisibleText("DeploymentPartner_dropdown",
				"CustomerScorecardPage", "PartnerAccount001");
		hardWait(2);
		click("Save_buttondeployment", "CustomerScorecardPage");
	}

	/**
	 * This is to verify that user has created a new deployment and user is on
	 * deployment home page.
	 */
	public boolean verifyDeploymentHomePage() {
		return isElementDisplayed("Deploymenthome_page",
				"CustomerScorecardPage");
	}

	/**
	 * This method is to verify deployment save and new button functionality.
	 */
	public void deploymentSaveandNew() {
		click("ContactEdit_link", "CustomerScorecardPage");
		click("Addrowcontact_edit", "CustomerScorecardPage");
		selectOptionByVisibleText("ContactType_dropdown",
				"CustomerScorecardPage", "Workday");
		String winHandleParent = driver.getWindowHandle();
		click("Contactname_lookup", "CustomerScorecardPage");
		hardWait(1);
		switchwindow(winHandleParent);
		hardWait(2);
		switchToFramebyIndex(1);
		click("SelectedContact_name", "CustomerScorecardPage");
		hardWait(2);
		driver.switchTo().window(winHandleParent);
		hardWait(2);
		selectOptionByVisibleText("ContactRole_dropdown", "CustomerScorecardPage", "Integration Engineer");
		hardWait(2);
		click("SaveandNewButton", "CustomerScorecardPage");
	}

	/**
	 * This method is to verify that user has successfully saved the deployment.
	 */
	public boolean verifysaveandnew() {
		return isElementDisplayed("Verify_saved_message",
				"CustomerScorecardPage");
	}

	/**
	 * This method is to navigate to the deployments page.
	 */
	public void navigatetodeployments() {
		click("CustomerScorecard_button", "CustomerScorecardPage");
		click("Deployments_link", "CustomerScorecardPage");
	}
	/**
	 * This method is to verify that Edit button is available on the Deployment Contact page
	 */
	public boolean verifyeditbutton() {
		return isElementDisplayed("Edit_button",
				"CustomerScorecardPage");
	}
	
	/**
	 This method is to verify the workday contact name.
	 */
	public void verifyWorkdayContactName()
	{
		click("ContactEdit_link", "CustomerScorecardPage");
		click("Addrowcontact_edit", "CustomerScorecardPage");
		selectOptionByVisibleText("ContactType_dropdown",
				"CustomerScorecardPage", "Workday");
	}
	
}



