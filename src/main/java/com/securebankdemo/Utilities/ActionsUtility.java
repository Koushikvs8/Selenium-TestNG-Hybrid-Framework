package com.securebankdemo.Utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ActionsUtility {

	private WebDriver driver ;
	private Waits waits;
    private JavascriptExecutor js;
	
	
	public ActionsUtility(WebDriver driver) {
		this.driver=driver;
		this.waits=new Waits(driver);
		this.js=(JavascriptExecutor)driver;
	}
	
	public WebElement find(By locater)
	{
		return driver.findElement(locater);
	}
	
	public List<WebElement> findElements(By locater)
	{
		return driver.findElements(locater);
	}
	public void click(By locater)
	{
		waits.waitByVisibility(locater).click();
	}
	public void click(WebElement element)
	{
		waits.waitByVisibility(element).click();
	}
	public boolean isDisplayed(By locater)
	{
		return waits.waitByVisibility(locater).isDisplayed();
	}
	
	public void sendText(By locater ,String text)
	{
		waits.waitByVisibility(locater).sendKeys(text);
	}
	
	public void displayed(By locater )
	{
		waits.waitByPresence(locater);
	}
	
	public String getUrl()
	{
		return  driver.getCurrentUrl();
	}
	
	public void selectDropDownByText(By locater ,String option)
	{
		waits.waitByVisibility(locater);
		Select options=new Select(find(locater));
		options.selectByVisibleText("Savings Account");
		System.out.println(options.getOptions().get(2));
	}

}
