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
int teamCountBefore = getTeamsCount();
    String teamId =
            wd.findElement(By.cssSelector("[data-test-id^=home-team-tab-section]")).getAttribute("data-test-id");
    System.out.println(teamId);
    clickOnPlusButton();
    selectCreateTeamFromDropDown();
    fillTeamCreationForm("teamName", "teamDescr");
    submitTeamCreation();
//    if(isElementPresent(By.cssSelector("[name='close']"))){
//      closeInviteToTheTeamForm();
//    }
    clickLaterButton();
int teamCountAfter = getTeamsCount();
  Assert.assertEquals(teamCountAfter, teamCountBefore+1);
    String overflowValue = wd.findElement(By.cssSelector("")).getCssValue("overflow");
  }

  private void clickLaterButton() {
    click(By.cssSelector("[data-test-id=show-later-button]"));
  }

  public int getTeamsCount() {
    return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
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
