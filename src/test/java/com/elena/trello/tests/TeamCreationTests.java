package com.elena.trello.tests;

import com.elena.trello.model.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamCreationTests extends TestBase{


  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getSession().isAvatarPresentOnHeader()){
      app.getSession().loginAtlassianAcc();
    }
  }

  @Test(dataProvider = "validTeamsCSV", dataProviderClass = DataProviders.class)
  public void teamCreationTestFromHeaderCSV(TeamData team) throws InterruptedException {
    int teamCountBefore = app.getTeam().getTeamsCount();

    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(team);

    app.getTeam().submitTeamCreation();
//    if(isElementPresent(By.cssSelector("[name='close']"))){
//      closeInviteToTheTeamForm();
//    }
    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();

    int teamCountAfter = app.getTeam().getTeamsCount();
    Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }

  @Test(dataProvider = "validTeams", dataProviderClass = DataProviders.class)
  public void teamCreationTestFromHeaderWithDP
          (String teamName, String teamDescr) throws InterruptedException {
    int teamCountBefore = app.getTeam().getTeamsCount();

    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(new TeamData()
            .withTeamName(teamName)
            .withTeamDescr(teamDescr));

    app.getTeam().submitTeamCreation();
//    if(isElementPresent(By.cssSelector("[name='close']"))){
//      closeInviteToTheTeamForm();
//    }
    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();

    int teamCountAfter = app.getTeam().getTeamsCount();
    Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }

  @Test
  public void teamCreationTestFromHeader() throws InterruptedException {
int teamCountBefore = app.getTeam().getTeamsCount();

    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(new TeamData()
            .withTeamName("teamName")
             .withTeamDescr("teamDescr"));

    app.getTeam().submitTeamCreation();
//    if(isElementPresent(By.cssSelector("[name='close']"))){
//      closeInviteToTheTeamForm();
//    }
    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();
int teamCountAfter = app.getTeam().getTeamsCount();
  Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }
  @Test
  public void teamCreationTestFromHeaderWithNameOnly() throws InterruptedException {
    int teamCountBefore = app.getTeam().getTeamsCount();
//    String teamId =
//            wd.findElement(By.cssSelector("[data-test-id^=home-team-tab-section]")).getAttribute("data-test-id");
    // System.out.println(teamId);
    app.getBoard().clickOnPlusButton();
    app.getTeam().selectCreateTeamFromDropDown();
    app.getTeam().fillTeamCreationForm(new TeamData()
            .withTeamName("teamName"));

    app.getTeam().submitTeamCreation();
//    if(isElementPresent(By.cssSelector("[name='close']"))){
//      closeInviteToTheTeamForm();
//    }
    app.getTeam().clickLaterButton();
    app.getHeader().returnToHomePage();
app.getTeam().pause(10000);


    int teamCountAfter = app.getTeam().getTeamsCount();
    Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }

}
