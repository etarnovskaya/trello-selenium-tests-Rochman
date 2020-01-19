package com.elena.trello.tests;

import com.elena.trello.model.TeamData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TeamCreationTests extends TestBase{
  @DataProvider
  public Iterator<Object[]> validTeams(){
    List<Object[]> list = new ArrayList<>();
    list.add(new Object[]{"name DP","decsription DP"});
    list.add(new Object[]{"DPn",""});
    return list.iterator();
  }

  @DataProvider
  public Iterator<Object[]> validTeamsCSV() throws IOException {
    List<Object[]> list = new ArrayList<>();
    BufferedReader  reader= new BufferedReader(
            new FileReader(new File("src/test/resources/teamsPositiveCSV.csv")));
    String line = reader.readLine();
    while (line!=null){
      String[] split = line.split(",");
      list.add(new Object[] {
              new TeamData()
              .withTeamName(split[0])
              .withTeamDescr(split[1])});

      line = reader.readLine();
    }
    return list.iterator();
  }

  @BeforeMethod
  public void preconditions() throws InterruptedException {
    if(!app.getSession().isAvatarPresentOnHeader()){
      app.getSession().loginAtlassianAcc();
    }
  }

  @Test(dataProvider = "validTeamsCSV")
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
    int teamCountAfter = app.getTeam().getTeamsCount();
    //Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }

  @Test(dataProvider = "validTeams")
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
    int teamCountAfter = app.getTeam().getTeamsCount();
    Assert.assertEquals(teamCountAfter, teamCountBefore+1);
  }

}
