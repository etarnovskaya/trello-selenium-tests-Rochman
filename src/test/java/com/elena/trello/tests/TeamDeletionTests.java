package com.elena.trello.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TeamDeletionTests extends  TestBase {
  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getSession().isAvatarPresentOnHeader()){
      app.getSession().loginAtlassianAcc();
    }
  }
  @Test
  public void deleteTeamFromLeftNavMenu() throws InterruptedException {
    int before = app.getTeam().getTeamsCount();
    app.getTeam().clickOnFirstTeam();
    app.getTeam().openSettings();
    app.getTeam().deleteTeam();
    app.getTeam().returnToHomePage();
    app.getTeam().refreshPage();

    int after = app.getTeam().getTeamsCount();
//    Assert.assertEquals(after, before - 1);
    app.getTeam().cleanTeams();


  }
}
