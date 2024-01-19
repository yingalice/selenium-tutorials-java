package com.amazon.tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AmazonFeatureTests {
  ChromeDriver driver;

  @BeforeClass
  public void invokeBrowser() {
    ChromeOptions options = new ChromeOptions();
//    Headless won't have captchas, but you also can't see the browser
//    options.addArguments("--headless=new");
    driver = new ChromeDriver(options);
    
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.get("https://amazon.com");
  }
  
  @Test (priority = 0, enabled = false)
  public void verifyTitleOfThePage() {
    String actualTitle = driver.getTitle();
    String expectedTitle = "Amazon.com. Spend less. Smile more.";
    Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test (priority = 100)
  public void searchProduct() {
    String productItem = "Apple Watch";
    String category = "Electronics";
    WebElement selDropdown = driver.findElement(By.id("searchDropdownBox"));
    Select selectCategory = new Select(selDropdown);
    selectCategory.selectByVisibleText(category);
    driver.findElement(By.id("twotabsearchtextbox")).sendKeys(productItem);
    driver.findElement(By.id("nav-search-submit-button")).click();
  }
  
  @Test (priority = 200)
  public void getNthProduct() {
    int productItemNumber = 4;
    String xpathExpression = String.format("//div[@data-component-type='s-search-result'][%d]", productItemNumber);
    WebElement nthProduct = driver.findElement(By.xpath(xpathExpression));
    String nthProductResult = nthProduct.getText();
    System.out.println(nthProductResult);  
    // If we had access to the Amazon DB, a good Assert would be good to query it and compare it to the web results
  }
  
  @Test (priority = 300, enabled = false)
  public void getAllProducts() {
    List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2"));
    String productResult;
    for (WebElement product : allProducts) {
      productResult = product.getText();
      System.out.println("-----------");
      System.out.println(productResult);
    }
  }

  @Test (priority = 400, enabled = false)
  public void getAllProductsViaScrollDown() {
    List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2"));
    String productResult;
    Actions action = new Actions(driver);
    for (WebElement product : allProducts) {
      action.moveToElement(product).perform();
      productResult = product.getText();
      System.out.println("-----------");
      System.out.println(productResult);
    }
  }
  
  @Test (priority = 500)
  public void getAllProductsViaScrollDownUsingJS() throws InterruptedException {
    List<WebElement> allProducts = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//h2 | //div[@data-component-type='s-search-result']//span[@class='a-price']/span[@class='a-offscreen']"));
    for (WebElement product : allProducts) {
      if (product.getTagName().equals("h2")) {
//        int xCoordinate = product.getLocation().x;
//        int yCoordinate = product.getLocation().y;
//        scrollDown(xCoordinate, yCoordinate);
        scrollTo(product);
        String productResult = product.getText();
        System.out.println(productResult);        
      } else if (product.getTagName().equals("span")) {
        String productPrice = product.getAttribute("textContent");
        System.out.println(productPrice);
        System.out.println("-----------");
        Thread.sleep(500);
      }
    }
  }
  
  private void scrollTo(WebElement element) {
    JavascriptExecutor jsEngine = (JavascriptExecutor) driver;
    jsEngine.executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center', inline: 'center' })", element);
  }
  
//  private void scrollDown(int x, int y) {
//    JavascriptExecutor jsEngine = (JavascriptExecutor) driver;
//    String jsCommand = String.format("window.scrollBy(%d, %d)", x, y);
//    jsEngine.executeScript(jsCommand);
//  }
  
  @AfterClass
  public void closeBrowser() {
    driver.quit();
  }
}
