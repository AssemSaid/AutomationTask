/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WomenPage extends BasePage {

	public WebDriver driver;
	private By listIcon = By.className("icon-th-list");
	private By productCountLabel = By.className("product-count");
	private By productNameLabel = By.id("layer_cart_product_title");
	private By productPriceLabel = By.id("layer_cart_product_price");
	private By continueShoppingButton = By.xpath("//span[@title='Continue shopping']");
	private By proceedToCheckoutButton = By.xpath("//a[@title='Proceed to checkout']");

	public WomenPage(WebDriver driver) {
		this.driver = driver;
	}

	public void addItemsInStock() {
		clickListIcon();
		numberOfResults = getNumberOfResultsFromText(productCountLabel);

		for (int i = 1; i <= numberOfResults; i++) {
			By addToCart = By.xpath("(//a[@title='Add to cart'])[" + i + "]");
			driver.findElement(addToCart).click();
			waitUnitElementIsVisible(driver, productNameLabel, WAITTIME);
			expectedItemNameList.add(driver.findElement(productNameLabel).getText());

			String priceInString = driver.findElement(productPriceLabel).getText();
			float priceInFloat = Float.parseFloat(priceInString.substring(1));
			expectedItemPriceList.add(priceInFloat);

			if (i == numberOfResults)
				break;
			else
				clickContinueShopping();
		}
	}

	private void clickContinueShopping() {
		driver.findElement(continueShoppingButton).click();
		;
	}

	public CheckoutPage clickCheckout() {
		driver.findElement(proceedToCheckoutButton).click();
		return new CheckoutPage(driver);
	}

	private void clickListIcon() {
		driver.findElement(listIcon).click();

	}

	private int getNumberOfResultsFromText(By locator) {
		String FullText = driver.findElement(locator).getText();

		int i = 0;
		int index = 0;
		boolean flag = false;
		while (flag == false) {
			if (FullText.charAt(i) == 'f') {
				index = i;
				flag = true;
			}
			i++;
		}

		String subString = FullText.substring(index);
		String numberOnly = subString.replaceAll("[^0-9]", "");
		return Integer.parseInt(numberOnly);
	}

}
