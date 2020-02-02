package com.elena.trello.manager;

import com.elena.trello.model.TeamData;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class TeamHelper extends  HelperBase{
    public TeamHelper(WebDriver wd) {
    super(wd);
  }
  public int getTeamsCount() throws InterruptedException {
      pause(10000);
    return wd.findElements(By.cssSelector("[data-test-id^=home-team-tab-section]")).size();
  }

  public void submitTeamCreation() throws InterruptedException {
      //pause(10000);
    click(By.cssSelector("[data-test-id='header-create-team-submit-button']"));
  }

  public void closeInviteToTheTeamForm() {
    click(By.cssSelector("[name='close']"));
  }

  public void fillTeamCreationForm(TeamData teamData) {
    type(By.cssSelector("[data-test-id='header-create-team-name-input']"), teamData.getTeamName());
    click(By.cssSelector("[data-test-id='header-create-team-type-input']"));
    click(By.xpath("//*[contains(text(), 'Sales')]"));
//    List<WebElement> links = (List<WebElement>) ((JavascriptExecutor) wd)
//            .executeScript("return documentquerySelectorAll('#teamTypeSelect')");
 //   links.size();
//    Select dropDown = new Select(wd.findElement(By.cssSelector("#teamTypeSelect")));
  //  dropDown.selectByVisibleText("Sales");
   // type(By.cssSelector("#react-select-3-input"), teamData.getTeamType());
    type(By.cssSelector("[id$= description]"), teamData.getTeamDescr());
  }

  public void selectCreateTeamFromDropDown() {
    click(By.cssSelector("[data-test-id='header-create-team-button']"));
  }

  public void clickLaterButton() {
    click(By.cssSelector("[data-test-id=show-later-button]"));
  }


}
