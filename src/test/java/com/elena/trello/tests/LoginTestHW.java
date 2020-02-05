package com.elena.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {
@BeforeMethod
public void ensurePreconditions(){
  if(app.getSession().isAvatarPresentOnHeader()){
    app.getSession().logout();

  }
}

  @Test
  public void testLogInWithAtlassianAcc() throws InterruptedException {
    app.getSession().clickLoginLink();
    app.getSession().fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    app.getSession().pause(20000);
    Assert.assertTrue
            (app.getSession().isAvatarPresentOnHeader());
  }
  @Test
  public void testLogInWithAtlassianAcc2() throws InterruptedException {
 // app.takeScreenshot();
    app.getSession().clickLoginLink();
    app.getSession().fillLoginFormAtlassianAcc("rochman.elena@gmail.com", "12345.com");
    app.getSession().pause(20000);
    Assert.assertTrue
            (app.getSession().isAvatarPresentOnHeader());
  }

  @Test(enabled = false)
  public void negativeTestLogInWithAtlassianAcc() throws InterruptedException {
    app.getSession().clickLoginLink();
    app.getSession().fillLoginFormAtlassianAcc("roch", "");
    app.getSession().pause(8000);
    Assert.assertTrue(app.getSession().isErrorPresent());
    Assert.assertTrue
            (!app.getSession().isAvatarPresentOnHeader());
  }

  @Test(enabled = false)
  public void testLogInOldAcc() throws InterruptedException {
    app.getSession().clickLoginLink();
    app.getSession().fillLoginFormOldAcc("elena.telran@yahoo.com", "12345.com");
    app.getSession().confirmLogin();
    Assert.assertTrue
            (app.getSession().isAvatarPresentOnHeader());
  }


}
