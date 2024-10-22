package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponent.AbstractComponent;

public class LandingPage extends AbstractComponent{

	private WebDriver driver;
	
	@FindBy(xpath = "//input[@type=\"file\"]")
	WebElement selectFile;
	
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void url()
	{
		driver.get("https://www.ilovepdf.com/pdf_to_word");
	}
	
	public UploadPage uploadFile()
	{
		selectFile.sendKeys("/Users/dr00821065/Desktop/sample.pdf");
		UploadPage uploadPage = new UploadPage(driver);
		return uploadPage;
	}
	
}
