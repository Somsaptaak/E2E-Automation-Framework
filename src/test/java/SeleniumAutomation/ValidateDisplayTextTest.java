package SeleniumAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.junit.Assert;
import pageObjects.HomePage;
import resources.base;



public class ValidateDisplayTextTest extends base{
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateDisplayTextTest.class.getName());
	@BeforeTest
	public void initialization() throws IOException{
	driver = initializeDriver();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	log.debug("Goibibo url is accessed");
}
	
	@Test
	public void validateDisplayText() throws IOException
	{
		
		HomePage hp=new HomePage(driver);
		Assert.assertEquals("Domestic And International Flights", hp.getDisplayText().getText());
		log.info ("The Display Text is compared");
		
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
