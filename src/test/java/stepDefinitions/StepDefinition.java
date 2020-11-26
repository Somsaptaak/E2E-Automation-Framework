package stepDefinitions;

import org.junit.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.HomePage;
import resources.base;

public class StepDefinition extends base{

	

@Given("^The browser is initialized with chrome$")
public void the_browser_is_initialized_with_chrome() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver = initializeDriver();
	driver.manage().window().maximize();
}

@When("^User navigates to \"([^\"]*)\" site$")
public void user_navigates_to_something_site(String strArg1) throws Throwable {
    driver.get(strArg1);
}

@Then("^Verify display text visible as (.+)$")
public void verify_display_text_visible_as(String expectedvalue) throws Throwable {
	HomePage hp=new HomePage(driver);
	Assert.assertEquals(expectedvalue, hp.getDisplayText().getText());
}


@And("^close browsers$")
public void close_browsers() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	driver.quit();
}
}
