package com.elena.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SessionHelper extends HelperBase{
  HeaderHelper header = new HeaderHelper(wd);
  public SessionHelper(WebDriver wd) {
    super(wd);
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
    click(By.cssSelector("[hre='/login']"));
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
    header.clickOnAvatar();
    clickLogoutButton();
  }

  public void loginAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    pause(10000);

  }

  public boolean isErrorPresent() {
    return isElementPresent(By.id("error"));
  }

  public void clickLogoutButton() {
    click(By.cssSelector("[data-test-id='header-member-menu-logout']"));
  }
}
