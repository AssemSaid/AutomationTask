/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignInPage extends BasePage {

	public WebDriver driver;
	private By emailField = By.id("email_create");
	private By createAccountButton = By.id("SubmitCreate");

	private final int MAX_RANDOM_NUMBER = 10000;
	private final int STRING_LENGTH = 10;

	public SignInPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterRadomEmail() {
		waitUnitElementIsVisible(driver, emailField, WAITTIME);
		driver.findElement(emailField).sendKeys(getGeneratedEmail());
	}

	public CreateAccountPage clickCreateAccount() {
		driver.findElement(createAccountButton).click();
		return new CreateAccountPage(driver);
	}

	private String getGeneratedEmail() {

		String randomString = getRandomStringOfCharaters(STRING_LENGTH);
		String radomNumber = Integer.toString(getRandomNumber(MAX_RANDOM_NUMBER));
		String randomEmail = randomString + radomNumber + "@gmail.com";

		return randomEmail;
	}

}
