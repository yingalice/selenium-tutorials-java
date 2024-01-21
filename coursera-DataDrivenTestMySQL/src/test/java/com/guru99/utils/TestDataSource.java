package com.guru99.utils;

import java.sql.SQLException;

import org.testng.annotations.DataProvider;

import commonLibs.utils.DatabaseUtils;

public class TestDataSource {
  @DataProvider
  public Object[][] getData() {
    Object[][] data = new Object[3][2];  // 3 sets of test data with 2 arguments each
    data[0][0] = "mngr546003";
    data[0][1] = "bEhYrAs";

    data[1][0] = "mngr546829";
    data[1][1] = "turAduz";
    
    data[2][0] = "mngr546830";
    data[2][1] = "AsabEbY";
    
    return data;
  }
  
  @DataProvider
  public Object[][] getDataFromDatabase() throws SQLException {
    String server = "localhost";
    int portNumber = 3306;
    String database = "Guru99TestData";
    String username = "root";
    String password = "admin";
    String sqlQuery = "SELECT * FROM users";
    
    DatabaseUtils databaseUtils = new DatabaseUtils();
    databaseUtils.openConnection(server, portNumber, database, username, password);
    Object[][] data = databaseUtils.executeSqlSelectQuery(sqlQuery);
    databaseUtils.closeConnection();
    
    return data;
  }
}
