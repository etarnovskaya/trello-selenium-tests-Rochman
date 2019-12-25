package com.elena.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {

  @Test
  public void testLogInWithAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    pause(8000);
    Assert.assertTrue
            (isAvatarPresentOnHeader());
  }

  @Test
  public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("roch", "");
    pause(8000);
    Assert.assertTrue(isErrorPresent());
    Assert.assertTrue
            (!isAvatarPresentOnHeader());
  }

  public boolean isErrorPresent() {
    return isElementPresent(By.id("error"));
  }

  @Test
  public void testLogInOldAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormOldAcc("elena.telran@yahoo.com", "12345.com");
    confirmLogin();
    Assert.assertTrue
            (isAvatarPresentOnHeader());
  }


}
