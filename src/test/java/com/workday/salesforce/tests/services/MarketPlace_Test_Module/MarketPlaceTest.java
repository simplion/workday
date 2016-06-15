package com.workday.salesforce.tests.services.MarketPlace_Test_Module;

import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.Assert;
import com.workday.salesforce.setup.TestSessionInitiator;
import com.workday.salesforce.utils.DataIO;

public class MarketPlaceTest {
	
	private TestSessionInitiator tsi;
	 	
	@BeforeClass
	public void tearUp(){
		tsi = new TestSessionInitiator();
		tsi.baseAction.launchApplication(DataIO.get("CustomerPortalUrl", "TestData"));
	 }
		
	@AfterClass
	public void tearDown(){
		System.out.println("Test case has been executed successfully");
		tsi.close();
	}
	
	@Test(priority=1)
	public void Perform_Login_And_Verify_HomePage(){
		tsi.loginPage.PERFORM_LOGIN_IN_CustomerPortal(DataIO.get("CustomerPortalUserName", "TestData"), DataIO.get("CustomerPortalpwd", "TestData"));
		Assert.assertTrue(tsi.homepage.verify_CP_Home_Page_Loaded());
	}
	
	@Test(priority=2)
	public void Create_Case_Proffesional_Service_Request(){
		tsi.marketPlace.Click_OnCases_Tab();
		tsi.marketPlace.Click_On_CreateNewCases();
		tsi.marketPlace.Click_On_ProffesionalServicesRequest();
		tsi.marketPlace.select_Area();
		tsi.marketPlace.select_Product();
		tsi.marketPlace.Click_On_SubProduct();
		tsi.marketPlace.EnterSubjectandDescription("testsubject", "testdescription");
		Assert.assertTrue(tsi.marketPlace.verify_PS_Request_Submit_successfully(), "CP Request Not Submitted");
		tsi.marketPlace.get_CP_Request_CaseID();
	}

	@Test(priority=3)
	public void Verify_CP_Request_Listed_In_CaseList(){
		tsi.marketPlace.Click_OnCases_Tab();
		Assert.assertTrue(tsi.marketPlace.Verify_Given_CP_CaseID_Listed_In_CaseList(DataIO.get("professionalRequestCaseID", "TestData")), "CP Case ID not fount in list");
	}
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		tsi.baseAction.captureScreenshot("Test");
	}
	
}