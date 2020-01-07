package com.elena.trello;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!isAvatarPresentOnHeader()){
      loginAtlassianAcc();
    }
  }

  @Test
  public void teamCreationTestFromHeader(){

    clickOnPlusButton();
    selectCreateTeamFromDropDown();
    fillTeamCreationForm("teamName", "teamDescr");
    submitTeamCreation();
    if(isElementPresent(By.cssSelector("[name='close']"))){
      closeInviteToTheTeamForm();
    }

    Assert.assertTrue(isElementPresent(By.cssSelector("[data-test-id=home-team-tab-name]")));
  }

  public void submitTeamCreation() {
    click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
  }

  public void closeInviteToTheTeamForm() {
    click(By.cssSelector("[name='close']"));
  }

  public void fillTeamCreationForm(String teamName, String teamDescr) {
    type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamName);
    type(By.cssSelector("[id$= description]"), teamDescr);
  }

  public void selectCreateTeamFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-team-button']"));
  }
}
