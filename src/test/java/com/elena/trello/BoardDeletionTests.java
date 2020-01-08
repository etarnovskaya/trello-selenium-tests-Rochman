package com.elena.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if (!app.isAvatarPresentOnHeader()) {
      app.loginAtlassianAcc();
    }
    if (!app.isThereBoard()) {
      app.createBoard();
    }
  }

  @Test
  public void testFirstBoardDeletion1() throws InterruptedException {
    app.openFirstBoard();
    app.clickOpenMore();
    app.startCloseBoard();
    app.confirmCloseBoard();
    app.permanentlyDeleteBoard();
  }

  @Test
  public void testFirstBoardDeletion2() throws InterruptedException {
    app.openFirstBoard();
    app.pause(10000);
    app.clickOpenMore();
    app.startCloseBoard();
    app.confirmCloseBoard();
    app.returnToHomePage();
  }

}
