package com.elena.trello.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TeamHelper extends  HelperBase{
    public TeamHelper(WebDriver wd) {
    super(wd);
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

  public void clickLaterButton() {
    click(By.cssSelector("[data-test-id=show-later-button]"));
  }


}
