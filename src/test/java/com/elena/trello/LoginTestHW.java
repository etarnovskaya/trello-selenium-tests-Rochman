package com.elena.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  if(isAvatarPresentOnHeader()){
    logout();
  }
}

  @Test
  public void testLogInWithAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    pause(20000);
    Assert.assertTrue
            (isAvatarPresentOnHeader());
  }
  @Test
  public void testLogInWithAtlassianAcc2() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    pause(20000);
    Assert.assertTrue
            (isAvatarPresentOnHeader());
  }

  @Test(enabled = false)
  public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc("roch", "");
    pause(8000);
    Assert.assertTrue(isErrorPresent());
    Assert.assertTrue
            (!isAvatarPresentOnHeader());
  }

  @Test(enabled = false)
  public void testLogInOldAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormOldAcc("elena.telran@yahoo.com", "12345.com");
    confirmLogin();
    Assert.assertTrue
            (isAvatarPresentOnHeader());
  }


}
