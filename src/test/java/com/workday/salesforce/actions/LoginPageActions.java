package com.workday.salesforce.actions;
import org.openqa.selenium.WebDriver;

public class LoginPageActions extends BaseActions{

	public WebDriver driver;
	
	public LoginPageActions(WebDriver driver){
		super(driver);
		this.driver = driver;
	}
	
	
	public void PERFORM_LOGIN_IN_WORKDAY(String userName, String password){
		 //Enter User Name into textBox
		 writeTextInto("loginUserName_box", "LoginPage", userName);
		 
		 //Enter password into textBox
		 writeTextInto("loginPassword_box", "LoginPage", password);
		 
		 //Clicking on login Button
		 click("loginButton", "LoginPage");
	}

	public void verify_Home_Page_Displayed(String userName, String password){
		 //Enter User Name into textBox
		 writeTextInto("loginUserName_box", "LoginPage", userName);
		 
		 //Enter password into textBox
		 writeTextInto("loginPassword_box", "LoginPage", password);
		 
		 //Clicking on login Button
		 click("loginButton", "LoginPage");
	}
}
