package task8;

import org.testng.annotations.DataProvider;

public class TestData {
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[3][2];  // 3 sets of data, 2 arguments
		
		data[0][0] = "mngr546003";
		data[0][1] = "bEhYrAs";
		
		data[1][0] = "mngr546829";
		data[1][1] = "turAduz";
		
		data[2][0] = "mngr546830";
		data[2][1] = "AsabEbY";
		
		return data;
	}
}