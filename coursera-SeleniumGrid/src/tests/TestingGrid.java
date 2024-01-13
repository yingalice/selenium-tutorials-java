package tests;

import java.net.URL;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class TestingGrid {
	WebDriver driver;
	
	@Test
	public void invokeBrowser() throws MalformedURLException, URISyntaxException {
		URL remoteUrl = new URI("http://192.168.0.208:4444/").toURL();
		ChromeOptions options = new ChromeOptions();
		driver = new RemoteWebDriver(remoteUrl, options);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://google.com");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}