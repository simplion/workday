package com.workday.salesforce.actions.services;

import org.openqa.selenium.WebDriver;

import com.workday.salesforce.utils.BasePage;

/**
 * @author NeerajAgarwal
 *
 */

public class BaseActions extends BasePage{

	protected WebDriver driver;
	
	public BaseActions(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void logTestMethod(){
		logMessage("hello this is log test");
	}
	
}
