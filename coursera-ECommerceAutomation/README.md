
=== Course ===
- [Automate an e-commerce web application using Selenium & Java](https://www.coursera.org/projects/automate-e-commerce-web-application-using-selenium-java) from Coursera Project Network (instructor: Saurabh Dhingra)

=== Tasks ===
- Task 1: Navigate to E-commerce web application
- Task 2: Perform search product item operation/functionality
- Task 3: Finding Nth product from the product results
- Task 4: Finding all the products from the product results
- Task 5: Finding all the products from the product results along with scroll down using mouse operations.
- Task 6: Finding all the products from the product results along with scroll down via Javascript operations

=== Notes ===
- `Select` class is used to interact with dropdowns, and has methods to select by index, value, or text
- `String.format` helps replace variables in a string (replaces %d with 4)
  ```
  int productItemNumber = 4;
  String xpathExpression = String.format("//div[@data-component-type='s-search-result'][%d]", productItemNumber);
  ```
- To get the nth item, append `[n]` to xpath (see above)
- For each loop syntax:
  - `for (WebElement product : allProducts) {}`
- Get text:
  ```
  element.getText();                    // Visible text only
  element.getAttribute("textContent");  // Includes hidden text
  ```
- `Actions` class performs mouse operations such as scroll, drag and drop, mouse hover, double-click, right-click
  - Note: build() accumulates chain of all actions, and perform() executes them:
  ```
  Actions action = new Actions(driver);
  action.moveToElement(product).build().perform();
  ```
- `JavascriptExecutor` interface is used to perform Javascript
  ```
  JavascriptExecutor jsEngine = (JavascriptExecutor) driver;
  jsEngine.executeScript("arguments[0].scrollIntoView()", element);
  ```