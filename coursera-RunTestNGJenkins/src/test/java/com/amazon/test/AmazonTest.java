package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.pages.AmazonHomepage;

import commonLibs.CommonDriver;

public class AmazonTest {
  CommonDriver cmnDriver;
  AmazonHomepage homepage;
  String url = "https://www.amazon.com";
  WebDriver driver;

  @BeforeClass
  public void invokeBrowser() throws Exception {
    cmnDriver = new CommonDriver("chrome");
    cmnDriver.setPageloadTimeout(60);
    cmnDriver.setElementDetectionTimeout(10);
    cmnDriver.navigateToFirstUrl(url);
    driver = cmnDriver.getDriver();
    homepage = new AmazonHomepage(driver);
  }

  @Test
  public void searchProduct() throws Exception {
    String product = "iPhone";
    String category = "Electronics";
    homepage.searchProduct(product, category);
  }

  @AfterClass
  public void closeBrowser() throws Exception {
    cmnDriver.closeAllBrowsers();
  }
}
