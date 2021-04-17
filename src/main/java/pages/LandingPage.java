package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage extends BasePage {

	public WebDriver driver;
	private By signInButton = By.className("login");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}

	public SignInPage clickSignIn() {
		driver.findElement(signInButton).click();
		return new SignInPage(driver);
	}

}
