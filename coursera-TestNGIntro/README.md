=== Course ===
- [Introduction to TestNG and Integration with Selenium](https://www.coursera.org/projects/introduction-to-testng-integration-with-selenium) from Coursera Project Network (instructor: Saurabh Dhingra)

=== Tasks ===
- Task 1: Writing test cases using @Test annotation using TestNG
- Task 2: Using @BeforeMethod and @AfterMethod annotations in TestNG
- Task 3: Using @BeforeClass and @AfterClass annotations in TestNG
- Task 4: TestNG integration with Selenium automation tool
- Task 5: Priority and enabled attributes in TestNG
- Task 6: Assertions in TestNG
- Task 7: Understanding different format of reports in TestNG

=== Notes ===
- Annotations
  - `@BeforeClass` - First method to execute in a class
    - preSetup()
    - Example: Invoke browser, set browser settings, initialize report
  - `@BeforeMethod` - Runs before every test case
    - setup()
    - Example: Login to app
  - `@Test` - Test case
  - `@AfterMethod` - Runs after every test case
    - tearDown()
    - Example: Logoff from app
  - `@AfterClass` - Last method to execute in a class (ie. close browser)
    - postCleanUp()
    - Example: Close browser, stop report
- Attributes
  - `@Test` (enabled = false)
    - Disables test case
  - `@Test` (priority = 100)
    - Orders test case (otherwise, it runs alphabetically).  Lowest runs first.
- Assertions
  - In TestNG, a test fails whenever an exception occurs (ie. AssertionError)
  - Tests should have at least 1 assert statement, otherwise it would never fail
  - Assert class offers methods like
    - `Assert.assertEquals()`
    - `Assert.assertTrue()`
- Reports
  - Console
  - Eclipse
  - emailable-report.html under /test-output
  - testng-results.xml under /test-output