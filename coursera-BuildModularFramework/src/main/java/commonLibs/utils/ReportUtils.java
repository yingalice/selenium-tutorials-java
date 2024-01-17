package commonLibs.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportUtils {
  ExtentSparkReporter htmlReporter;
  ExtentReports extentReports;
  ExtentTest extentTest;
  
  public ReportUtils(String htmlReportFilename) {
    htmlReportFilename = htmlReportFilename.trim();
    htmlReporter = new ExtentSparkReporter(htmlReportFilename);
    extentReports = new ExtentReports();
    extentReports.attachReporter(htmlReporter);
  }
  
  public void createATestCase(String testcaseName) {
    extentTest = extentReports.createTest(testcaseName);
  }
  
  public void addTestLog(Status status, String comment) {
    extentTest.log(status, comment);
  }
  
  public void addStepDescription(String description) {
    extentTest.log(Status.INFO, description);
  }
  
  public void attachScreenshotToReport(String filename) {
    extentTest.addScreenCaptureFromPath(filename);
  }
  
  public void flushReport() {
    extentReports.flush();
  }
}
