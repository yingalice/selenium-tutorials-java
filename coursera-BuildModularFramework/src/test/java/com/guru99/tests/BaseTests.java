package com.guru99.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.guru99.pages.LoginPage;

import commonLibs.implementation.CommonDriver;
import commonLibs.utils.ConfigUtils;
import commonLibs.utils.ReportUtils;
import commonLibs.utils.ScreenshotUtils;

public class BaseTests {
  CommonDriver cmnDriver;
  WebDriver driver;
  String currentWorkingDirectory;
  Properties configProp;
  LoginPage loginpage;
  ReportUtils reportUtils;
  ScreenshotUtils screenshotUtils;
 
  @BeforeSuite
  public void preSetup() throws IOException {
    currentWorkingDirectory = System.getProperty("user.dir");
    String configFileName = currentWorkingDirectory + "/config/config.properties";
    String reportFilename = currentWorkingDirectory + "/reports/guru99TestReport.html";
    configProp = ConfigUtils.readProperties(configFileName);
    reportUtils = new ReportUtils(reportFilename);
  }
  
  @BeforeClass
  public void setup() throws Exception {
    String url = configProp.getProperty("baseUrl");
    String browserType = configProp.getProperty("browserType");
    cmnDriver = new CommonDriver(browserType);
    driver = cmnDriver.getDriver();
    loginpage = new LoginPage(driver);
    screenshotUtils = new ScreenshotUtils(driver);
    cmnDriver.navigateToUrl(url);
  }

  @BeforeMethod
  public void setupTest(Method method) {
    String testName = method.getAnnotation(Test.class).testName();
    reportUtils.createATestCase(testName);
  }
  
  @AfterMethod
  public void postTestAction(ITestResult result) throws Exception {
    // Take screenshot if test failed
    String testMethodName = result.getName();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmssSS");
    ZonedDateTime date = ZonedDateTime.now(ZoneId.of("America/Los_Angeles"));
    String executionTime = date.format(formatter);    
    String screenshotFilename = currentWorkingDirectory + 
        "/screenshots/" + testMethodName + "." + executionTime + ".jpeg";
    
    if (result.getStatus() == ITestResult.FAILURE) {
      reportUtils.addTestLog(Status.FAIL, result.getThrowable().toString());
      screenshotUtils.captureAndSaveScreenshot(screenshotFilename);
      reportUtils.attachScreenshotToReport(screenshotFilename);
    }
  }

  @AfterClass
  public void tearDown() {
    cmnDriver.closeAllBrowser();
  }
  
  @AfterSuite
  public void postTeardown() {
    reportUtils.flushReport();
  }
}