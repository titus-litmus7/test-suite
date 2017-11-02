package com.litmus7.tatcha.jscripts.xlt;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.Description;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.xceptance.xlt.api.webdriver.XltDriver;
import com.litmus7.tatcha.utils.BrowserCapabilities;
import com.litmus7.tatcha.utils.BrowserDriver;
import com.saucelabs.common.Utils;
import com.saucelabs.junit.SauceOnDemandTestWatcher;
import com.saucelabs.saucerest.SauceREST;
import com.xceptance.xlt.api.engine.scripting.AbstractScriptTestCase;
import com.xceptance.xlt.api.engine.scripting.AbstractWebDriverScriptTestCase;
import com.xceptance.xlt.api.engine.scripting.ScriptName;


/** 
 * 
 *  Class to check with Saucelabs integration
 *  
 */


public class TcheckDev01 extends AbstractWebDriverScriptTestCase
{

//	private BrowserDriver browserDriver = new BrowserDriver();
	private static String baseURL = "http://demo-na01-tatcha.demandware.net";
	
    /**
     * Constructor.
     * @throws MalformedURLException 
     */
//    public TcheckTestCase() throws MalformedURLException
	public TcheckDev01()
    {
    	/* XLT Driver for Load Test */
//        super(new XltDriver(true), baseURL);
		
		/* Web drivers */
        super(BrowserDriver.getChromeWebDriver(), baseURL);
//        super(BrowserDriver.getFireFoxWebDriver(), baseURL);
    }

    /** Customly Added to switch web drivers */
//    public TcheckTestCase(WebDriver webDriver, String baseURL)
//    {
//        super(webDriver, baseURL);
//    }

    /**
     * Executes the test.
     *
     * @throws Throwable if anything went wrong
     */
    
    @Test
    public void test() throws Throwable
    {
        //
        // ~~~ OpenStartPage ~~~
        //
        startAction("OpenStartPage");
//        open("/s/SiteGenesis/electronics/televisions/?lang=en_US");
        open("/s/SiteGenesis?lang=en_US");
        //
        // ~~~ TcheckEachMenuItem-0 ~~~
        //
        startAction("TcheckEachMenuItem_0");
        clickAndWait("//nav[@id='navigation']/ul[1]/li[4]/div/ul/li[1]/a");
        //
        // ~~~ TcheckEachMenuItem-1 ~~~
        //
        startAction("TcheckEachMenuItem_1");
        clickAndWait("//nav[@id='navigation']/ul[1]/li[4]/div/ul/li[2]/a");
        //
        // ~~~ TcheckEachMenuItem-2 ~~~
        //
        startAction("TcheckEachMenuItem_2");
        clickAndWait("//nav[@id='navigation']/ul[1]/li[4]/div/ul/li[3]/a");
        //
        // ~~~ TcheckEachMenuItem-3 ~~~
        //
        startAction("TcheckEachMenuItem_3");
        clickAndWait("//nav[@id='navigation']/ul[1]/li[4]/div/ul/li[4]/a");
        //
        // ~~~ TcheckEachMenuItem-4 ~~~
        //
        startAction("TcheckEachMenuItem_4");
        clickAndWait("//nav[@id='navigation']/ul[1]/li[4]/div/ul/li[5]/a");

    }
    
/*    	SauceOnDemandTestWatcher resultReportingTestWatcher = new SauceOnDemandTestWatcher(this, authentication){
    		    @Override
    		    protected void failed(Throwable e, Description description) {
    		    watchedLog+= description.getMethodName();
    		}

    		@Override
    		protected void succeeded(Description description) {
    		}
    		};

    		public static boolean areTestsSuccessful(){
    		    boolean pass = true;
    		    if(watchedLog != null && !watchedLog.equals("")){
    		        pass=false;
    		    }
    		    return pass;
    		}

    		public static void updateTestStatus(){
    		    SauceREST client = new SauceREST(USERNAME, ACCESS_KEY);
    		    Map<String, Object> updates = new HashMap<>();
    		    updates.put("passed", areTestsSuccessful());
    		    Utils.addBuildNumberToUpdate(updates);
//    		    client.updateJobInfo(BaseJunitTest.sessionId, updates);
    		}*/
    		
    		
    		/**
    	     * Method that gets invoked after test.
    	     * Dumps browser log and
    	     * Closes the browser
    	     */
    	 
/*    	    @AfterMethod
    	    public void tearDown(ITestResult result) throws Exception {
    	 
    	        //Gets browser logs if available.
    	        ((JavascriptExecutor) webDriver.get()).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
    	        webDriver.get().quit();
    	    }*/

    private static WebDriver createWebDriver() throws MalformedURLException{
    	 
    	  BrowserDriver browserDriver = new BrowserDriver();
	      return browserDriver.getFireFoxWebDriver();
//	      return browserDriver.getChromeWebDriver();
    }
    
    private static WebDriver createSauceLabsDriver() throws MalformedURLException
    {
       	String USERNAME = "titus-java";
       	String ACCESS_KEY = "640173b1-530d-466a-91f3-9beb97dddb8d";
       	DesiredCapabilities caps = null ;
       	
//    	USERNAME = "titus-kurian";
//    	String ACCESS_KEY = "4113c395-520d-460a-b8d1-a7556e26096e";
        
//        String USERNAME = "Neetu10";
//        String ACCESS_KEY = "7ad5694a-f04f-4bea-9616-4980791c1e74";
        
        String URL_LINK = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
        
        BrowserCapabilities browserCapabilities = new BrowserCapabilities();
        caps = browserCapabilities.ff52_Win10();
        return new RemoteWebDriver(new URL(URL_LINK), caps);

    }
    
    /**
     * Clean up.
     */
    @After
    public void quitDriver()
    {
        // Shutdown WebDriver.
        getWebDriver().quit();
    }

}