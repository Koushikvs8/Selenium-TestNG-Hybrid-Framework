package com.securebankdemo.Components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.securebankdemo.PageObjects.BasePage;

public class GlobalNav extends BasePage{

	public GlobalNav(WebDriver driver) {
		super(driver);
	}
	
	By logo=By.xpath("//span[@id='brand-name']");
	By logOutBtn=By.xpath("//button[@id='logout-btn']");
	By dashBoardBtn =By.xpath("//a[@data-testid='nav-dashboard']");
	By accountBtn =By.xpath("//a[@data-testid='nav-accounts']");
	By transactionBtn =By.xpath("//a[@data-testid='nav-accounts']");
	
	public void clickOnDashboard()
	{
		action.click(dashBoardBtn);
	}
	public void clickOnAccounts()
	{
		action.click(accountBtn);
	}

	public void clickOnTransactions()
	{
		action.click(transactionBtn);
	}
	
	 public void clickOnLogout()
	 {
		 action.click(logOutBtn);
	 }
}
