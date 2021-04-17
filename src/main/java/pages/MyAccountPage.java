package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {

	public WebDriver driver;
	private By womenTab = By.xpath("//a[@title='Women']");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WomenPage clickWomenSection() {
		driver.findElement(womenTab).click();
		return new WomenPage(driver);
	}

}
