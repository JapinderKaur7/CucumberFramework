package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import dataProvider.configFileReader;
import driverManager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	private DriverManager dm;
	private WebDriver driver;
	configFileReader file;
	Properties prop;
	
	@Before
	public void launch()
	{
		file= new configFileReader();
		prop= file.propfile();
		dm= new DriverManager();
		dm.setup("chrome");
		driver=DriverManager.getDriver();
		driver.get(prop.getProperty("url"));
	}

	@After
	public void teardown()
	{
		driver.quit();
	}
}
