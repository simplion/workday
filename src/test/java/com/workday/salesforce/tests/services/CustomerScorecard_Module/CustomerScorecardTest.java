package com.workday.salesforce.tests.services.CustomerScorecard_Module;
	
	import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

	import com.workday.salesforce.setup.TestSessionInitiator;
import com.workday.salesforce.utils.DataIO;

	public class CustomerScorecardTest {
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
		
		/**
        Verify that when user is able to create new deployment.
		 */
		/*@Test(priority=2)
		public void verify_CreateNewDeployement(){
			tsi.homepage.navigate_to_Accounts();
			tsi.homepage.navigateToDeploymenteditpage();
			tsi.customerscorecardpage.CreateNewDeployment();
	  	Assert.assertTrue((tsi.customerscorecardpage.verifyDeploymentHomePage()),"user is not redirecetd to deployment Home page");
			
		}
		/**
		 To verify the functionality of"Save and New"button. 
		 */
		/*@Test(priority=3)
		public void verify_DeployementSaveandNewbuttonfunctionality(){
			tsi.homepage.navigate_to_Accounts();
			tsi.homepage.navigateToDeploymenteditpage();
			tsi.customerscorecardpage.deploymentSaveandNew();
			Assert.assertTrue((tsi.customerscorecardpage.verifysaveandnew()),"deployment is not saved successfully");
		}
		/**
		 To verify the"Edit"button on the Deployment Contact page.
		 */
		/*@Test(priority=4)
		public void verify_EditbuttonOnDeploymentContactPage(){
			tsi.homepage.navigate_to_Accounts();
			tsi.customerscorecardpage.navigatetodeployments();
			Assert.assertTrue((tsi.customerscorecardpage.verifyeditbutton()),"Edit button is not available");
		}
		/**
		 To verify that only Workday contact Name should appear in the respective drop-down when contact is of"Workday"type.
		 */
		/*@Test(priority=5)
		public void verify_ContactEditOnDeployments(){
			tsi.homepage.navigate_to_Accounts();
			tsi.customerscorecardpage.navigatetodeployments();
			tsi.customerscorecardpage.verifyWorkdayContactName();
		}*/
		@AfterMethod
		public void tearDown(ITestResult result) {
			tsi.baseAction.captureScreenshot("Test");
		}

	}



