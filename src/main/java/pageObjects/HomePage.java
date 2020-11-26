package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	By from = By.xpath("//input[@placeholder='From']");
	By destination = By.xpath("//input[@placeholder='Destination']");
	By monthName = By.xpath("//div[@class='DayPicker-Month']/div[1]");
	By destinationCalendar = By.xpath("//input[@id='departureCalendar']");
	By monthNextButton = By.cssSelector("span[class*='next']");
	By dropDown = By.id("react-autosuggest-1");
	By dateSelector = By.cssSelector(".DayPicker-Day");
	By searchButton=By.xpath("//button[text()='SEARCH']");
	By displayText=By.xpath("//h1[text()='Domestic and International Flights']");
	By login=By.linkText("Sign In");
	By mobileInput=By.id("authMobile");
	By mobileSubmit=By.id("mobileSubmitBtn");
	By otpInput1=By.id("otp_index0");
	By otpInput2=By.id("otp_index1");
	By otpInput3=By.id("otp_index2");
	By otpInput4=By.id("otp_index3");
	By otpSubmit=By.id("authOtpSubmitBtn");
	By otpErrorMssg=By.id("submitOtpErrorMsg");

	public WebElement getDepartureTab() {
		return driver.findElement(from);
	}

	public WebElement getArrivalTab() {
		return driver.findElement(destination);
	}

	public WebElement getMonthName() {
		return driver.findElement(monthName);
	}

	public WebElement getMonthNextButton() {
		return driver.findElement(monthNextButton);
	}

	public WebElement getDropdown() {
		return driver.findElement(dropDown);
	}

	public WebElement getDestinationCalendar() {
		return driver.findElement(destinationCalendar);
	}

	public List<WebElement> getDateSelector() {
		return driver.findElements(destinationCalendar);
	}
	public WebElement getSearchButton() {
		return driver.findElement(searchButton);
	}
	public WebElement getDisplayText() {
		return driver.findElement(displayText);
	}
	public WebElement getSignIn() {
		return driver.findElement(login);
	}
	public WebElement getMobileInput() {
		return driver.findElement(mobileInput);
	}

	public WebElement getMobileSubmit() {
		return driver.findElement(mobileSubmit);
	}
	public WebElement getOtpInput1() {
		return driver.findElement(otpInput1);
	}
	
	public WebElement getOtpInput2() {
		return driver.findElement(otpInput2);
	}
	
	public WebElement getOtpInput3() {
		return driver.findElement(otpInput3);
	}
	
	public WebElement getOtpInput4() {
		return driver.findElement(otpInput4);
	}

	public WebElement getOtpSubmit() {
		return driver.findElement(otpSubmit);
		
	}
	
	public WebElement getOtpSubmitErrorMssg() {
		return driver.findElement(otpErrorMssg);
		
	}

}

