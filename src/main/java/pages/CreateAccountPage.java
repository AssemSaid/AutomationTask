package pages;

import java.security.SecureRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAccountPage extends BasePage {

	public WebDriver driver;
	private By mrsGenederRadioButton = By.id("id_gender2");
	private By firstNameField = By.id("customer_firstname");
	private By lastNameField = By.id("customer_lastname");
	private By passwordField = By.id("passwd");
	private By addressField = By.id("address1");
	private By cityField = By.id("city");
	private By stateDropDown = By.id("id_state");
	private By mobileField = By.id("phone_mobile");
	private By postCodeField = By.id("postcode");
	private By submitButton = By.id("submitAccount");

	private final int NAME_STRING_LENGTH = 5;
	private final int ADDRESS_STRING_LENGTH = 10;
	private final int MAX_PASSWORD_LENGTH = 10;
	private final int CITY_STRING_LENGTH = 6;
	private final String STATE = "Florida";

	public CreateAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public void fillMandatoryFields() {
		setTitle();
		setFirstName();
		setLastName();
		setPassword();
		setAddress();
		setCity();
		setState(STATE);
		setPostalCode();
		setMobilePhone();
	}

	public MyAccountPage clickSubmit() {
		driver.findElement(submitButton).click();
		return new MyAccountPage(driver);
	}
	
	private void setTitle() {
		waitUnitElementIsVisible(driver, mrsGenederRadioButton, WAITTIME);
		driver.findElement(mrsGenederRadioButton).click();
	}

	private void setFirstName() {
		driver.findElement(firstNameField).sendKeys(getRandomStringOfCharaters(NAME_STRING_LENGTH));
	}

	private void setLastName() {
		driver.findElement(lastNameField).sendKeys(getRandomStringOfCharaters(NAME_STRING_LENGTH));
	}

	private void setPassword() {
		driver.findElement(passwordField).sendKeys(generateRandomPassword(MAX_PASSWORD_LENGTH));
	}

	private void setAddress() {
		driver.findElement(addressField).sendKeys(getRandomStringOfCharaters(ADDRESS_STRING_LENGTH));
	}

	private void setCity() {
		driver.findElement(cityField).sendKeys(getRandomStringOfCharaters(CITY_STRING_LENGTH));
	}

	private void setState(String State) {
		Select drpState = new Select(driver.findElement(stateDropDown));
		drpState.selectByVisibleText(State);
	}

	private void setPostalCode() {
		driver.findElement(postCodeField).sendKeys(generatePostCode());
	}

	private void setMobilePhone() {
		driver.findElement(mobileField).sendKeys(Integer.toString(getRandomNumber(100)));
	}

	private String generateRandomPassword(int length) {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < length; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}

		return sb.toString();
	}

	private String generatePostCode() {
		String code = Integer.toString(getRandomNumber(9));
		code = code + Integer.toString(getRandomNumber(9));
		code = code + Integer.toString(getRandomNumber(9));
		code = code + Integer.toString(getRandomNumber(9));
		code = code + Integer.toString(getRandomNumber(9));

		return code;
	}

}
