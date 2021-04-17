package pages;

import java.util.ArrayList;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	public static ArrayList<String> expectedItemNameList = new ArrayList<String>();
	public static ArrayList<Float> expectedItemPriceList = new ArrayList<Float>();
	public static ArrayList<String> actualItemNameList = new ArrayList<String>();
	public static ArrayList<Float> actualItemPriceList = new ArrayList<Float>();
	public static int numberOfResults;
	public final int WAITTIME = 10;
	public WebDriver driver;

	
	public String getRandomStringOfCharaters(int length) {

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			// generate random index number
			int index = random.nextInt(alphabet.length());
			// get character specified by index from the string
			char randomChar = alphabet.charAt(index);
			// append the character to string builder
			sb.append(randomChar);
		}

		return sb.toString();
	}
	
	protected void waitUnitElementIsVisible(WebDriver driver, By locator, int timeInSeconds) {
		this.driver = driver;
		WebDriverWait wait = new WebDriverWait(driver, timeInSeconds);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public int getRandomNumber(int max) {
		Random random = new Random();
		return random.nextInt(max);
	}

}
