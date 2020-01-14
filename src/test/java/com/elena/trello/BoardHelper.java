package com.elena.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static jdk.nashorn.internal.objects.NativeJava.type;

public class BoardHelper  extends  HelperBase{
  public BoardHelper(WebDriver wd) {
      super(wd);
  }

  public int getBoardsCount() {
    return wd.findElements(By.cssSelector("ul.boards-page-board-section-list li")).size()-1;
  }

  public void confirmBoardCreation() {
    click(By.cssSelector("[data-test-id='create-board-submit-button']"));

  }

  public void fillBoardForm(String boardName) {
    type(By.cssSelector("[data-test-id='create-board-title-input']"), boardName);
  }

  public void selectCreateBoardFromDropDown() {
    click(By.xpath("//span[@name='board']/..//p"));

  }

  public void createBoard() throws InterruptedException {
    clickOnPlusButton();
    selectCreateBoardFromDropDown();
    fillBoardForm("qa22"+ System.currentTimeMillis());
    confirmBoardCreation();
    pause(15000);
    returnToHomePage();
  }

  public void clickOnPlusButton() {
    click(By.cssSelector("[data-test-id='header-create-menu-button']"));
  }

  public boolean isThereBoard() {
    return getBoardsCount() >1;
  }

  public void permanentlyDeleteBoard() {
    click(By.cssSelector(".js-delete"));
    confirmCloseBoard();
  }

  public void confirmCloseBoard() {
    click(By.cssSelector(".js-confirm[type='submit']"));
  }

  public void startCloseBoard() throws InterruptedException {
    pause(5000);
    click(By.cssSelector(".js-close-board"));
  }

  public void clickOpenMore() {
    click(By.cssSelector(".js-open-more"));
  }

  public void openFirstBoard() {
    click(By.xpath("//*[@class='icon-lg icon-member']/../../..//li"));
      }

  public void deleteBoard() throws InterruptedException {
    openFirstBoard();
    pause(10000);
    clickOpenMore();
    startCloseBoard();
    confirmCloseBoard();
    returnToHomePage();
  }
}
