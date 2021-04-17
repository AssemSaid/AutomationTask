/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package pages;

import java.security.SecureRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
		
		logs.addLog("Info: Click on (Submit) button");
		
		return new MyAccountPage(driver);
	}

	private void setTitle() {
		waitUnitElementIsVisible(driver, mrsGenederRadioButton, WAITTIME);
		driver.findElement(mrsGenederRadioButton).click();
		
		logs.addLog("Info: Set Title - Click on (MRs) radio button");
	}

	private void setFirstName() {
		String firstName = getRandomStringOfCharaters(NAME_STRING_LENGTH);
		driver.findElement(firstNameField).sendKeys(firstName);
		
		logs.addLog("Info: Set First Name - An autogenerated First Name: ("+firstName+") is added");
	}

	private void setLastName() {
		String lastName = getRandomStringOfCharaters(NAME_STRING_LENGTH);
		driver.findElement(lastNameField).sendKeys(lastName);
		
		logs.addLog("Info: Set Last Name - An autogenerated Last Name: ("+lastName+") is added");
	}

	private void setPassword() {
		String password=generateRandomPassword(MAX_PASSWORD_LENGTH);
		driver.findElement(passwordField).sendKeys(password);
		
		logs.addLog("Info: Set Password - An autogenerated Password: ("+password+") is added");
	}

	private void setAddress() {
		String address=getRandomStringOfCharaters(ADDRESS_STRING_LENGTH) + " Street";
		driver.findElement(addressField).sendKeys(address);
		
		logs.addLog("Info: Set Address - An autogenerated address: ("+address+") is added");
	}

	private void setCity() {
		String city=getRandomStringOfCharaters(CITY_STRING_LENGTH);
		driver.findElement(cityField).sendKeys(city);
		
		logs.addLog("Info: Set City - An autogenerated city: ("+city+") is added");
	}

	private void setState(String State) {
		Select drpState = new Select(driver.findElement(stateDropDown));
		drpState.selectByVisibleText(State);
		
		logs.addLog("Info: Set State - State: ("+State+") is selected");
	}

	private void setPostalCode() {
		String postCode=generatePostCode();
		driver.findElement(postCodeField).sendKeys(postCode);
		
		logs.addLog("Info: Set PostCode - An autogenerated postcode: ("+postCode+") is added");
	}

	private void setMobilePhone() {
		String mobilePhone = Integer.toString(getRandomNumber(100));
		driver.findElement(mobileField).sendKeys(mobilePhone);
		
		logs.addLog("Info: Set Mobile Phone - An autogenerated mobile-phone: ("+mobilePhone+") is added. Mobile Phone field takes any integer, so it doesn't have to be a real phone number, just a random integer");
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
