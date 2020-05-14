package com.elena.trello.manager;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
public class ApplicationManager  {
  Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
  BoardHelper board;
  TeamHelper team;
  SessionHelper session;
  HeaderHelper header;
   WebDriver wd;
  Properties properties;




  public void init() throws IOException, InterruptedException {
    String browser =
            System.getProperty("browser", BrowserType.CHROME);
    if(browser.equals(BrowserType.CHROME)){
      wd = new ChromeDriver();
    } else
      if(browser.equals(BrowserType.FIREFOX)){
      wd = new FirefoxDriver();
    } else
      if(browser.equals(BrowserType.EDGE)){
      wd = new EdgeDriver();
    }
    properties = new Properties();
    String target = System.getProperty("target","local");
    properties.load(new FileReader(new File(String.format("src/test/resources/%s.properties", target))));
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    openSite();


    board = new BoardHelper(wd);
    team = new TeamHelper(wd);
    session = new SessionHelper(wd);
    header = new HeaderHelper(wd);
    session.loginAtlassianAcc(properties.getProperty("web.user"), properties.getProperty("web.pwd"));
  }

  public void openSite() {
    wd.get(properties.getProperty("web.baseURL"));
  }

  public void stop() {
    wd.quit();
//    wd.getWindowHandles();
//    wd.getWindowHandle();

  }


  public BoardHelper getBoard() {
    return board;
  }


  public SessionHelper getSession() {
    return session;
  }

  public HeaderHelper getHeader() {
    return header;
  }

  public TeamHelper getTeam() {
    return team;
  }

  public void takeScreenshot(){
    File tmp = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
    File screenshot =  new File("src/test/logs/screenshots/screen-"+System.currentTimeMillis()+".png");

    try {
      Files.copy(tmp, screenshot);
    } catch (IOException e) {
      e.printStackTrace();
    }
    logger.info("\nCreated screenshot: "+ screenshot.getAbsolutePath());
  }

}
