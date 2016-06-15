package com.workday.salesforce.setup;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.gargoylesoftware.htmlunit.BrowserVersion;

/**
 * @author NeerajAgarwal
 *
 */
public class WebDriverFactory{
	
	protected static WebDriver driver = null;
	protected static DesiredCapabilities capability = new DesiredCapabilities();
	
	
	/**
	 * This method is to return driver instance for given browserName
	 * @param browserName
	 * @return
	 */
	public WebDriver getBrowser(String browserName){
		browserName = browserName.toUpperCase();
		switch (browserName) {
		case "FIREFOX" :
			driver = getFirefoxDriver();
			break;
		case "FF" :
			driver = getFirefoxDriver();
			break;
		case "CHROME"  :
			driver = getChromeDriver(System.getProperty("user.dir")+"\\resources\\drivers\\chromedriver.exe");
			break;
		case "INTERNETEXPLORER" :
			driver = getInternetExplorerDriver(System.getProperty("user.dir")+"\\resources\\drivers\\IEDriverServer.exe");
			break;
		case "IE" :
			driver = getInternetExplorerDriver(System.getProperty("user.dir")+"\\resources\\drivers\\IEDriverServer.exe");
			break;
		case "HEADLESS" :
			driver = getHtmlUnitDriver();
			break;
			
		default: 
			driver = getFirefoxDriver();
			break;
		}
		return driver;
	}

	
		    
	/**
	 * this Method is for return New IE driver instance
	 * @param driverPath
	 * @return IE driver instance
	 */
	private WebDriver getInternetExplorerDriver(String driverPath) {
		System.setProperty("webdriver.ie.driver", driverPath);
		capability.setJavascriptEnabled(true);
		return new InternetExplorerDriver(capability);
	}

	/**
	 * @param driverPath
	 * @return
	 */
	private WebDriver getChromeDriver(String driverPath) {
		System.setProperty("webdriver.chrome.driver", driverPath);
		capability.setJavascriptEnabled(true);
		return new ChromeDriver(capability);
	}

	/**
	 * @param driverPath
	 * @return
	 */
	private WebDriver getHtmlUnitDriver() {
		HtmlUnitDriver driver = new HtmlUnitDriver(BrowserVersion.CHROME);
		return driver;
	}
	
	/**
	 * @return
	 */
	private WebDriver getFirefoxDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(System.getProperty("user.dir")+"\\resources\\drivers\\firebug-2.0.16b1.xpi"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		profile.setPreference("browser.cache.disk.enable", false);
	    profile.setPreference("network.automatic-ntlm-auth.allow-non-fqdn", "true");
	    return new FirefoxDriver(profile);
	}

	
}
