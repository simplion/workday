package com.workday.salesforce.actions.services;
import org.openqa.selenium.WebDriver;
import com.workday.salesforce.actions.services.BaseActions;
public class SCCaseAdditionalTenantRequestPageAction extends BaseActions{
	WebDriver driver;
	
	public SCCaseAdditionalTenantRequestPageAction(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

public void Click_On_Cases_Tab()
{
click("Cases_tab", "ServiceCareCasewithAdditionalTenantPage");
}
public void Click_On_New_button()
{
click("New_button", "ServiceCareCasewithAdditionalTenantPage");
}
public void Click_On_ServiceCare_link()
{
click("ServiceCare_link", "ServiceCareCasewithAdditionalTenantPage");
}
public void Click_On_Deployment_link()
{
click("Deployment_link", "ServiceCareCasewithAdditionalTenantPage");
}
public void Click_On_ContactName_lookup()
{
click("ContactName_lookup", "ServiceCareCasewithAdditionalTenantPage");
}
public void switchToContactlookupwindow()
{
	switchToWindow("ContactName");
}
public void select_SubArea(){
	selectOptionByVisibleText("SubArea_dropdown", "ServiceCareCasewithAdditionalTenantPage","Tenant Concession");
}
public void select_TenantConcessionType(){
	selectOptionByVisibleText("TenantConcessionType_dropdown", "ServiceCareCasewithAdditionalTenantPage","Additional Tenant Request");
}
public void Click_On_Customer_lookup()
{
click("Customer_lookup", "ServiceCareCasewithAdditionalTenantPage");
}
public void switchToCustomerlookupwindow()
{
	switchToWindow("CustomerName");
}
public void Entertestdata(String subject, String description,String TenantsRequired,String TenantsDuration,String ListPricePermonth,String PriceReqPerMonth){
	 //Enter User Name into textBox
	 writeTextInto("Subject_txtbox", "ServiceCareCasewithAdditionalTenantPage", subject);
	 
	 //Enter password into textBox
	 writeTextInto("Description_txtbox", "ServiceCareCasewithAdditionalTenantPage", description);
	 
	 writeTextInto("TenantsRequired_txtbox", "ServiceCareCasewithAdditionalTenantPage", TenantsRequired);
	 writeTextInto("TenantsDuration_txtbox", "ServiceCareCasewithAdditionalTenantPage", TenantsDuration);
	 writeTextInto("ListPricePermonth_txtbox", "ServiceCareCasewithAdditionalTenantPage", ListPricePermonth);
	 writeTextInto("PriceReqPerMonth_txtbox", "ServiceCareCasewithAdditionalTenantPage", PriceReqPerMonth);
	 click("Submit_button", "ServiceCareCasewithAdditionalTenantPage");
}



	// TODO Auto-generated method stub
	
}
