package com.workday.salesforce.actions.services;
import org.openqa.selenium.WebDriver;
import com.workday.salesforce.actions.services.BaseActions;
public class SCCaseDetailPageAction extends BaseActions{

	WebDriver driver;
	
	public SCCaseDetailPageAction(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	public void Click_On_Cases_Tab()
	{
	click("Cases_tab", "SCCaseDetailPage");
	}
	public void Click_On_New_button()
	{
	click("New_button", "SCCaseDetailPage");
	}
	public void Click_On_ServiceCare_link()
	{
	click("ServiceCare_link", "SCCaseDetailPage");
	}
	public void Click_On_Deployment_link()
	{
	click("Deployment_link", "SCCaseDetailPage");
	}
	public void Click_On_ContactName_lookup()
	{
	click("ContactName_lookup", "SCCaseDetailPage");
	}
	public void switchToContactlookupwindow()
	{
		switchToWindow("ContactName");
	}
	public void select_SubArea(){
		selectOptionByVisibleText("SubArea_dropdown", "SCCaseDetailPage","Delivery Assurance");
	}
	public void Click_On_Customer_lookup()
	{
	click("Customer_lookup", "ServiceCareCasewithAdditionalTenantPageSCCaseDetailPage");
	}
	public void switchToCustomerlookupwindow()
	{
		switchToWindow("CustomerName");
	}
	public void Entersubjectdesc(String subject, String description){
		 //Enter User Name into textBox
		 writeTextInto("Subject_txtbox", "SCCaseDetailPage", subject);
		 
		 //Enter password into textBox
		 writeTextInto("Description_txtbox", "SCCaseDetailPage", description);
		 click("Submit_button", "SCCaseDetailPage");
	}
	public void Click_Close()
	{
		click("CloseCase_button", "SCCaseDetailPage");
	}
	public void select_status(){
		selectOptionByVisibleText("CloseCasestatus_dropdown", "SCCaseDetailPage","Closed");
	}
	public void Click_Save()
	{
		click("Save_button", "SCCaseDetailPage");
	}
	
		
	}
	
