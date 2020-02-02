package com.elena.trello.tests;

import com.elena.trello.model.BoardData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardCreationTests extends TestBase {

  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if (!app.getSession().isAvatarPresentOnHeader()) {
      app.getSession().loginAtlassianAcc();
    }
  }

//  @Test(enabled = false, dataProvider = "validBoards", dataProviderClass = DataProviders.class)
//  public void testBoardCreationFromHeaderFromCSV(BoardData board) throws InterruptedException {
//    int before = app.getBoard().getBoardsCount();
//    app.getBoard().clickOnPlusButton();
//    app.getBoard().selectCreateBoardFromDropDown();
//    app.getBoard().fillBoardForm(board);
//    app.getBoard().confirmBoardCreation();
//    app.getBoard().pause(15000);
//    app.getHeader().returnToHomePage();
//    int after = app.getBoard().getBoardsCount();
//    Assert.assertEquals(after, before+1);
//  }

  @Test
  public void testBoardCreationFromHeader() throws InterruptedException {
    int before = app.getBoard().getBoardsCount();
    app.getBoard().clickOnPlusButton();
    app.getBoard().selectCreateBoardFromDropDown();
    app.getBoard().fillBoardForm(new BoardData().setBoardName("qa22" + System.currentTimeMillis()));
    app.getBoard().confirmBoardCreation();
    app.getBoard().pause(15000);
    app.getHeader().returnToHomePage();
    int after = app.getBoard().getBoardsCount();

    Assert.assertEquals(after, before + 1);
  }

//  @AfterClass
//  public void postActions() throws InterruptedException {
//    int boardsCount = app.getBoard().getBoardsCount();
//    while (boardsCount > 4) {
//      app.getBoard().deleteBoard();
//      boardsCount = app.getBoard().getBoardsCount();
//    }
//  }

}
