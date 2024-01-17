package commonLibs.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtils {
  public static Properties readProperties(String filename) throws IOException {
    filename = filename.trim();
    FileInputStream inputStream = new FileInputStream(filename);
    Properties prop = new Properties();
    prop.load(inputStream);  // Reads from stream, and converts to key/value pairs
    return prop;
  }
}