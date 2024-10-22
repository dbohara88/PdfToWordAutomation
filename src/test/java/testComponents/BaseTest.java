package testComponents;

import org.testng.annotations.AfterMethod;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeMethod;
import pageObjects.LandingPage;

public class BaseTest {
	
	public WebDriver driver;
	private Properties prop;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/GlobalData.properties";
		FileInputStream fis = new FileInputStream(filePath);
		
		prop.load(fis);
		
		String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		if(browserName.contains("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if(browserName.contains("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(browserName.contains("edge"))
		{
			driver = new EdgeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}
	
	
	
	public String getScreenshot(WebDriver driver, String testCaseName)
	{
        String screenshotPath = null;

        try {

            //take screenshot and save it in a file

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //copy the file to the required path

            File destinationFile = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");

            FileHandler.copy(sourceFile, destinationFile);

            String[] relativePath = destinationFile.toString().split("reports");

            screenshotPath = ".\\" + relativePath[1];

        } catch (Exception e) {

            System.out.println("Failure to take screenshot " + e);

        }

        return screenshotPath;
	}
	
	@BeforeMethod(alwaysRun = true)
	public LandingPage loginApp() throws IOException
	{
		driver = initializeDriver();
		landingPage = new LandingPage(driver);
		landingPage.url();
		return landingPage;
	}
	
	@AfterMethod(alwaysRun = true)
	public void tearDown()
	{
		driver.quit();
	}
}
