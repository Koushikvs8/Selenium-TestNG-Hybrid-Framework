package com.securebankdemo.PageObjects;

import org.openqa.selenium.WebDriver;

import com.securebankdemo.Utilities.Actions;

public class BasePage {
   protected WebDriver driver;
   protected Actions action;
    
    
	public BasePage(WebDriver driver) {
		this.driver=driver;
		this.action=new Actions(driver);
	}

}
