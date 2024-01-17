package com.guru99.tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {
  @Parameters({"loginName", "loginPassword"})
  @Test (testName = "Verify user login with correct credentials")
  public void verifyUserLoginWithCorrectCredentials(String username, String password) {
    reportUtils.addStepDescription("Performing Login");
    loginpage.loginToApplication(username, password);
    
    reportUtils.addStepDescription("Comparing expected and actual title");
    String actualTitle = cmnDriver.getTitleOfThePage();
    String expectedTitle = "Guru99 Bank Manager Home Page";
    Assert.assertEquals(actualTitle, expectedTitle);
  }
}
