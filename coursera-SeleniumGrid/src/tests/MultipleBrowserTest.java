package tests;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class MultipleBrowserTest {
	WebDriver driver;
	
	@Test
	@Parameters ("browserType")
	public void invokeBrowser(String browserType) throws MalformedURLException, URISyntaxException {
		URL remoteUrl = new URI("http://192.168.0.208:4444/").toURL();
		if (browserType.equals("chrome")) {
			ChromeOptions options = new ChromeOptions();
			driver = new RemoteWebDriver(remoteUrl, options);
		} else if (browserType.equals("edge")) {
			EdgeOptions options = new EdgeOptions();
			driver = new RemoteWebDriver(remoteUrl, options);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://google.com");
		Assert.assertEquals(driver.getTitle(), "Google");
	}
	
	@Test
	public void searchGoogle() {
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys("Christmas" + Keys.ENTER);
		Assert.assertTrue(driver.getTitle().contains("Google Search"));
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}