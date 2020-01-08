package com.elena.trello;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  if(app.isAvatarPresentOnHeader()){
    app.logout();
  }
}

  @Test
  public void testLogInWithAtlassianAcc() throws InterruptedException {
    app.clickLoginLink();
    app.fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    app.pause(20000);
    Assert.assertTrue
            (app.isAvatarPresentOnHeader());
  }
  @Test
  public void testLogInWithAtlassianAcc2() throws InterruptedException {
    app.clickLoginLink();
    app.fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    app.pause(20000);
    Assert.assertTrue
            (app.isAvatarPresentOnHeader());
  }

  @Test(enabled = false)
  public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
    app.clickLoginLink();
    app.fillLoginFormAtlassianAcc("roch", "");
    app.pause(8000);
    Assert.assertTrue(app.isErrorPresent());
    Assert.assertTrue
            (!app.isAvatarPresentOnHeader());
  }

  @Test(enabled = false)
  public void testLogInOldAcc() throws InterruptedException {
    app.clickLoginLink();
    app.fillLoginFormOldAcc("elena.telran@yahoo.com", "12345.com");
    app.confirmLogin();
    Assert.assertTrue
            (app.isAvatarPresentOnHeader());
  }


}
