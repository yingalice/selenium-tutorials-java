=== Course ===
- [Advanced TestNG Framework and Integration with Selenium](https://www.coursera.org/projects/advanced-testng-framework-integration-with-selenium) from Coursera Project Network (instructor: Saurabh Dhingra)

=== Tasks ===
- Task 1: Executing TestNG test cases using TestNG XML file
- Task 2: Executing methods before and after a test run or a test suite
- Task 3: Executing test cases of multiple classes via TestNG XML file
- Task 4: Executing test cases of all the classes of a package
- Task 5: Grouping test cases and executing them via TestNG XML file
- Task 6: Parameterizing test methods using @Paramters annotation
- Task 7: Parallel execution of test cases on multiple browsers using TestNG
- Task 8: Data-Driven testing using @DataProvider annotation

=== Notes ===
- To understand the order of @BeforeSuite, @BeforeTest, @BeforeClass, @BeforeMethod (and their @After equivalents), it helps to look at the XML file structure
  - Hierarchy is: Suite > Test > Class > Test case	
- Executions:
  - Option 1: No XML file
    - Right click class > Run As > TestNG Test
  - Option 2: With XML file
    - Right click class > TestNG > Convert to TestNG.  Creates an XML file, which you can edit
    - Right click XML file > Run As > TestNG Suite
- Annotation attributes:
  - groups:
    - Specify groups.  Add curly braces if it belongs to multiple groups
    - Specify which `<groups>` to run in XML file (ie. Sanity vs Regression)
    - `@Test (groups = {"Sanity", "Regression"})`
  - alwaysRun:
    - @Before/@After won't automatically run unless it belongs to the group
    - To always run regardless of group, set alwaysRun = true
    - `@BeforeMethod (alwaysRun = true)`
- Parameterization
  - Pass @Parameters to test case by specifying its actual value in XML file's `<parameter>`
    ```
    @Parameters ({"username", "password"})
    public void loginToApplication(String username, String password) {
    ```
- Parallel exeution on multiple browsers
  - In the XML file
    - Java: `@Parameters("browserType")`
    - XML: Duplicate entire `<test>` block for each browser, update `name` attribute's value to make it unique, then change browserType `<parameter>`'s value
    - Enable parallelism with `<suite name="Suite" parallel="tests">`
- Sample XML file
  - Combined what we've learned into a single file here for brevity, but they're used separately
    ```
    <suite name="Sample">
      <test thread-count="5" name="Test">
        <parameter name="browserType" value="Chrome"/>
        <parameter name="username" value="mngr546003"/>
        <parameter name="password" value="bEhYrAs"/>
        <groups>
          <run>
            <include name="Sanity"></include>
          </run>
        </groups>
        <packages>
          <!-- Observed behavior: Take all classes from both packages and sort alphabetically.  This is the order it'll run.
                                  If classes have the same name, run the class from task3 first, because it's listed first -->
          <package name="task3"/>
          <package name="task1"/>
        </packages>
        <classes>
          <class name="task3.TestingClass1"/>
          <class name="task3.TestingClass2"/>
        </classes>
      </test>
    </suite>
    ```
