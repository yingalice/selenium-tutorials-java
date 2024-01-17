package commonLibs.utils;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils {
  private TakesScreenshot camera;
  
  public ScreenshotUtils(WebDriver driver) {
    camera = (TakesScreenshot) driver;  // Typecast, so can use same browser to take screenshot
  }
  
  public void captureAndSaveScreenshot(String filename) throws Exception {
    filename = filename.trim();
    
    File imgFile, tmpFile;
    imgFile = new File(filename);
    if(imgFile.exists()) {
      throw new Exception("File already exists");
    }
    
    tmpFile = camera.getScreenshotAs(OutputType.FILE);
    tmpFile.renameTo(imgFile);
  }
}
