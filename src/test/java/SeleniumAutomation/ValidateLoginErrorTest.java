package SeleniumAutomation;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.junit.Assert;
import pageObjects.HomePage;
import resources.base;



public class ValidateLoginErrorTest extends base{
	
	public WebDriver driver;
	public static Logger log =LogManager.getLogger(ValidateLoginErrorTest.class.getName());
	@BeforeTest
	public void initialization() throws IOException{
	driver = initializeDriver();
	driver.manage().window().maximize();
	driver.get(prop.getProperty("url"));
	log.debug("Goibibo url is accessed");
}
	
	@Test
	public void validateLoginError() throws InterruptedException
	{
		
		HomePage hp=new HomePage(driver);
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		hp.getSignIn().click();
		log.debug("Sign in button is clicked");
		driver.switchTo().frame("authiframe");
		hp.getMobileInput().sendKeys("6291376100");
		log.debug("Mobile Number is given");
		hp.getMobileSubmit().click();
		log.debug("Submit button is clicked");
		Thread.sleep((2000));
		hp.getOtpInput1().sendKeys("a");
		hp.getOtpInput2().sendKeys("b");
		hp.getOtpInput3().sendKeys("c");
		hp.getOtpInput4().sendKeys("d");
		log.debug("Wrong OTP is submitted");
		hp.getOtpSubmit().click();
		Thread.sleep((2000));
		System.out.println(hp.getOtpSubmitErrorMssg().getText());
		Assert.assertEquals("OTP is wrong/expired. Please enter correct OTP.", hp.getOtpSubmitErrorMssg().getText());
		log.info ("OTP Error Message compared");
	}

	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
