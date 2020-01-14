package com.elena.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
  BoardHelper boardHelper;
   WebDriver wd;

  public void init() {
    String browser =
            System.getProperty("browser", BrowserType.CHROME);
    if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    } else
      if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else
      if(browser.equals(BrowserType.EDGE)){
      wd = new EdgeDriver();
    }
    wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    wd.get("https://trello.com/");

    boardHelper = new BoardHelper(wd);
  }



  public void stop() {
    wd.quit();
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }
  public void click(By locator) {
    wd.findElement(locator).click();
  }
  public void type(By locator, String text) {
    click(locator);
    wd.findElement(locator).clear();
    wd.findElement(locator).sendKeys(text);
  }

  public  boolean isElementPresent(By locator){
    return wd.findElements(locator).size()>0;
  }

  public void fillLoginFormAtlassianAcc(String user, String pwd) throws InterruptedException {
    type(By.id("user"), user);
    pause(5000);
    click(By.id("login"));
    click(By.id("login-submit"));
    Thread.sleep(5000);
    type(By.cssSelector("input[id=password]"), pwd);
    click(By.id("login-submit"));
  }

  public void confirmLogin() {
        click(By.id("login"));
  }



  public void fillLoginFormOldAcc(String userName, String password) {
    type(By.id("user"), userName);
    type(By.id("password"), password);
  }



  public void clickLoginLink(){

    click(By.cssSelector("[href='/login']"));
  }

  public void loginWhithBothAccs() throws InterruptedException {

    type(By.id("user"), "rochman.elena@gmail.com");
    Thread.sleep(10000);
    if(wd.findElement(By.id("password")).isDisplayed()){
      type(By.id("password"), "12345.com");
    }
    click(By.id("login"));

    if (isElementPresent(By.id("login-submit"))){
      click(By.id("login-submit"));

      type(By.id("password"), "12345.com");
      click(By.id("login-submit"));
    }
  }

  public boolean isAvatarPresentOnHeader() {
    return isElementPresent
            (By.cssSelector("[data-test-id='header-member-menu-button']"));
  }

  public void logout() {
    clickOnAvatar();
    clickLogoutButton();
  }

  public void loginAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    pause(20000);

  }

  public void clickLogoutButton() {
    click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
  }

  public void clickOnAvatar() {
    click(By.cssSelector("[data-test-id='header-member-menu-button']"));
  }

  public boolean isErrorPresent() {
    return isElementPresent(By.id("error"));
  }

  public void returnToHomePage() {
    click(By.name("house"));
    click(By.name("house"));
  }

  public void clickLaterButton() {
    click(By.cssSelector("[data-test-id=show-later-button]"));
  }

  public int getTeamsCount() {
    return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
  }

  public void submitTeamCreation() {
    click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
  }

  public void closeInviteToTheTeamForm() {
    click(By.cssSelector("[name='close']"));
  }

  public void fillTeamCreationForm(String teamName, String teamDescr) {
    type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
    type(By.cssSelector("[id$= description]"), teamDescr);
  }

  public void selectCreateTeamFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-team-button']"));
  }

  public BoardHelper getBoardHelper() {
    return boardHelper;
  }
}
