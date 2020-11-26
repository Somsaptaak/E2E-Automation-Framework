package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;



public class FlightDetailsPage {

	
	
	private WebDriver driver;

	public FlightDetailsPage(WebDriver driver) {
		this .driver=driver;
	}

	By from= By.xpath("//input[@id='gi_source_st_srp']");
	By to= By.xpath("//input[@id='gi_destination_st_srp']");
	By startDate=By.xpath("//input[@id='start-date_srp']");
	
	public WebElement getFrom(){
		return driver.findElement(from);
	}
	
	public WebElement getTo(){
		return driver.findElement(to);
	}
	
	public WebElement getStartDate(){
		return driver.findElement(startDate);
	}
}
