package commonLibs.implementation;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonDriver {
  private WebDriver driver;
  private int pageLoadTimeout;
  private int elementDetectionTimeout;

  public CommonDriver(String browserType) throws Exception {
    pageLoadTimeout = 10;
    elementDetectionTimeout = 10;

    if (browserType.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browserType.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    } else {
      throw new Exception("Invalid browser type: " + browserType);
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
  }

  public void navigateToUrl(String url) {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageLoadTimeout));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));
    driver.get(url);
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void setPageLoadTimeout(int pageLoadTimeout) {
    this.pageLoadTimeout = pageLoadTimeout;
  }

  public void setElementDetectionTimeout(int elementDetectionTimeout) {
    this.elementDetectionTimeout = elementDetectionTimeout;
  }

  public String getTitleOfThePage() {
    return driver.getTitle();
  }

  public void closeAllBrowser() {
    driver.quit();
  }
}