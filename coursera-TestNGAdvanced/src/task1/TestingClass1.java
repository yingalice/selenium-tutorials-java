package task1;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestingClass1 {
	//	To understand the order of @BeforeSuite, @AfterSuite, @BeforeTest, @AfterTest,
	//  it helps to look at the XML file structure
	//	Hierarchy is: Suite > Test > Class > Test case
	
	// Executions:
	// ===Option 1: NO XML FILE===
	// 1. Right click class
	// 2. Click Run As > TestNG Test
	// ===Option 2: WITH XML FILE===
	// 1. Right click class
	// 2. Click TestNG > Convert to TestNG.  Creates an XML file, which you can edit
	// 3. Right click XML file
	// 4. Click Run As > TestNG Suite
	
	@BeforeSuite
	public void beforeASuite() {
		System.out.println("Before a test suite");
	}
	
	@AfterSuite
	public void afterASuite() {
		System.out.println("After a test suite");
	}
	
	@BeforeTest
	public void beforeATestRun() {
		System.out.println("Before a test run");
	}
	
	@AfterTest
	public void afterATestRun() {
		System.out.println("After a test run");
	}
	
	@BeforeClass
	public void beforeAClass() {
		System.out.println("First method in this class");
	}
	
	@AfterClass
	public void afterClass() {
		System.out.println("Last test method in this class");
	}
	
	@BeforeMethod
	public void beforeMethod() {
		System.out.println("\t Before a test method");
	}
	
	@AfterMethod
	public void afterMethod() {
		System.out.println("\t After a test method");
	}
	
	@Test
	public void testcase1() {
		System.out.println("\t\t Test case 1");
	}
	
	@Test
	public void testcase2() {
		System.out.println("\t\t Test case 2");
	}
}
