package com.litmus7.tatcha.utils;

import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * 
 * Env is set up for Saucelabs
 * @author titus-kurian
 *
 */
public class BrowserCapabilities {

	public DesiredCapabilities ff52_Win10(){
	    DesiredCapabilities caps = DesiredCapabilities.firefox();
	    caps.setCapability("browserName", "firefox");
	    caps.setCapability("platform", "Windows 10");
	    caps.setCapability("version", "52.0");
	    caps.setCapability("name", "firefox-windows");
	    return caps;
	}

	public DesiredCapabilities ie11_Win8_1(){
		DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
	    caps.setCapability("platform", "Windows 8.1");
	    caps.setCapability("version", "11.0");
	    caps.setCapability("name", "ie-windows");
	    return caps;
	}
	
	public DesiredCapabilities gc47_lnx(){
		DesiredCapabilities caps = DesiredCapabilities.chrome();
	    caps.setCapability("platform", "Linux");
	    caps.setCapability("version", "47.0");
	    caps.setCapability("name", "googleChrome-linux");
	    return caps;
	}
    

//PC/Linux/firefox 			FAILURE	
  /*
  DesiredCapabilities caps = DesiredCapabilities.firefox();
  caps.setCapability("browserName", "firefox");
  caps.setCapability("platform", "Linux");
  caps.setCapability("version", "52.0");
  caps.setCapability("name", "firefox-linux");
   */      
    
//    PC/Linux/Chrome 	PASSED
    
/*       
*/
    
    
//    Google Nexus 7 HD Emulator
//	"tags": ["tag1","tag2","tag3"]
//			"": "true"
//				"build": "build-1234"
    
    
	public DesiredCapabilities sfr7_macOSX10_9(){
		DesiredCapabilities caps = DesiredCapabilities.safari();
	    caps.setCapability("platform", "OS X 10.9");
	    caps.setCapability("version", "7.0");
	    caps.setCapability("name", "safari-mac");
	    return caps;
	}
//    Mac/OSX/Safari	PASSED
    
/*        */
    
    
//    Android Emulator Phone/Android 5.1		ERROR
/*        
    DesiredCapabilities caps = DesiredCapabilities.android();
    caps.setCapability("platform", "Linux");
    caps.setCapability("version", "5.1");
    caps.setCapability("deviceName","Android Emulator");
    caps.setCapability("deviceType","phone");
    caps.setCapability("deviceOrientation", "portrait");
    caps.setCapability("name", "android-emulator");
*/       
//    Samsung Galaxy S3 Emulator/Android 4.4	Real Device			PASSED
/*        
    DesiredCapabilities caps = DesiredCapabilities.android();
    caps.setCapability("platform", "Linux");
    caps.setCapability("version", "4.4");
    caps.setCapability("deviceName","Samsung Galaxy S3 Emulator");
    caps.setCapability("deviceOrientation", "portrait");
    caps.setCapability("name", "galaxy-S3"); 
*/
//    Appium Mobile and Desktop Browser Test Configuration Examples
    
//  iPhone 6 	8.4 platform		ERROR - Appium version is invalid	Not in saucelabs
/*
	DesiredCapabilities caps = DesiredCapabilities.iphone();
	caps.setCapability("appiumVersion", "1.5.1");
	caps.setCapability("deviceName","iPhone 6");
	caps.setCapability("deviceOrientation", "portrait");
	caps.setCapability("platformVersion","8.4");
	caps.setCapability("platformName", "iOS");
	caps.setCapability("browserName", "Safari");
	caps.setCapability("name", "iphone-6");
*/		
//  iPhone 7	11.0 platform				ERROR  Time elapsed
/*		
	DesiredCapabilities caps = DesiredCapabilities.iphone();
    caps.setCapability("appiumVersion", "1.7.1");
    caps.setCapability("deviceName","iPhone 7 Simulator");
    caps.setCapability("deviceOrientation", "portrait");
    caps.setCapability("platformVersion","11.0");
    caps.setCapability("platformName", "iOS");
    caps.setCapability("browserName", "Safari");
    caps.setCapability("name", "iphone-7");
*/
//	iPad				Error- Appium 1.7.1 does not support iOS 8.4. 			
    				//	Please check our platform configurator (https://saucelabs.com/docs/platforms)
/*		
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.7.1");
		caps.setCapability("deviceName","iPad Retina");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion","8.4");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "Safari");
		caps.setCapability("name", "ipad-Retina");
*/			
		//iPhone 6 Real Device 8.0 platform			Error-Unsupported OS/browser/version/device combo	Not in Saucelabs
		
		/*{
		deviceName:'iPhone 6 Device',
		platformName:'iOS',
		platformVersion:'8.0',
		browserName:'Safari',
		"appium-version":"1.5.1"
		}
		*/
/*		
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("deviceName","iPhone 6 Device");
		caps.setCapability("platformName","8.0");
		caps.setCapability("browserName","Safari");
		caps.setCapability("appiumVersion","1.5.1");
		caps.setCapability("name", "iphone 6- appium platform 8");
	*/	
		
		//Samsung Galaxy S4 Real Device		Error - Your account does not have access to Android devices.
    								//  	Please contact sales@saucelabs.com to add this feature to your account.		
    								//		Not in Saucelabs
		
		/*{
		deviceName:'Samsung Galaxy S4 Device',
		platformName:'Android',
		platformVersion:'',
		browserName:'Chrome',
		name:'S5 real device google.com'
		}
		*/
 /*   
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("deviceName","Samsung Galaxy S4 Device");
		caps.setCapability("platformName","Android");
		caps.setCapability("platformVersion","4.4");
		caps.setCapability("browserName","Chrome");
		caps.setCapability("name","galaxy-S4-real");
		*/
		
		
		//Samsung Galaxy S5 Real Device				Error - Your account does not have access to Android devices.
													//  	Please contact sales@saucelabs.com to add this feature to your account.		
													//		Not in Saucelabs
		
		/*{
		deviceName:'Samsung Galaxy S5 Device',
		platformName:'Android',
		platformVersion:'4.4',
		browserName:'Chrome',
		name:'S5 real device google.com'
		}*/
	/*	
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("deviceName","Samsung Galaxy S5 Device");
		caps.setCapability("platformName","Android");
		caps.setCapability("platformVersion","4.4");
		caps.setCapability("browserName","Chrome");
		caps.setCapability("name","galaxy-s5-real");
	*/	
		
    
//    Examples of Native and Hybrid Mobile Application Test Configuration
    
//    iPhone  Simulator Native Application			PASSED in Safari, not in app	
/*			        
		DesiredCapabilities caps = DesiredCapabilities.iphone();
		caps.setCapability("appiumVersion", "1.6.3");
		caps.setCapability("deviceName","iPhone 5");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("platformVersion","8.4");
		caps.setCapability("platformName", "iOS");
		caps.setCapability("browserName", "Safari");
//		caps.setCapability("app","sauce-storage:mapp.zip");
		caps.setCapability("name","iphone-simulator-native");
*/
    
//    iPad Simulator Native Application				PASSED in Safari, not in app	
/*        
    DesiredCapabilities caps = DesiredCapabilities.iphone();
    caps.setCapability("appiumVersion", "1.6.3");
    caps.setCapability("deviceName","iPad Retina");
    caps.setCapability("deviceOrientation", "portrait");
    caps.setCapability("platformVersion","9.2");
    caps.setCapability("platformName", "iOS");
    caps.setCapability("browserName", "Safari");
//    caps.setCapability("app","sauce-storage:myapp.zip");
    caps.setCapability("name","ipad-simulator-native");
*/        
    
//   iPhone Simulator Hybrid Application	Error	Invalid device name specified: iPhone Retina (4-inch 64-bit)
    										// 	Not in saucelabs
/*    
    DesiredCapabilities caps = DesiredCapabilities.iphone();
    caps.setCapability("appiumVersion", "1.6.3");
    caps.setCapability("deviceName","iPhone Retina (4-inch 64-bit)");
    caps.setCapability("deviceOrientation", "portrait");
    caps.setCapability("platformVersion","8.4");
    caps.setCapability("platformName", "iOS");
    caps.setCapability("browserName", "Safari");
//    caps.setCapability("app","sauce-storage:myapp.zip");
    caps.setCapability("name","iphone-simulator-Hybrid-native");
*/    
    
//    Android Native Application, Android v. 4.3	Error - No app defined; 
    												// 	we do not have enough information to run your test
/*
		DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.5.3");
		caps.setCapability("deviceName","Samsung Galaxy S4 Emulator");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "firefox");
		caps.setCapability("platformVersion","4.3");
		caps.setCapability("platformName","Android");
//		caps.setCapability("app","sauce-storage:myapp.zip");
		caps.setCapability("name","galaxy-s4-emulator-native");
*/
    
//		Android Hybrid Application, Android v. 4.1		Error - very slow
		
/*			DesiredCapabilities caps = DesiredCapabilities.android();
		caps.setCapability("appiumVersion", "1.5.3");
		caps.setCapability("deviceName","Android Emulator");
		caps.setCapability("deviceType","tablet");
		caps.setCapability("deviceOrientation", "portrait");
		caps.setCapability("browserName", "Chrome");
		caps.setCapability("platformVersion","4.1");
//		caps.setCapability("platformName","Android");
//		caps.setCapability("app","sauce-storage:myapp.zip");
		caps.setCapability("automationName","Selendroid");
		caps.setCapability("name","tablet-emulator-hybrid");*/
		
		
		//caps.setCapability("xxx","xxx");


//    caps.setCapability("passed","true");
//    caps.setCapability("fail","false");
//    caps.setCapability("failed","true");
//    caps.setCapability("build","build-1234");
//    caps.setCapability("tags","['device','mobile','portrait']");
}
