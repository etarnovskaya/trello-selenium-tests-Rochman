package com.elena.trello;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests extends TestBase {
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if (!isAvatarPresentOnHeader()) {
      loginAtlassianAcc();
    }
    if (!isThereBoard()) {
      createBoard();
    }
  }

  @Test
  public void testFirstBoardDeletion1() throws InterruptedException {
    openFirstBoard();
    clickOpenMore();
    startCloseBoard();
    confirmCloseBoard();
    permanentlyDeleteBoard();
  }

  @Test
  public void testFirstBoardDeletion2() throws InterruptedException {
    openFirstBoard();
    pause(10000);
    clickOpenMore();
    startCloseBoard();
    confirmCloseBoard();
    returnToHomePage();
  }

}
