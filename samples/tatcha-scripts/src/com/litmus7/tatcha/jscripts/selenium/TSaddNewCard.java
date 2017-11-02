package com.litmus7.tatcha.jscripts.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.litmus7.tatcha.utils.BrowserDriver;

public class TSaddNewCard {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
    driver = BrowserDriver.getFireFoxWebDriver();
//    driver = BrowserDriver.getChromeWebDriver();
    
    baseUrl = "https://dev05-na01-tatcha.demandware.net/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testAddNewCard() throws Exception {
    driver.get(baseUrl + "/s/SiteGenesis/home?lang=en_US");
    driver.findElement(By.cssSelector("i.fa.fa-user")).click();
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.xpath("//div/input")).clear();
    driver.findElement(By.xpath("//div/input")).sendKeys("titus@tatcha.com");
    driver.findElement(By.xpath("//div[2]/div/input")).clear();
    driver.findElement(By.xpath("//div[2]/div/input")).sendKeys("Titus_007");
    driver.findElement(By.name("dwfrm_login_login")).click();
    driver.findElement(By.cssSelector("i.fa.fa-money")).click();
    driver.findElement(By.linkText("Add Credit Card")).click();
    
    System.out.println(" Add CC Page ");
//    driver.findElement(By.xpath("//button[@type='button']")).click();
    
    WebDriverWait wait = new WebDriverWait(driver,60000);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("braintreeCardOwner")));
    
//    Thread.sleep(5000);
    		
//    driver.findElement(By.id("braintreeCardOwner")).clear();
//    driver.findElement(By.id("braintreeCardOwner")).sendKeys("Neetu Thomas");
    // ERROR: Caught exception [ERROR: Unsupported command [selectFrame | braintree-hosted-field-number | ]]
    
//    wait.until(ExpectedConditions.presenceOfElementLocated(By.id("credit-card-number")));
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"credit-card-number\"]")));
   
//    Thread.sleep(60000);
    try{
    	//*[@id="credit-card-number"]
//    	driver.findElement(By.xpath("//*[@id=\"credit-card-number\"]")).clear();
//    	driver.findElement(By.xpath("//*[@id=\"credit-card-number\"]")).sendKeys("4111111111111111");
    	
    driver.findElement(By.id("credit-card-number")).clear();
    driver.findElement(By.id("credit-card-number")).sendKeys("4111111111111111");
    
    }catch (Exception e) {
    	 e.printStackTrace();
     }
		// TODO: handle exception
	
//   driver.findElement(By.xpath("//*[@id=\"credit-card-number\"]")).sendKeys("4111111111111111");
//    driver.findElement(By.xpath("//*[@id="credit-card-number"]")).sendKeys("4111 1111 1111 1111");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=braintree-hosted-field-cvv | ]]
    
    driver.findElement(By.id("cvv")).clear();
    driver.findElement(By.id("cvv")).sendKeys("123");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | name=braintree-hosted-field-expirationDate | ]]
    driver.findElement(By.id("expiration")).clear();
    driver.findElement(By.id("expiration")).sendKeys("12 / 19");
    // ERROR: Caught exception [ERROR: Unsupported command [selectWindow | null | ]]
    driver.findElement(By.cssSelector("div.form-row.form-row-button > button[type=\"submit\"]")).click();
    driver.findElement(By.cssSelector("i.fa.fa-user")).click();
    driver.findElement(By.linkText("Logout")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
