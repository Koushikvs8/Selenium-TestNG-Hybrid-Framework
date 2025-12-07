package com.securebankdemo.TestBase;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
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
 
@Parameters("browser")
@BeforeMethod
public static void setUp(@Optional String xmlBrowser)
{  
	   // 1. Read Maven parameter
    String mavenBrowser = System.getProperty("browser");

    // 2. Read config file fallback
    String configBrowser = ConfigReader.getValue("Browser");

    // 3. Final browser
    String browser;

    if (xmlBrowser != null && !xmlBrowser.isEmpty()) {
        browser = xmlBrowser; // TestNG XML value
    } 
    else if (mavenBrowser != null && !mavenBrowser.isEmpty()) {
        browser = mavenBrowser; // Maven CLI value
    }
    else {
        browser = configBrowser; // Properties file fallback
    }
	
   LogUtility.info("Starting the Webdriver ");
   String Url= ConfigReader.getValue("Url");
   DriverManager.initDriver(browser);
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
