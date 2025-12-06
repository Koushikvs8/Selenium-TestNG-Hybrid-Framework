package com.securebankdemo.Tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.securebankdemo.DataStorage.DataStorage;
import com.securebankdemo.PageObjects.HomePage;
import com.securebankdemo.PageObjects.LoginPage;
import com.securebankdemo.TestBase.BaseTest;
import com.securebankdemo.Utilities.ConfigReader;
import com.securebankdemo.Utilities.DataProviders;
import com.securebankdemo.Utilities.LogUtility;



public class LoginTestes extends BaseTest {

	
	@Test()
	public void testValidLogin()
	{   LogUtility.info("Starting the login test ");
	    LogUtility.info("Adding the credentials and clicing on loginbutton ");
		LoginPage loginpage=new LoginPage(driver());
	    HomePage homepage= loginpage.login(ConfigReader.getValue("UserName"), ConfigReader.getValue("Password"), false);
	    LogUtility.info("Navigating to Homepage ");
	    String currentUrl=homepage.verifyNavigationtoHomepage();
	    String ExpectedUrl=DataStorage.HOMEPAGE_URL;
	    Assert.assertEquals(currentUrl, ExpectedUrl, "Login is failed user should redirect to homepahe");
	 
	}
	
@Test(dataProvider = "logindataByExcel",dataProviderClass =DataProviders.class, threadPoolSize=2)
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
	    	Assert.assertNotEquals(ExpectedUrl, ExpectedUrl, "user should not be redirect to Homepage for Invalid user ");
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
