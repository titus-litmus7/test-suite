package com.litmus7.tatcha.jscripts.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.litmus7.tatcha.utils.BrowserDriver;

public class TsignUp_TC_01 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
//    driver = new FirefoxDriver();
//    driver = BrowserDriver.getFireFoxWebDriver();
    driver = BrowserDriver.getChromeWebDriver();
    baseUrl = "https://dev05-na01-tatcha.demandware.net/s/SiteGenesis/home?lang=en_US";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testTsignUpTC01() throws Exception {
    driver.get("https://dev05-na01-tatcha.demandware.net/s/SiteGenesis/home?lang=en_US");
    driver.findElement(By.cssSelector("i.fa.fa-user")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.findElement(By.id("dwfrm_profile_customer_firstname")).clear();
    driver.findElement(By.id("dwfrm_profile_customer_firstname")).sendKeys("test7");
    driver.findElement(By.id("dwfrm_profile_customer_lastname")).clear();
    driver.findElement(By.id("dwfrm_profile_customer_lastname")).sendKeys("test7");
    driver.findElement(By.id("dwfrm_profile_customer_email")).clear();
    driver.findElement(By.id("dwfrm_profile_customer_email")).sendKeys("test7@gmail.com");
    driver.findElement(By.id("dwfrm_profile_customer_emailconfirm")).clear();
    driver.findElement(By.id("dwfrm_profile_customer_emailconfirm")).sendKeys("test7@gmail.com");
    driver.findElement(By.xpath("//div[3]/div/input")).clear();
    driver.findElement(By.xpath("//div[3]/div/input")).sendKeys("Test_001");
    driver.findElement(By.xpath("//div[4]/div/input")).clear();
    driver.findElement(By.xpath("//div[4]/div/input")).sendKeys("Test_001");
    driver.findElement(By.name("dwfrm_profile_confirm")).click();
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
