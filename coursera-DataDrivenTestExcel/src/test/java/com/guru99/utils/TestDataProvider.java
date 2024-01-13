package com.guru99.utils;

import org.testng.annotations.DataProvider;

import commonLibs.utils.ExcelDriver;

public class TestDataProvider {
	// Data-driven testing via @DataProvider
	// Test data from (a) class file (b) Excel file
	
	@DataProvider
	public Object[][] getData() {
		// Any data type can be stored in an object.  Test data can be anything.
		Object[][] data = new Object[3][2];
		
		data[0][0] = "mngr546003";
		data[0][1] = "bEhYrAs";

		data[1][0] = "mngr546829";
		data[1][1] = "turAduz";

		data[2][0] = "mngr546830";
		data[2][1] = "AsabEbY";
		
		return data;
	}
	
	@DataProvider
	public Object[][] getDataFromExcel() throws Exception {
		String excelFileName = System.getProperty("user.dir") + "/testDataInputFiles/TestData.xlsx";
		String sheetname = "TestData";
		
		ExcelDriver excelDriver = new ExcelDriver();
		excelDriver.openWorkbook(excelFileName);
		
		int rowCount = excelDriver.getRowCount(sheetname);
		int cellCount = excelDriver.getCellCountFromARow(sheetname, 1);
		Object[][] data = new Object[rowCount][cellCount];
		
		for (int row = 0; row < rowCount; row++) {
			for (int cell = 0; cell < cellCount; cell++) {
				data[row][cell] = excelDriver.getCellData(sheetname, row, cell);
			}
		}
		return data;
	}
}
