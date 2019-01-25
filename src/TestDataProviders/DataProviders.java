package TestDataProviders;

import org.testng.annotations.DataProvider;

import UsingJXL.JXLDemo;

public class DataProviders {
	@DataProvider(name="BasicInfoProvider")
	public String[][] basicInfoProvider() {
		String[][] data=JXLDemo.readExcel();
		return data;

	}

}
