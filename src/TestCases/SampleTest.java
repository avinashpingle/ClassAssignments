package TestCases;

import org.testng.annotations.Test;

import TestDataProviders.DataProviders;

public class SampleTest {
	@Test(dataProvider="BasicInfoProvider",dataProviderClass=DataProviders.class)
	public void m1(String srNo, String name, String phNo, String city) {
		System.out.println(srNo+"\t"+name+"\t"+phNo+"\t"+city);

	}
	

}