/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

	public WebDriver driver;
	private By orderButton = By.id("order");

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	public boolean compareItemNamesAndPrices() {
		fillActualItemNamesAndPriceLists();

		if (expectedItemNameList.equals(actualItemNameList) && expectedItemPriceList.equals(actualItemPriceList))
			return true;
		else
			return false;
	}

	private void fillActualItemNamesAndPriceLists() {
		waitUnitElementIsVisible(driver, orderButton, WAITTIME);

		for (int i = 1; i <= numberOfResults; i++) {
			By itemName = By.xpath("(//td[@class='cart_description']/p/a)[" + i + "]");
			actualItemNameList.add(driver.findElement(itemName).getText());

			By productPriceLabel = By.xpath("(//td[@class='cart_total']/span[@class='price'])[" + i + "]");
			String priceInString = driver.findElement(productPriceLabel).getText();
			float priceInFloat = Float.parseFloat(priceInString.substring(1));
			actualItemPriceList.add(priceInFloat);
		}
	}

}
