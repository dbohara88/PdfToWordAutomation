package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.DownloadPage;
import pageObjects.UploadPage;
import testComponents.BaseTest;

public class EndToEndTest extends BaseTest{
	
	@Test
	public void test()
	{
		UploadPage uploadPage = landingPage.uploadFile();
		Assert.assertEquals(uploadPage.fileName(), "sample.pdf");
		
		DownloadPage downloadPage = uploadPage.uploadedFile();
		Assert.assertEquals(downloadPage.downloadSuccessText(), "Your PDF has been converted to an editable WORD document");
		
	}
}
