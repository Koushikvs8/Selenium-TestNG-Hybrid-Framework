package com.securebankdemo.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.securebankdemo.DataStorage.DataStorage;
import com.securebankdemo.PageObjects.DashboardPage;
import com.securebankdemo.PageObjects.LoginPage;
import com.securebankdemo.TestBase.BaseTest;
import com.securebankdemo.Utilities.ConfigReader;
import com.securebankdemo.Utilities.DataProviders;
import com.securebankdemo.Utilities.LogUtility;



public class LoginTestes extends BaseTest {

	
	@Test()
	public void ValidateLoginForValidUser()
	{   LogUtility.info("Starting the login test ");
	    LogUtility.info("Adding the credentials and clicking on loginbutton ");
		LoginPage loginpage=new LoginPage(driver());
		DashboardPage homepage= loginpage.login(ConfigReader.getValue("UserName"), ConfigReader.getValue("Password"), false);
	    LogUtility.info("Navigating to Homepage ");
	    String currentUrl=homepage.verifyNavigationtoHomepage();
	    String ExpectedUrl=DataStorage.HOMEPAGE_URL;
	    Assert.assertEquals(currentUrl, ExpectedUrl, "Login is failed user should redirect to homepahe");
	 
	}
	


}
