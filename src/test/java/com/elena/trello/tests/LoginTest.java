package com.elena.trello.tests;

import org.testng.annotations.Test;

public class LoginTest extends TestBase {


    @Test
  public void testLogIn() throws InterruptedException {
    app.getSession().clickLoginLink();
    app.getSession().loginWhithBothAccs();
      //

    }


}
