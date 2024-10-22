package abstractComponent;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponent {
	
	private WebDriver driver;
	WebDriverWait w1 = new WebDriverWait(driver, Duration.ofSeconds(5));
	public AbstractComponent(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitForElement(WebElement element)
	{
		w1.until(ExpectedConditions.visibilityOf(element));
	}
}
