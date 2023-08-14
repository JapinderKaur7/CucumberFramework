package driverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	WebDriver driver;
	
	public static ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();
	
	public WebDriver setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver());
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver());
		}
		else
		{
			System.out.println("This is not a correct browser value" +browser);
			System.exit(0);
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return driver;
	}
	
	public static synchronized WebDriver getDriver()
	{
		return tl.get();
	}

}
