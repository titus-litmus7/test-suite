package com.litmus7.tatcha.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

import com.xceptance.xlt.api.engine.scripting.AbstractScriptTestCase;
import com.xceptance.xlt.api.engine.scripting.ScriptName;

/*
 * FF and GC browser drivers with System settings
 * Invoked while automating test scripts w/o XLT
 */
public class BrowserDriver extends AbstractScriptTestCase {

	 private static WebDriver driver = null;
	 private static DesiredCapabilities capabilities = null;
	 private String webDriver = null;
	 private String pathToBrowser = null;
	 private String pathToDriverServer = null;
	

	public static WebDriver getFireFoxWebDriver(){
        capabilities = DesiredCapabilities.firefox();
        
        System.setProperty("webdriver.firefox.bin", "D:/programs/FF_47/firefox.exe");
        System.setProperty("webdriver.firefox.driver", "D:/project/SeleniumTestScripts/geckodriver-v0.18.0-win64/geckodriver.exe");
        driver = new FirefoxDriver(capabilities);
        return driver;
 	}
 

	public static WebDriver getChromeWebDriver(){
        capabilities = DesiredCapabilities.chrome();
        
//      capabilities.setCapability("webdriver.chrome.bin", path);
//	   	 pathToBrowser = getProperty("xlt.webDriver.chrome.pathToBrowser");
//	     pathToDriverServer = getProperty("xlt.webDriver.chrome.pathToDriverServer");  
//        System.setProperty("webdriver.chrome.bin", "xlt.webDriver.chrome.pathToBrowser");
//        System.setProperty("webdriver.chrome.driver", "xlt.webDriver.chrome.pathToDriverServer");
      
      System.setProperty("webdriver.chrome.bin", "C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
      System.setProperty("webdriver.chrome.driver", "D:/project/SeleniumTestScripts/chromedriver_win32/chromedriver.exe");
        
        driver = new ChromeDriver(capabilities);
        return driver;
 	}
 	
	public WebDriver getSafariWebDriver(){
// 		System.setProperty("webdriver.safari.bin", "D:/programs/Safari/Safari.exe");
// 		capabilities = DesiredCapabilities.safari();
// 		capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);
// 		driver = new SafariDriver(capabilities);
 		System.setProperty("webdriver.safari.noinstall", "true"); 
 		driver = new SafariDriver();	
 		return driver;
 	}
 	
	public WebDriver getSafariWebDriver2(){
	 	SafariOptions options = new SafariOptions();
	 	options.setUseCleanSession(true);
	 	driver = new SafariDriver(options);
//	 	capabilities = DesiredCapabilities.safari();
//	 	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
//	 	capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "dismiss");
//	 	capabilities.setCapability(SafariOptions.CAPABILITY, options);
//	 	driver = new SafariDriver(capabilities);
	 	driver.manage().deleteAllCookies();
	 	return driver;
 	}


	/** Checking Security Token for all fields */
	 public static String getSecurityToken(String contentName){
		 String UNDERSCORE = "_";
		 String secToken=null;
		 if(null!=contentName && contentName.contains(UNDERSCORE) && contentName.startsWith("DWFRM".toLowerCase()) ){
			 String[] contentCSRFname = contentName.split(UNDERSCORE);
			 secToken = contentCSRFname[contentCSRFname.length-1];
		 }
		 return secToken;
	 }
 
}

/*
xlt.webDriver.chrome.pathToBrowser = C:/Program Files (x86)/Google/Chrome/Application/chrome.exe
xlt.webDriver.chrome.pathToDriverServer = D:/project/SeleniumTestScripts/chromedriver_win32/chromedriver.exe


# Firefox
xlt.webDriver.firefox.pathToBrowser = D:/programs/FF_47/firefox.exe
xlt.webDriver.firefox.pathToDriverServer = D:/project/SeleniumTestScripts/geckodriver-v0.18.0-win64/geckodriver.exe

*/


