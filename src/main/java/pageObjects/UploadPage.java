package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractComponent.AbstractComponent;

public class UploadPage extends AbstractComponent{

	private WebDriver driver;
	
	@FindBy(id = "processTask")
	WebElement convertBttn;
	
	@FindBy(xpath = "//div/span[@class='file__info__name']")
	WebElement fileTextName;
	
	
	public UploadPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public DownloadPage uploadedFile()
	{
		waitForElement(convertBttn);
		convertBttn.click();
		DownloadPage downloadPage = new DownloadPage(driver);
		return downloadPage;
	}
	
	public String fileName()
	{
		return fileTextName.getText();
	}
}
