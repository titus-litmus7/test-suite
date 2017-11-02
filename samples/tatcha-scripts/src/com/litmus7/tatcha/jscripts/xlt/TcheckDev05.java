package com.litmus7.tatcha.jscripts.xlt;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
//import com.xceptance.xlt.api.webdriver.XltDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.litmus7.tatcha.utils.BrowserDriver;
import com.xceptance.xlt.api.engine.scripting.AbstractWebDriverScriptTestCase;

/**
 * TODO: Add class description
 */
public class TcheckDev05 extends AbstractWebDriverScriptTestCase
{

    /**
     * Constructor.
     */
    public TcheckDev05()
    {
    	 super(BrowserDriver.getChromeWebDriver(),"https://dev05-na01-tatcha.demandware.net");
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
        open("/s/SiteGenesis/home?lang=en_US");
        //
        // ~~~ AddToCart-0 ~~~
        //
        startAction("AddToCart_0");
        click("//*[@id='navigation']//i[contains(@class,'fa') and contains(@class,'fa-user')][1]");
        clickAndWait("//*[@id='navigation']//a[contains(@class,'null')][1]");
        //
        // ~~~ AddToCart-1 ~~~
        //
  /*
        startAction("AddToCart_1");
        clickAndWait("//*[@id='primary']//i[contains(@class,'fa') and contains(@class,'fa-money')][1]");
        //
        // ~~~ AddToCart-2 ~~~
        //
    
        startAction("AddToCart_2");
        click("link=Add Credit Card");
        type("//div[@id='braintreeCreditCardFieldsContainer']/div[1]/div/div[1]/input", "Neetu Thomas");
        selectFrame("id=braintree-hosted-field-number");
        type("id=credit-card-number", "4111 1111 1111 1111");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-cvv");
        type("id=cvv", "123");
        selectFrame("relative=top");
        selectFrame("id=braintree-hosted-field-expirationDate");
        type("id=expiration", "12 / 19");
        selectFrame("relative=top");
        click("//*[@id='addCreditCardForm']/fieldset/div[4]/button[1]");
*/
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