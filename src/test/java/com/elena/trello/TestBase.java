package com.elena.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

public class TestBase {
  WebDriver wd;

  @BeforeClass
  public void setUp(){
    wd = new ChromeDriver();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    wd.get("https://trello.com/");
      }

  public  boolean isElementPresent(By locator){
    return wd.findElements(locator).size()>0;
  }

  @AfterClass
  public void tearDown(){
    wd.quit();
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }

  public void fillLoginFormAtlassianAcc() throws InterruptedException {
    type(By.id("user"), "rochman.elena@gmail.com");
    pause(5000);
    click(By.id("login"));
    click(By.id("login-submit"));
    type(By.id("password"), "12345.com");
    click(By.id("login-submit"));
  }

  public void confirmLogin() {
    click(By.id("login"));
  }

  public void click(By locator) {
    wd.findElement(locator).click();
  }

  protected void fillLoginFormOldAcc(String userName, String password) {
    type(By.id("user"), userName);
    type(By.id("password"), password);
  }

  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public void clickLoginLink(){
    click(By.cssSelector("[href='/login']"));
  }

  public void loginWhithBothAccs() throws InterruptedException {

//    type(By.id("user"), "rochman.elena@gmail.com");
//    Thread.sleep(10000);
//    if(wd.findElement(By.id("password")).isDisplayed()){
//      type(By.id("password"), "12345.com");
//    }
//    click(By.id("login"));
//
//    if (isElementPresent(By.id("login-submit"))){
//      click(By.id("login-submit"));
//
//      type(By.id("password"), "12345.com");
//      click(By.id("login-submit"));
//    }
  }

  public boolean isAvatarPresentOnHeader() {
    return isElementPresent
            (By.cssSelector("[data-test-id='header-member-menu-button']"));
  }
}
