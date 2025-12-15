package com.securebankdemo.PageObjects;

import org.openqa.selenium.WebDriver;

import com.securebankdemo.Components.GlobalNav;
import com.securebankdemo.Utilities.ActionsUtility;

public class BasePage {
   protected WebDriver driver;
   protected ActionsUtility action;
   
    
    
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.action=new ActionsUtility(driver);
		
	}

}
