package com.litmus7.tatcha.jscripts.xlt;

import org.junit.After;
import org.junit.Test;
import com.xceptance.xlt.api.webdriver.XltDriver;
import com.litmus7.tatcha.utils.BrowserDriver;
import com.xceptance.xlt.api.engine.scripting.AbstractWebDriverScriptTestCase;

/**
 * TODO: Add class description
 */
public class TaddNewCC_MyAccScripts extends AbstractWebDriverScriptTestCase
{

    /**
     * Constructor.
     */
    public TaddNewCC_MyAccScripts()
    {
//        super(new XltDriver(true), "https://dev05-na01-tatcha.demandware.net");
    	  super(BrowserDriver.getChromeWebDriver(), "https://dev05-na01-tatcha.demandware.net");
    }


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
        open("/on/demandware.store/Sites-SiteGenesis-Site/en_US");
        //
        // ~~~ TaddNewCC-0 ~~~
        //
        startAction("TaddNewCC_0");
        click("//*[@id='navigation']//i[contains(@class,'fa') and contains(@class,'fa-user')][1]");
        clickAndWait("link=Login");
        //
        // ~~~ TaddNewCC-1 ~~~
        //
        startAction("TaddNewCC_1");
        try{
//        	click("id=dwfrm_login_username_d0bpngmepheo");
        	click("xpath=//input[starts-with(@id, 'dwfrm_login_username_')]");
        }
        catch(Exception e){
        	e.printStackTrace();
        	System.out.println(BrowserDriver.getSecurityToken(e.toString()));
        }
//        type("id=dwfrm_login_username_d0bpngmepheo", "titus@tatcha.com");
        type("xpath=//input[starts-with(@id, 'dwfrm_login_username_')]","titus@tatcha.com");
//        type("id=dwfrm_login_password_d0lpevfsjdjc", "Titus_007");
        type("xpath=//input[starts-with(@id, 'dwfrm_login_password_')]","Titus_007");
        clickAndWait("document.forms[1].dwfrm_login_login");
        //
        // ~~~ TaddNewCC-2 ~~~
        //
        startAction("TaddNewCC_2");
        clickAndWait("//*[@id='primary']//i[contains(@class,'fa') and contains(@class,'fa-money')][1]");
        //
        // ~~~ TaddNewCC-3 ~~~
        //
        
//        wait = new WebDriverWait(driver,50);
//        wait.until(ExpectedConditions.presenceOfElementLocated(cartItem));
        
        startAction("TaddNewCC_3");
        click("link=Add Credit Card");
        type("id=braintreeCardOwner", "Titus QA Automated");
        selectFrame("id=braintree-hosted-field-number");
        type("id=credit-card-number", "6304 0000 0000 0000");
        click("id=cvv");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-cvv");
        type("id=cvv", "123");
        click("id=expiration");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-expirationDate");
        type("id=expiration", "04 / 19");
        selectFrame("relative=top");
        clickAndWait("document.forms[15].elements[11]");
        //
        // ~~~ TaddNewCC-4 ~~~
        //
        startAction("TaddNewCC_4");
        click("id=braintreeCardOwner");
        type("id=braintreeCardOwner", "Sample Card1");
        selectFrame("id=braintree-hosted-field-number");
        type("id=credit-card-number", "6304 0000 0000 0000");
        click("id=cvv");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-cvv");
        type("id=cvv", "123");
        click("id=expiration");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-expirationDate");
        type("id=expiration", "07 / 20");
        selectFrame("relative=top");
        clickAndWait("document.forms[15].elements[11]");
        //
        // ~~~ TaddNewCC-5 ~~~
        //
        startAction("TaddNewCC_5");
        type("id=braintreeCardOwner", "Sample Card1");
        selectFrame("id=braintree-hosted-field-number");
        type("id=credit-card-number", "6304 0000 0000 0000");
        click("id=braintreeCardOwner");
        selectFrame("relative=top");
        type("id=braintreeCardOwner", "Sample Card1");
        selectFrame("id=braintree-hosted-field-number");
        type("id=credit-card-number", "6304 0000 0000 0000");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-cvv");
        type("id=cvv", "123");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-expirationDate");
        type("id=expiration", "07 / 22");
        selectFrame("relative=top");
        clickAndWait("document.forms[1].elements[11]");
        //
        // ~~~ TaddNewCC-6 ~~~
        //
        startAction("TaddNewCC_6");
        click("//*[@id='navigation']//i[contains(@class,'fa') and contains(@class,'fa-user')][1]");
        clickAndWait("link=LOGOUT");

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