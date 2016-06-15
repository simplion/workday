package com.workday.salesforce.utils;


/**
 * @author NeerajAgarwal
 *
 */
public interface UtilityMethods {
	
	void click(String elementName, String fileName);
	
	void click(String elementName, String fileName, String textToReplace);
	
	void writeTextInto(String elementName, String fileName, String textToReplace, String inputText);
	
	void writeTextInto(String elementName, String fileName, String inputText);
}
