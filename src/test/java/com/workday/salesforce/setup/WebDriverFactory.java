package com.workday.salesforce.setup;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.workday.salesforce.utils.DataIO;

/**
 * @author NeerajAgarwal
 *
 */

public class WebDriverFactory {

	protected static WebDriver driver = null;
	protected static DesiredCapabilities capability = new DesiredCapabilities();

	/**
	 * This method is to return driver instance for given browserName
	 * 
	 * @param browserName
	 * @return
	 */
	private WebDriver setLocalBrowser() {
		String browserName = DataIO.get("localBrowserName", "Config")
				.toUpperCase();

		switch (browserName) {
		case "FIREFOX":
			driver = getFirefoxDriver();
			break;
		case "FF":
			driver = getFirefoxDriver();
			break;
		case "CHROME":
			driver = getChromeDriver(System.getProperty("user.dir")
					+ "\\resources\\drivers\\chromedriver.exe");
			break;
		case "INTERNETEXPLORER":
			driver = getInternetExplorerDriver(System.getProperty("user.dir")
					+ "\\resources\\drivers\\IEDriverServer.exe");
			break;
		case "IE":
			driver = getInternetExplorerDriver(System.getProperty("user.dir")
					+ "\\resources\\drivers\\IEDriverServer.exe");
			break;
		case "HEADLESS":
			driver = getHtmlUnitDriver();
			break;

		default:
			driver = getFirefoxDriver();
			break;
		}

		return driver;
	}

	public WebDriver getBrowser() {
		if (DataIO.get("serverType", "Config").equalsIgnoreCase("local")) {
			driver = setLocalBrowser();
		} else if (DataIO.get("serverType", "Config")
				.equalsIgnoreCase("remote")) {
			driver = setRemoteDriver();
		}
		return driver;
	}


	
	/**
	 * @return
	 */
	private WebDriver getFirefoxDriver() {
		FirefoxProfile profile = new FirefoxProfile();
		try {
			profile.addExtension(new File(System.getProperty("user.dir")
					+ "\\resources\\drivers\\firebug-2.0.16b1.xpi"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		profile.setPreference("browser.cache.disk.enable", false);
		profile.setPreference("network.automatic-ntlm-auth.allow-non-fqdn",
				"true");
		return new FirefoxDriver(profile);
	}

	private WebDriver setRemoteDriver() {
		DesiredCapabilities cap = null;
		String browser = DataIO.get("remoteBrowserName", "Config");
		if (browser.equalsIgnoreCase("firefox")) {
			cap = DesiredCapabilities.firefox();
			cap.setCapability("platform",
					DataIO.get("platform", "Config"));
			cap.setCapability("version",
					DataIO.get("version", "Config"));
		} else if (browser.equalsIgnoreCase("chrome")) {
			cap = DesiredCapabilities.chrome();
			cap.setCapability("platform",
					DataIO.get("platform", "Config"));
			cap.setCapability("version",
					DataIO.get("version", "Config"));
		} else if (browser.equalsIgnoreCase("Safari")) {
			cap = DesiredCapabilities.safari();
		} else if ((browser.equalsIgnoreCase("ie"))
				|| (browser.equalsIgnoreCase("internetexplorer"))
				|| (browser.equalsIgnoreCase("internet explorer"))) {
			cap = DesiredCapabilities.internetExplorer();
			cap.setCapability("platform",
					DataIO.get("platform", "Config"));
			cap.setCapability("version",
					DataIO.get("version", "Config"));
		}
		String seleniuhubaddress = DataIO.get("remoteURL", "Config");
		URL selserverhost = null;
		try {
			selserverhost = new URL(seleniuhubaddress);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		// cap.setJavascriptEnabled(true);
		return new RemoteWebDriver(selserverhost, cap);
	}

	/**
	 * this Method is for return New IE driver instance
	 * 
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
}
