package com.securebankdemo.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="logindataByExcel")
	public Object[][]  loginData()
	{
		    String path = System.getProperty("user.dir") +
		                  "\\src\\test\\resources\\TestData\\loginData.xlsx";

		    return ExcelReaderUtlility.getSheetData(path ,"Sheet1");
		
 
	
	}

}
