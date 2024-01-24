=== Course ===
- [Waits in Selenium Test Automation Tool](https://www.coursera.org/projects/waits-in-selenium-test-automation-tool) from Coursera Project Network (instructor: Saurabh Dhingra)

=== Tasks ===
- Task 1: Understanding challenges faced in synchronizing application under test and automation scripts and implementing Page Load Timeout
- Task 2: Implementing Implicit wait
- Task 3: Implementing Explicit wait
- Task 4: More on Explicit wait
- Task 5: Implementing Fluent wait

=== Notes ===
- Page load timeout - Maximum time Selenium waits for a page to load, before throwing TimeoutException
  - Set it once, and it applies to all pages
    ```
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
    driver.get(url);
    ```
- WARNING: Do not mix implicit and explicit waits. Doing so can cause unpredictable wait times.
- Implicit wait - Time to wait for element to be in DOM ("element detection timeout"), before throwing NoSuchElementException
  - Example: Menu that appears on mouseover
  - Set it once, and it applies to all WebElements
  - `driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));`
- Conditional waits:
  - Explicit wait - Time to wait for a specific condition  (ie. waiting until element visible, clickable, or selectable)
    - Polls every 500ms
      ```
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      WebElement samsungLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Samsung")));

      // Other examples:
      wait.until(ExpectedConditions.elementToBeClickable(By.className("contact-email")));
      wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("div.class-one.class-two")));
      ```
  - Fluent wait - Similar to explicit wait, except we can define polling time and exceptions to ignore
    - Note: WebDriverWait is a specialized version of FluentWait
      ```
      Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofMillis(200))
        .ignoring(NoSuchElementException.class);
      wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Electronics GST Store")));
      ```