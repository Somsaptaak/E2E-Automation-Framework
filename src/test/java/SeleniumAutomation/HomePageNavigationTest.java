package SeleniumAutomation;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.FlightDetailsPage;
import pageObjects.HomePage;
import resources.base;

public class HomePageNavigationTest extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(HomePageNavigationTest.class.getName());

	@BeforeTest
	public void initialization() throws IOException {
		driver = initializeDriver();
		driver.manage().window().maximize();

	}

	@Test
	public void basePageNavigation() throws IOException, InterruptedException {
		driver.get(prop.getProperty("url"));
		log.debug("Goibibo url is accessed");
		HomePage hp = new HomePage(driver);
		hp.getDepartureTab().sendKeys(prop.getProperty("source"));
		WebDriverWait w = new WebDriverWait(driver, 5);
		Thread.sleep(2000);
		hp.getDepartureTab().sendKeys(Keys.ARROW_DOWN);
		hp.getDepartureTab().sendKeys(Keys.ENTER);
		log.debug("Departure City name is given");
		hp.getArrivalTab().sendKeys(prop.getProperty("destination"));
		w.until(ExpectedConditions.presenceOfElementLocated(By.id("react-autosuggest-1")));
		int i = 0;
		while (i < 2) {
			hp.getArrivalTab().sendKeys(Keys.ARROW_UP);
			i++;
		}
		hp.getArrivalTab().sendKeys(Keys.ENTER);
		log.debug("Destination City name is given");
		Thread.sleep(2000);
		hp.getDestinationCalendar().click();
		while (!(hp.getMonthName().getText().equalsIgnoreCase(prop.getProperty("Month")))) {

			hp.getMonthNextButton().click();
		}
		List<WebElement> dates = driver.findElements(By.cssSelector(".DayPicker-Day"));
		int count = dates.size();
		for (int j = 0; j < count; j++) {
			String text = dates.get(j).getText();
			if (text.contains(prop.getProperty("Date"))) {
				dates.get(j).click();
				break;
			}

		}
		log.debug("Journey date is given");
		hp.getSearchButton().click();
		FlightDetailsPage fp= new FlightDetailsPage(driver);
		Assert.assertTrue(fp.getFrom().isDisplayed());
		Assert.assertTrue(fp.getTo().isDisplayed());
		Assert.assertTrue(fp.getStartDate().isDisplayed());
		log.info("Navigation to Flight Details Page is verified");

		
	}

	  @AfterTest public void tearDown() { 
	  driver.quit(); 
	  }
	 
	 

}
