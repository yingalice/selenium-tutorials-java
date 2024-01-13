package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonLibs.Interactions;

public class AmazonHomepage {
  @CacheLookup
  @FindBy(id = "twotabsearchtextbox")
  private WebElement searchBox;

  @CacheLookup
  @FindBy(id = "searchDropdownBox")
  private WebElement searchCategory;

  @CacheLookup
  @FindBy(xpath = "//input[@value='Go']")
  private WebElement searchButton;

  @FindBy(xpath = "//span[contains(text(), 'results for')]")
  private WebElement searchResult;

  private Interactions interaction;

  public AmazonHomepage(WebDriver driver) {
    PageFactory.initElements(driver, this);
    interaction = new Interactions();
  }

  public void searchProduct(String product, String category) throws Exception {
    interaction.setText(searchBox, product);
    interaction.selectViaVisibleText(searchCategory, category);
    interaction.clickElement(searchButton);
    System.out.println(interaction.getText(searchResult));
  }
}