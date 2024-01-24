=== Course ===
- [Create Your First Automation Script Using Selenium and Java](https://www.coursera.org/projects/create-automation-script-using-selenium-java) from Coursera Project Network (instructor: Saurabh Dhingra)

=== Tasks ===
- Task 1: Setup a Java project for automation scripts
- Task 2: Run your first automation script on Chrome Browser
- Task 3: Writing your first Test Case using TestNG
- Task 4: Interacting With Elements of Web Application
- Task 5: Interacting with Web Elements like radio button and Links
- Task 6: Interacting with web tables on a web application

=== Notes ===
- Include library files:
  - Right click your Java project > Build Path > Configure Build Path
  - Libraries tab > Classpath
    - Add External JARs
      - Selenium: Add every .jar downloaded from selenium-java-x.xx.x.zip
        - Shows under Referenced Libraries in Package Explorer
    - Add Library (internal to Eclipse)
      - TestNG
        - Shows under TestNG in Package Explorer
- Eclipse shortcuts:
  - Ctrl + Space = Autocomplete suggestions
    - To trigger automatiaclly:
      - Window > Preferences > Java > Editor > Content Assist > Auto Activation Triggers for Java: `._abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`
  - Ctrl + Shift + O = Import packages
- Open/close browser:
  ```
  WebDriver driver = new ChromeDriver();
  driver.get(url);
  driver.quit();
  ```
- Add asserts, so tests will pass/fail:
  ```
  String actualTitle = driver.getTitle();
  String expectedTitle = "Guru99 Bank Home Page";
  Assert.assertEquals(actualTitle, expectedTitle);  
  ```
- Interact with WebElements:
  - Locator examples: `By.linkText`, `By.id`
  - Interaction examples: `.click()`, `.getText()`
    ```
    WebElement userId = driver.findElement(By.name("uid"));
    userId.sendKeys("mngr546003");
    String customerId = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText();
    ```
- Run as Java Application
  - Need to call methods inside `public static void main(String[] args)`
- Run as TestNG Test
  - Directly run methods using annotations
    - `@BeforeMethod` - Runs before every test case
    - `@Test` - Test case
    - `@AfterMethod` - Runs after every test case
  - Order
    - Tests run alphabetically
    - Can set order with priority attribute (lower numbers run first)
      - `@Test (priority = 100)`