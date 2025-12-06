package com.securebankdemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.securebankdemo.Utilities.Actions;
import com.securebankdemo.Utilities.Waits;
public class HomePage extends BasePage {
   
    
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	By logo=By.xpath("//span[@id='brand-name']");
	By logOutBtn=By.xpath("//button[@id='logout-btn']");
	
	public String verifyNavigationtoHomepage()
	{   Waits.pause();
		return action.getUrl();
	}

	 public void clickOnLogout()
	 {
		 action.click(logOutBtn);
	 }
}
