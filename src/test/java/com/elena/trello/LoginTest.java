package com.elena.trello;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
  WebDriver wd;

    @Test
  public void testLogIn() throws InterruptedException {
    clickLoginLink();
    loginWhithBothAccs();
      //

    }


}
