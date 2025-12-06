package com.securebankdemo.Utilities;
import org.testng.*;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;


public class TestListeners implements ITestListener {

    private static ExtentReports extent = ExtentReportManager.getInstance();
    private static ThreadLocal<ExtentTest> testReport = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        testReport.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        testReport.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ExtentReportManager.captureScreenshot(result.getMethod().getMethodName());

        testReport.get().fail(result.getThrowable());
        testReport.get().fail("screenshot of failed ",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        testReport.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
