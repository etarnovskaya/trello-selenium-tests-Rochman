package com.elena.trello;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BoardDeletionTests  extends  TestBase{
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!isAvatarPresentOnHeader()){
      loginAtlassianAcc();
    }
    if(!isThereBoard()){
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

  public void permanentlyDeleteBoard() {
    click(By.cssSelector(".js-delete"));
    confirmCloseBoard();
  }

  public void confirmCloseBoard() {
    click(By.cssSelector(".js-confirm[type='submit']"));
  }

  private void startCloseBoard() throws InterruptedException {
    pause(5000);
    click(By.cssSelector(".js-close-board"));
  }

  public void clickOpenMore() {
    click(By.cssSelector(".js-open-more"));
  }

  public void openFirstBoard() {
    click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
      }
}
