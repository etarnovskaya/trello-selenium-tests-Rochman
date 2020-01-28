package com.elena.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class HelperBase {
  WebDriver wd;

  public HelperBase(WebDriver wd) {
    this.wd = wd;
  }

  public void pause(int millis) throws InterruptedException {
    Thread.sleep(millis);
  }
  public void click(By locator) {
    wd.findElement(locator).click();
  }

  public void type(By locator, String text) {
    if(text != null){
      click(locator);
      wd.findElement(locator).clear();
      wd.findElement(locator).sendKeys(text);
    }
  }

  public  boolean isElementPresent(By locator){
    return wd.findElements(locator).size()>0;
  }

  public void returnToHomePage() {
    click(By.name("house"));
    click(By.name("house"));
  }
  public void attach(By locator, File file) {
    if (file != null) {
      wd.findElement(locator).sendKeys(file.getAbsolutePath());
    }
      try {
      pause(10000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
