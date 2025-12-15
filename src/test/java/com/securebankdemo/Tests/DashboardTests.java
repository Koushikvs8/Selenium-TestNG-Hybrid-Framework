package com.securebankdemo.Tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.securebankdemo.Components.GlobalNav;
import com.securebankdemo.PageObjects.DashboardPage;
import com.securebankdemo.PageObjects.LoginPage;
import com.securebankdemo.TestBase.BaseTest;
import com.securebankdemo.Utilities.ConfigReader;
import com.securebankdemo.Utilities.Waits;

public class DashboardTests extends BaseTest{
     
	
	
	
	@Test
	public void ValidateAccountCreation()
	{
		LoginPage loginpage=new LoginPage(driver());
		DashboardPage dashBordPage=loginpage.login(ConfigReader.getValue("UserName"), ConfigReader.getValue("Password"), true);
		Integer existingAccountCount =dashBordPage.checkNumberExistingAccount();
		System.out.println(existingAccountCount);
		dashBordPage.clickOnAddAcount();
		dashBordPage.creatTheAccount("MynewSaving", "Savings Account", "1000");
		GlobalNav globalNav=new GlobalNav(driver());
		globalNav.clickOnDashboard();
		Integer expectedAccountCount  =dashBordPage.checkNumberExistingAccount();
		System.out.println(expectedAccountCount);
		Assert.assertTrue(expectedAccountCount==existingAccountCount+1);
	
		
	}

}
