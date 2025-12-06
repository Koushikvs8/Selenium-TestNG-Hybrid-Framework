package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.securebankdemo.Utilities.LogUtility;

public class DriverManager 
{
private DriverManager() {}

private static final ThreadLocal<WebDriver> tdriver= new ThreadLocal<>();

public static WebDriver getDriver()
{
	return  tdriver.get();
}



public static void initDriver(String browser)
{   
	 if(getDriver()!=null)
	 {
		 return;
	 }
if(browser.equalsIgnoreCase("chrome"))
{   LogUtility.info("The driver is initialized with Chrome");
	WebDriver driver=new ChromeDriver(); 
	tdriver.set(driver);
}
else if(browser.equalsIgnoreCase("firefox"))
		{
	LogUtility.info("The driver is initialized with firefox");
	WebDriver driver=new FirefoxDriver() ;
	tdriver.set(driver);
		}
else if(browser.equalsIgnoreCase("Edge")) {
	LogUtility.info("The driver is initialized with Edge");
	WebDriver driver=new EdgeDriver();
			tdriver.set(driver);
}
	
	
}
public static void quiteDriver()
{
	if(getDriver()!=null)
	{
		getDriver().quit();
		tdriver.remove();
	}
	

}





}
