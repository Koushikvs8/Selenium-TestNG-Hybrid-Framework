package com.securebankdemo.TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.securebankdemo.PageObjects.HomePage;
import com.securebankdemo.Utilities.ConfigReader;
import com.securebankdemo.Utilities.ExtentReportManager;
import com.securebankdemo.Utilities.LogUtility;

import factory.DriverManager;

public class BaseTest {
  static final int IMPLICIT_TIMEOUT_SECONDS= Integer.parseInt(ConfigReader.getValue("Implicite_Timeout"));
  protected  static ExtentReports extent;
  protected  static ExtentTest test;
  
  @BeforeSuite
 public void setupReport() 
 {
	// extent=ExtentReportManager.getReportInstance();
 }
  
  @AfterSuite
 public void tearDownReport()
 {
	 extent.flush();
 }
  
  
@BeforeMethod
public static void setUp()
{  
   LogUtility.info("Starting the Webdriver ");
   String Url= ConfigReader.getValue("Url");
   String Browser= ConfigReader.getValue("Browser");
   DriverManager.initDriver(Browser);
   DriverManager.getDriver().get(Url);
   driver().manage().window().maximize();
   driver().manage().deleteAllCookies();
   driver().manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICIT_TIMEOUT_SECONDS));
   driver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(IMPLICIT_TIMEOUT_SECONDS));
}


@AfterMethod
public  void tearDown()
{  LogUtility.info("Closing the Webdriver ");
	DriverManager.quiteDriver();
}


public static WebDriver   driver()
{
	return DriverManager.getDriver();
}

}
