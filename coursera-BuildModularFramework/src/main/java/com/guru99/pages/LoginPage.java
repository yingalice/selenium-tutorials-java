package com.guru99.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//  Page Object Model - Create 1 class for every page in the application
//  Have each page extend BasePage and initialized with super(driver), since
//  all pages need the driver and ElementControl class for interactions

public class LoginPage extends BasePage {
  /*
   * Advantage of @FindBy/PageFactory to initElements Good for dynamic elements
   * that load slowly upon scroll, which if initialized normally
   * (driver.findElement) may throw an exception, but it won't here. Searches at
   * initialization, and again at time of interaction. For static elements that
   * don't change, add @CacheLookup, so it doesn't search again
   */

  @CacheLookup
  @FindBy(name = "uid")
  private WebElement userId;

  @CacheLookup
  @FindBy(name = "password")
  private WebElement userPassword;

  @CacheLookup
  @FindBy(name = "btnLogin")
  private WebElement loginButton;

  public LoginPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public void loginToApplication(String username, String password) {
    elementControl.setText(userId, username);
    elementControl.setText(userPassword, password);
    elementControl.clickElement(loginButton);
  }
}
