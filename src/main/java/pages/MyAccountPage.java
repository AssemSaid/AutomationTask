/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage{

	public WebDriver driver;
	private By womenTab = By.xpath("//a[@title='Women']");

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	public WomenPage clickWomenSection() {
		driver.findElement(womenTab).click();
		
		logs.addLog("Info: Click on (Women) tab");
		
		return new WomenPage(driver);
	}

}
