package commonLibs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CommonDriver {
  private WebDriver driver;
  private int pageloadTimeout;
  private int elementDetectionTimeout;

  public CommonDriver(String browserType) throws Exception {
    pageloadTimeout = 60;
    elementDetectionTimeout = 10;

    if (browserType.equalsIgnoreCase("chrome")) {
      driver = new ChromeDriver();
    } else if (browserType.equalsIgnoreCase("edge")) {
      driver = new EdgeDriver();
    } else {
      throw new Exception("Invalid Browser Type");
    }

    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void setPageloadTimeout(int pageloadTimeout) {
    this.pageloadTimeout = pageloadTimeout;
  }

  public void setElementDetectionTimeout(int elementDetectionTimeout) {
    this.elementDetectionTimeout = elementDetectionTimeout;
  }

  public void navigateToFirstUrl(String url) throws Exception {
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(pageloadTimeout));
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(elementDetectionTimeout));
    url = url.trim();
    driver.get(url);
  }

  public String getTitle() throws Exception {
    return driver.getTitle();
  }

  public String getCurrentUrl() throws Exception {
    return driver.getCurrentUrl();
  }

  public String getPageSource() throws Exception {
    return driver.getPageSource();
  }

  public void navigateToUrl(String url) throws Exception {
    url = url.trim();
    driver.navigate().to(url);
  }

  public void navigateForward() throws Exception {
    driver.navigate().forward();
  }

  public void navigateBackward() throws Exception {
    driver.navigate().back();
  }

  public void refresh() throws Exception {
    driver.navigate().refresh();
  }

  public void closeBrowser() throws Exception {
    if (driver != null) {
      driver.close();
    }
  }

  public void closeAllBrowsers() throws Exception {
    if (driver != null) {
      driver.quit();
    }
  }
}
