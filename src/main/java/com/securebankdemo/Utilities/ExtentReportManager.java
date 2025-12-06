package com.securebankdemo.Utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import factory.DriverManager;

public class ExtentReportManager {

	private static ExtentReports extent;
	private static ExtentTest test;
	public static String reportPath;
	

    public static ExtentReports getInstance() {
        if (extent == null) {
        	
        	String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
        	reportPath = "reports/ExtentReport_"+timestamp+".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setReportName("Automation Test Report");
            reporter.config().setDocumentTitle("Test Results");

            extent = new ExtentReports();
            extent.attachReporter(reporter);
        }
        return extent;
    }
	
	
	
	public static String captureScreenshot( String screenshotName) {
		try {
			String timestamp=String.valueOf(System.currentTimeMillis());
			File src = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE);
			String path= System.getProperty("user.dir")+ "/screenshots/"+screenshotName+timestamp+".png";
			LogUtility.info("the screenshot is captured and saved in path :"+path);
			FileUtils.copyFile(src, new File(path));
			return path;
			
		}
		catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
}
