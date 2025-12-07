package com.securebankdemo.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.securebankdemo.DataStorage.DataStorage;
import com.securebankdemo.PageObjects.HomePage;
import com.securebankdemo.PageObjects.LoginPage;
import com.securebankdemo.TestBase.BaseTest;
import com.securebankdemo.Utilities.DataProviders;
import com.securebankdemo.Utilities.LogUtility;

public class LoginTestesDDT extends BaseTest{

	@Test(dataProvider = "logindata", threadPoolSize=2)
	public void testAllInvalidLogins(String userName, String Password,String status)
	{    LogUtility.info("Starting the login test with user :" +userName +" | "+Password +" | ");
	    LoginPage loginpage=new LoginPage(driver());
	    HomePage homepage= loginpage.login(userName, Password, true);
	    String currentUrl=homepage.verifyNavigationtoHomepage();
    	String ExpectedUrl=DataStorage.HOMEPAGE_URL;
	    if(status.equals("success"))
	    { 
		    Assert.assertEquals(currentUrl, ExpectedUrl, "Login is failed user should redirect to homepage for Valid user");
	    }
	    else if(status.equals("falied"))
	    {   
	    	Assert.assertNotEquals(currentUrl, ExpectedUrl, "user should not be redirect to Homepage for Invalid user ");
	    	Assert.assertTrue(loginpage.alertMsgDisplay());
	    }
	    else if(status.equals("empty"))
	    {
	    	Assert.assertTrue(loginpage.usernameReqMsg());
	    	Assert.assertTrue(loginpage.passwordReqMsg());
	    	Assert.assertNotEquals(currentUrl, currentUrl, "user should not be redirect to Homepage for Invalid user ");

	    }
	  
	}


@DataProvider(name="logindata" , parallel = true)
public Object[][] getLoginData()
{
	String [][] data= {{"admin", "admin123","success"},
			         {"koushik", "admim1234","falied"},
			           {"swathi", "admin123","falied"},
			           {"","","empty"}
	};
	
	return data;
}
}
