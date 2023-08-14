package dataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configFileReader {
	
	private Properties prop;
	public Properties propfile()
	{
		prop= new Properties();
		try
		{
			FileInputStream file= new FileInputStream("C:\\Automation\\Workspace\\CucumberFramework\\configs\\Configuration.properties");
			prop.load(file);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
		
	}
	
	public String getTestDataResourcePath()
	{
		String testDataResourcePath= prop.getProperty("testDataResourcePath");
		return testDataResourcePath;
		
	}

}
