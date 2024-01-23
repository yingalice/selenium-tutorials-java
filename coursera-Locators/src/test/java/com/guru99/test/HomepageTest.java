package com.guru99.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomepageTest {
  WebDriver driver;

  @BeforeClass
  public void invokeBrowser() {
    driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get("http://demo.guru99.com/v4");
  }

  @Test
  public void verifyLogin() {
    driver.findElement(By.name("uid")).sendKeys("mngr546003");
    driver.findElement(By.name("password")).sendKeys("bEhYrAs");
    driver.findElement(By.name("btnLogin")).click();
  }

  @AfterClass
  public void closeBrowser() {
    driver.quit();
  }
}
