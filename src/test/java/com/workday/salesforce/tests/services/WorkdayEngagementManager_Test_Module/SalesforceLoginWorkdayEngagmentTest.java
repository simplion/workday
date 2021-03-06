package com.workday.salesforce.tests.services.WorkdayEngagementManager_Test_Module;
	import junit.framework.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.Test;
	import com.workday.salesforce.setup.TestSessionInitiator;
	import com.workday.salesforce.utils.DataIO;

	public class SalesforceLoginWorkdayEngagmentTest {

		private TestSessionInitiator tsi;
		 	
		@BeforeClass
		public void tearUp(){
			tsi = new TestSessionInitiator();
			tsi.baseAction.launchApplication(DataIO.get("salesForceURL", "TestData"));
		 }
		
		
		@AfterClass
		public void tearDown(){
			System.out.println("Test case has been executed successfully");
//			tsi.close();
		}
		
		@Test(priority=1)
		public void Perform_Login_And_Verify_HomePage(){
			tsi.loginPage.PERFORM_LOGIN_IN_WORKDAY(DataIO.get("userName", "TestData"), DataIO.get("password", "TestData"));
			Assert.assertTrue(tsi.homepage.verify_Home_Page_Loaded());
		}
}
