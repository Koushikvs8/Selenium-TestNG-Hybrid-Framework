package com.securebankdemo.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.securebankdemo.Components.GlobalNav;
import com.securebankdemo.Utilities.Waits;
public class DashboardPage extends BasePage {
   
    protected GlobalNav globalNav;
    
    
	public DashboardPage(WebDriver driver) {
		super(driver);
		this.globalNav=new GlobalNav(driver);
		// TODO Auto-generated constructor stub
	}


	
	

	By totalPrice=By.xpath("//div[@id='total-balance']");
	By activeAccount=By.xpath("//div[@id='accounts-count']");
	By transactionCount=By.xpath("//div[@id='transactions-count']"); 
	By addAccountBtn=By.xpath("//a[@data-testid='quick-add-account']"); 
	By newTransactionBtn=By.xpath("//a[@data-testid='quick-new-transaction']");
	By viewAllAccount=By.xpath("//a[@data-testid='quick-view-accounts']");
	
	// Add New Account
	By accountNameBtn=By.xpath("//input[@data-testid='account-name-input']");
	By accountTypeBtn=By.xpath("//button[@id='account-type']");
	By acountOptions=By.xpath("//select[@aria-hidden='true']//option");
	By firstBalance=By.xpath("//input[@data-testid='initial-balance-input']");
	By saveAccountBtn=By.xpath("//button[@data-testid='save-account-button']");
	

	//List Accounts
	By listOfAccount=By.xpath("//div[@id='accounts-list']//div[contains(@data-account-id ,'id_176')]");
	
	public String verifyNavigationtoHomepage()
	{   Waits.pause();
		return action.getUrl();
	}

	public void clickOnAddAcount()
	{   
		action.click(addAccountBtn);
		Waits.pause();
	}
	public void enterAccountName(String accoutName)
	{  
		action.sendText(accountNameBtn, accoutName);
	}
	
	public void selectAccountType(String accountType)
	{    
		action.click(accountTypeBtn);
		Actions actions = new Actions(driver);
		action.click(action.find(By.xpath("//span[text()='"+accountType+"']")));
		
 	     
	}
	
	public void enterInitialDeposite(String amount)
	{  
		action.sendText(firstBalance, amount);
	}
	
	public AccountPage clickOnSaveAccountBtn()
	{  
		action.click(saveAccountBtn);
		return new AccountPage(driver);
	}
	
	public void creatTheAccount(String accountName,String accountType,String amount )
	{   
	    enterAccountName(accountName);
	    Waits.pause();
	    selectAccountType(accountType);
	    Waits.pause();
	    enterInitialDeposite(amount);
	    Waits.pause();
	    clickOnSaveAccountBtn();
	}
	
	public Integer checkNumberExistingAccount( )
	{   List<WebElement> acounts=action.findElements(listOfAccount);
		return acounts.size();    
	}
	

}
