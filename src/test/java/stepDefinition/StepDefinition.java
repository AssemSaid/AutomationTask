/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package stepDefinition;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.LandingPage;

public class StepDefinition extends TestBase {

	@Given("^User is on Landing page using \"([^\"]*)\" browser on \"([^\"]*)\" platform$")
	public void user_is_on_landing_page_using_something_browser_on_something_platform(String browserName,
			String platformName) {
		String landingPageURL = "http://automationpractice.com/index.php";
		startUp(browserName, platformName);
		driver.get(landingPageURL);
	}

	@When("^User creates an account$")
	public void user_creates_an_account() {
		landingPage = new LandingPage(driver);
		signInPage = landingPage.clickSignIn();
		signInPage.enterRadomEmail();
		createAccountPage = signInPage.clickCreateAccount();
		createAccountPage.fillMandatoryFields();
		myAccountPage = createAccountPage.clickSubmit();
	}

	@Then("^check Cart has correct items and amount$")
	public void check_cart_has_correct_items_and_amount() {
		Assert.assertTrue(checkoutPage.compareItemNamesAndPrices());
		tearDown();
	}

	@And("^User navigates to Women section$")
	public void user_navigates_to_women_section() {
		womenPage = myAccountPage.clickWomenSection();
	}

	@And("^User adds items to Cart$")
	public void user_adds_items_to_cart() {
		womenPage.addItemsInStock();
		checkoutPage = womenPage.clickCheckout();
	}

}
