package commonLibs.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseUtils {
  private Connection connection;
  
  public void openConnection(String server, int portNumber, String database, String username, String password) throws SQLException {
    String connectionString = String.format("jdbc:mysql://%s:%d/%s", server, portNumber, database);
    connection = DriverManager.getConnection(connectionString, username, password);
  }
  
  public void closeConnection() throws SQLException {
    connection.close();
  }
  
  public Object[][] executeSqlSelectQuery(String sqlQuery) throws SQLException {
    // ResultSet settings: Cursor can move up or down, doesn't reflect updates in database, and contents cannot be updated
    Statement stmt = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    ResultSet resultSet = stmt.executeQuery(sqlQuery);
    resultSet.last();  // Move cursor to last row
    int rowCount = resultSet.getRow();  // Last row
    int colCount = resultSet.getMetaData().getColumnCount();  // Last column
    Object[][] data = new Object[rowCount][colCount];
    
    resultSet.beforeFirst();
    for (int row = 1; row <= rowCount; row++) {
      resultSet.next();
      for (int col = 1; col <= colCount; col++) {
        data[row - 1][col - 1] = resultSet.getString(col);
      }
    }
    
    return data;
  }
}