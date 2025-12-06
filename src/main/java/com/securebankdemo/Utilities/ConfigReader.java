package com.securebankdemo.Utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	public static Properties prop= new Properties();
static {
	
	try {
		FileInputStream myfileInput= new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\config.properties");
		prop.load(myfileInput);
	} catch (Exception e) {
		e.printStackTrace();
	}

}

public static String getValue(String key)
{
	return prop.getProperty(key);
}




}
