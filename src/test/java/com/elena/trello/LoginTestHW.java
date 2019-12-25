package com.elena.trello;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTestHW extends TestBase {

  @Test
  public void testLogInWithAtlassianAcc() throws InterruptedException {
    clickLoginLink();
    fillLoginFormAtlassianAcc();
    pause(8000);
    Assert.assertTrue
            (isAvatarPresentOnHeader());
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
