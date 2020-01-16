package com.elena.trello.manager;

import com.elena.trello.model.TeamData;
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

  public void fillTeamCreationForm(TeamData teamData) {
    type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamData.getTeamName());
    type(By.cssSelector("[id$= description]"), teamData.getTeamDescr());
  }

  public void selectCreateTeamFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-team-button']"));
  }

  public void clickLaterButton() {
    click(By.cssSelector("[data-test-id=show-later-button]"));
  }


}
