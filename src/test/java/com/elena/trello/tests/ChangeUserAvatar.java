package com.elena.trello.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class ChangeUserAvatar extends TestBase {
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if (!app.getSession().isAvatarPresentOnHeader()) {
		
      app.getSession().loginAtlassianAcc();
    }
  }
  @Test
  public void testChangeAvatar() throws InterruptedException {
    logger.info("avatar before:");
    app.takeScreenshot();
    app.getSession().clickOnAvatar();
    app.getSession().openProfileAndVisibility();
    app.getSession().openAndSwitchToAtlassianProfile();
    app.getSession().addPictureAndCloseWindow();
    logger.info("avatar after:");
    app.takeScreenshot();

  }
}
