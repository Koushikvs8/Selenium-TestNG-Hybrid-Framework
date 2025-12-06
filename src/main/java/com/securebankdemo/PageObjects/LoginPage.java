package com.securebankdemo.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.securebankdemo.Utilities.LogUtility;
import com.securebankdemo.Utilities.Waits;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	By usernameInput=By.xpath("//input[@name='username']");
	By usernameReqMsg=By.xpath("//p[@id='username-error']");
	By passwordInput=By.xpath("//input[@name='password']");
	By passwordReqMsg=By.xpath("//p[@id='username-error']");
	By rememberChkBox=By.xpath("//button[@role='checkbox']");
	By invalidErrorMsg=By.xpath("//div[@id='alert-message']");
	By loginBtn=By.xpath("//button[@id='login-btn']");
	By clearBtn=By.xpath("//button[@id='clear-btn']");
	
public void enterUsername(String username)
{   action.find(usernameInput).clear();
	action.click(usernameInput);
	action.sendText(usernameInput, username);
}

public void enterPassword(String password)
{   action.find(passwordInput).clear();
	action.click(passwordInput);
	action.sendText(passwordInput, password);
}

public void clickOnRememenderMe(boolean status)
{   if(status==true) {
	action.click(rememberChkBox);
}
}

public void clickOnLoginButton()
{   
	action.click(loginBtn);
}

public HomePage login(String username ,String password , boolean rememberChkbox)
{   LogUtility.info("entering the userNmae");
	enterUsername(username);
    Waits.pause(); // giving this static wait to see execution
    LogUtility.info("entering the password");
    enterPassword(password);
    Waits.pause();
    LogUtility.info("Clicking on the Remember Checkbox");
    clickOnRememenderMe(rememberChkbox);
    Waits.pause();
    LogUtility.info("Clicking on the Login button");
    clickOnLoginButton();
    return new HomePage(driver);
}
public boolean alertMsgDisplay()
{    
	return action.isDisplayed(invalidErrorMsg);
}

public boolean usernameReqMsg ()
{    
	return action.isDisplayed(usernameReqMsg);
}

public boolean passwordReqMsg ()
{    
	return action.isDisplayed(passwordReqMsg);
}

}
