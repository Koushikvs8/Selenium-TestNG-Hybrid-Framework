package com.securebankdemo.Utilities;

import java.util.Arrays;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="logindataByExcel")
	public Object[][]  loginData()
	{
		    String path = System.getProperty("user.dir") +
		                  "\\src\\test\\resources\\TestData\\loginData.xlsx";

		    Object[][] data = ExcelReaderUtlility.getSheetData(path, "Sheet1");

		    // Print array nicely
		    for (Object[] row : data) {
		        System.out.println("Row : " + Arrays.toString(row));
		    }

		    return data;
          
		//    return ExcelReaderUtlility.getSheetData(path ,"Sheet1");
		
 
	
	}

}
