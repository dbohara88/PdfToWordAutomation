package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import abstractComponent.AbstractComponent;

public class DownloadPage extends AbstractComponent{

	public WebDriver driver;
	
	@FindBy(xpath = "//h1[@class='title2']")
	WebElement downloadText;
	
	@FindBy(xpath = "//div/a[@id='pickfiles']")
	WebElement downloadBttn;
	
	public DownloadPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void downloadFile()
	{
		downloadBttn.click();
	}
	
	public String downloadSuccessText()
	{
		System.out.println(downloadText.getText());
		return downloadText.getText();
	}
	
	
}
