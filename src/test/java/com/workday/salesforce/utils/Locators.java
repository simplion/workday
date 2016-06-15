package com.workday.salesforce.utils;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author nagarwal
 *
 */
public class Locators extends LogsProgrammatic{
	
	public WebDriver driver;
	public static SeleniumWait wait;
	private ArrayList<String> locatorValues = null;
	
	public Locators(WebDriver driver){
		this.driver = driver;
		wait = new SeleniumWait(driver, 60);
	}
	
	/**
     * Find element BY using object type and value
     * @param objectName
     * @param objectType
     * @return
     * @throws Exception
     */
	private By getObject(String objectName, String fileName, String replacement) throws Exception{
        //Find by xpath
    	
    	locatorValues = DataIO.getValueFromExcelFile(objectName, fileName);
    	if(locatorValues.get(1).trim().equalsIgnoreCase("XPATH")){
            return By.xpath(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
        }
        //find by class
        else if(locatorValues.get(1).trim().equalsIgnoreCase("CLASSNAME")){
            return By.className(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
             
        }
    	 //find by ID
        else if(locatorValues.get(1).trim().equalsIgnoreCase("ID")){
        	return By.id(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
             
        }
        //find by name
        else if(locatorValues.get(1).trim().equalsIgnoreCase("NAME")){
            return By.name(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
             
        }
        //Find by css
        else if(locatorValues.get(1).trim().equalsIgnoreCase("CSS")){
            return By.cssSelector(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
             
        }
        //find by link
        else if(locatorValues.get(1).trim().equalsIgnoreCase("LINK")){
            return By.linkText(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
             
        }
        //find by partial link
        else if(locatorValues.get(1).trim().equalsIgnoreCase("PARTIALLINK")){
            return By.partialLinkText(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
             
        }else if(locatorValues.get(1).trim().equalsIgnoreCase("LINKTEXT")){
            return By.linkText(locatorValues.get(2).trim().replaceAll("%txt%", replacement));
            
        }else
        	
        	
        {
            throw new Exception("Wrong object type");
        }
    }
    
    /**
     * To get the webElement from excel file
     * @param elementName - name of locator/element
     * @param fileName - file name in which locator saved
     * @return - Web element
     * @throws Exception
     */
    public WebElement getElement(String elementName, String fileName){
    	WebElement ele = null;
    	try
    	{
    		ele = wait.waitForElementToBeAppear(driver.findElement(getObject(elementName, fileName, ""))); 	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return ele;
    }
    
    /**
     * To get the dynamic webElement from excel file
     * @param elementName - name of locator/element
     * @param fileName - file name in which locator saved
     * @param replacement - this is for dynamic xpath
     * @return - web element
     * @throws Exception
     */
    public WebElement getElement(String elementName, String fileName, String replacement){
    	WebElement element = null;
    	try
    	{
    		element = wait.waitForElementToBeAppear(driver.findElement(getObject(elementName, fileName, replacement))); 	
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    	return element;
    }
}