package com.workday.salesforce.tests.services.WorkdayEngagementManager_Test_Module;

import junit.framework.Assert;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.workday.salesforce.setup.TestSessionInitiator;
import com.workday.salesforce.utils.DataIO;

public class ServiceCareReducedCostTenantTest {
	private TestSessionInitiator tsi;
 	
	@BeforeClass
	public void tearUp(){
		tsi = new TestSessionInitiator();
		tsi.baseAction.launchApplication(DataIO.get("salesForceURL", "TestData"));
	 }
	
	
	@AfterClass
	public void tearDown(){
		System.out.println("Test case has been executed successfully");
//		tsi.close();
	}
	
	@Test(priority=1)
	public void Perform_Login_And_Verify_HomePage(){
		tsi.loginPage.PERFORM_LOGIN_IN_WORKDAY(DataIO.get("userName", "TestData"), DataIO.get("password", "TestData"));
		Assert.assertTrue(tsi.homepage.verify_Home_Page_Loaded());
	}
	
	@Test(priority=2)
	public void Create_ServiceCareCaseCreation_Additional_Tenant_Request(){
		tsi.servicecarerct.Click_On_Cases_Tab();
		tsi.servicecarerct.Click_On_New_button();
		tsi.servicecarerct.Click_On_ServiceCare_link();
		tsi.servicecarerct.Click_On_Deployment_link();
		tsi.servicecarerct.Click_On_ContactName_lookup();
		tsi.servicecarerct.switchToContactlookupwindow();
		tsi.servicecarerct.select_SubArea();
		tsi.servicecarerct.select_TenantConcessionType();
		tsi.servicecarerct.Click_On_Customer_lookup();
		tsi.servicecarerct.switchToCustomerlookupwindow();
		tsi.servicecarerct.Entertestdata("testsubject", "testdescription","2","12","45","40");
	
	}

	@AfterMethod
	public void tearDown(ITestResult result) {
		tsi.baseAction.captureScreenshot("Test");
	}

}


