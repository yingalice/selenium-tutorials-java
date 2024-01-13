package task6;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Parameterization {
	WebDriver driver;
	
	@BeforeClass
	public void invokeBrowser() {
		driver = new EdgeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://demo.guru99.com/v4");
	}
	
	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
	
	// @Parameters - Pass parameters to test case via XML file
	@Test
	@Parameters ({"username", "password"})
	public void loginToApplication(String username, String password) {
		driver.findElement(By.name("uid")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("btnLogin")).click();
	}
}
