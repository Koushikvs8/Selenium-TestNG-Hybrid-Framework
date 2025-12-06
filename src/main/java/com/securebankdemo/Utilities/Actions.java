package com.securebankdemo.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Actions {

	private WebDriver driver ;
	private Waits waits;
    private JavascriptExecutor js;
	
	
	public Actions(WebDriver driver) {
		this.driver=driver;
		this.waits=new Waits(driver);
		this.js=(JavascriptExecutor)driver;
	}
	
	public WebElement find(By Locater)
	{
		return driver.findElement(Locater);
	}
	
	public void click(By Locater)
	{
		waits.waitByVisibility(Locater).click();
	}
	public boolean isDisplayed(By Locater)
	{
		return waits.waitByVisibility(Locater).isDisplayed();
	}
	
	public void sendText(By Locater ,String text)
	{
		waits.waitByVisibility(Locater).sendKeys(text);
	}
	
	public void displayed(By Locater )
	{
		waits.waitByPresence(Locater);
	}
	
	public String getUrl()
	{
		return  driver.getCurrentUrl();
	}
	

}
