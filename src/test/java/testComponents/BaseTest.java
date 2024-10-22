package testComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	
	public WebDriver driver;
	private Properties prop;
	
	public void initializeDriver() throws IOException
	{
		prop = new Properties();
		
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/GlobalData.properties";
		FileInputStream fis = new FileInputStream(filePath);
		
		prop.load(fis);
		
		String browserName = prop.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
	}
}
