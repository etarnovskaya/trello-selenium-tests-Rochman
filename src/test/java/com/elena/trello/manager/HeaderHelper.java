package com.elena.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HeaderHelper  extends  HelperBase{
  public HeaderHelper(WebDriver wd) {
    super(wd);
  }

  public void clickOnAvatar() {
    click(By.cssSelector("[data-test-id='header-member-menu-button']"));
  }

  public void returnToHomePage() {
    try {
      pause(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    click(By.cssSelector("[aria-label='Back to Home']"));
    click(By.name("house"));
    try {
      pause(5000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
