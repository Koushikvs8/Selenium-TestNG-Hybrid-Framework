package com.securebankdemo.Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {
	
	private WebDriver driver;
	private WebDriverWait  wait;
	
	public Waits(WebDriver driver)
	{
		this.driver=driver;
		this.wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		
	}
	

	public WebElement waitByVisibility(WebElement element) {
	    try {
	        return wait.until(ExpectedConditions.visibilityOf(element));
	    } catch (Exception e) {
	    	LogUtility.error( "Element is not visible: ");
	        throw new RuntimeException( " "+element, e);
	    }
	}

	
	public WebElement waitByPresence(By locater) {
	    try {
	        return wait.until(ExpectedConditions.presenceOfElementLocated(locater));
	    } catch (Exception e) {
	    	LogUtility.error( "Element is not present e: ");
	    	throw new RuntimeException("" + locater, e);
	    }
	}
	
	public WebElement waitByVisibility(By locater) {
	    try {
	        return wait.until(ExpectedConditions.visibilityOfElementLocated(locater));
	    } catch (Exception e) {
	    	LogUtility.error( "Element is not visible: ");
	        throw new RuntimeException( " "+locater, e);
	        
	    }
	}
	
	public static void pause()
	{
		try {
			Thread.sleep(1000);
		}
		catch (InterruptedException e) {
			 LogUtility.error( e.getMessage());
		}
	}

}
