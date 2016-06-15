package com.workday.salesforce.actions.services;
import org.openqa.selenium.WebDriver;
import com.workday.salesforce.actions.services.BaseActions;
public class SCCaseAdditionalReducedCostTenantPageAction extends BaseActions{
	
	WebDriver driver;
	
	public SCCaseAdditionalReducedCostTenantPageAction(WebDriver driver){
		super(driver);
		this.driver = driver;
	}

public void Click_On_Cases_Tab()
{
click("Cases_tab", "ServiceCareCasewithReducedCostTenantPage");
}
public void Click_On_New_button()
{
click("New_button", "ServiceCareCasewithReducedCostTenantPage");
}
public void Click_On_ServiceCare_link()
{
click("ServiceCare_link", "ServiceCareCasewithReducedCostTenantPage");
}
public void Click_On_Deployment_link()
{
click("Deployment_link", "ServiceCareCasewithReducedCostTenantPage");
}
public void Click_On_ContactName_lookup()
{
click("ContactName_lookup", "ServiceCareCasewithReducedCostTenantPage");
}
public void switchToContactlookupwindow()
{
	//switchToWindow("ContactName");
}
public void select_SubArea(){
	selectOptionByVisibleText("SubArea_dropdown", "ServiceCareCasewithReducedCostTenantPage","Tenant Concession");
}
public void select_TenantConcessionType(){
	selectOptionByVisibleText("TenantConcessionType_dropdown", "ServiceCareCasewithReducedCostTenantPage","Reduced Cost Tenant");
}
public void Click_On_Customer_lookup()
{
click("Customer_lookup", "ServiceCareCasewithReducedCostTenantPage");
}
public void switchToCustomerlookupwindow()
{
	//switchToWindow("CustomerName");
}
public void Entertestdata(String subject, String description,String TenantsRequired,String TenantsDuration,String ListPricePermonth,String PriceReqPerMonth){
	 //Enter User Name into textBox
	 writeTextInto("Subject_txtbox", "ServiceCareCasewithReducedCostTenantPage", subject);
	 
	 //Enter password into textBox
	 writeTextInto("Description_txtbox", "ServiceCareCasewithReducedCostTenantPage", description);
	 
	 writeTextInto("TenantsRequired_txtbox", "ServiceCareCasewithReducedCostTenantPage", TenantsRequired);
	 writeTextInto("TenantsDuration_txtbox", "ServiceCareCasewithReducedCostTenantPage", TenantsDuration);
	 writeTextInto("ListPricePermonth_txtbox", "ServiceCareCasewithReducedCostTenantPage", ListPricePermonth);
	 writeTextInto("PriceReqPerMonth_txtbox", "ServiceCareCasewithReducedCostTenantPage", PriceReqPerMonth);
	 click("Submit_button", "ServiceCareCasewithReducedCostTenantPage");
}

	// TODO Auto-generated method stub
	
}
