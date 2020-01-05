package com.elena.trello;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends  TestBase{
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!isAvatarPresentOnHeader()){
      loginAtlassianAcc();
    }
  }
  @Test
  public void testBoardCreationFromHeader() throws InterruptedException {
int before =   getBoardsCount();
    clickOnPlusButton();
selectCreateBoardFromDropDown();
fillBoardForm("qa22"+ System.currentTimeMillis());
confirmBoardCreation();
pause(15000);
returnToHomePage();
int after = getBoardsCount();

    Assert.assertEquals(after, before+1);
  }

  @AfterClass
  public void postActions() throws InterruptedException {
    int boardsCount = getBoardsCount();
    while (boardsCount>4){
      deleteBoard();
      boardsCount = getBoardsCount();
    }
  }

}
