/**
 *@author: assem.said2010@gmail.com
 *@Date: 17/4/2021
 */
package stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import pages.CheckoutPage;
import pages.CreateAccountPage;
import pages.LandingPage;
import pages.MyAccountPage;
import pages.SignInPage;
import pages.WomenPage;

public class TestBase {
	private String browser;
	private String platform;
	private String browserKey;
	private String browserPath;

	protected WebDriver driver;
	protected static LandingPage landingPage;
	protected static SignInPage signInPage;
	protected static CreateAccountPage createAccountPage;
	protected static MyAccountPage myAccountPage;
	protected static WomenPage womenPage;
	protected static CheckoutPage checkoutPage;

	public void startUp(String browserName, String platformName) {

		setBrowserNameAndKey(browserName);
		setPlatformNameAndBrowserPath(platformName);

		System.setProperty(browserKey, browserPath);
		if (browser.equalsIgnoreCase("Chrome"))
			driver = new ChromeDriver();
		else if (browser.equalsIgnoreCase("Firefox"))
			driver = new FirefoxDriver();
		else
			driver = new InternetExplorerDriver();
		
		driver.manage().window().maximize();
	}

	public void tearDown() {
		driver.close();
	}

	private boolean setBrowserNameAndKey(String browserName) {
		String chromeBrowser = "Chrome";
		String firefoxBrowser = "Firefox";
		String explorerBrowser = "IE";
		if (chromeBrowser.equalsIgnoreCase(browserName)) {
			browser = chromeBrowser;
			browserKey = "webdriver.chrome.driver";
			return true;
		} else if (firefoxBrowser.equalsIgnoreCase(browserName)) {
			browser = firefoxBrowser;
			browserKey = "webdriver. gecko. driver";
			return true;
		} else if (explorerBrowser.equalsIgnoreCase(browserName)) {
			browser = explorerBrowser;
			browserKey = "webdriver.ie.driver";
			return true;
		} else {
			System.out
					.println("Browser:" + browserName + " is not correct. Browser can only be Chrome or Firefox or IE");
			return false;
		}
	}

	private boolean setPlatformNameAndBrowserPath(String platfromName) {
		String windowsPlatform = "Windows";
		String macPlatform = "Mac";
		String linuxPlatform = "Linux";

		if (windowsPlatform.equalsIgnoreCase(platfromName)) {
			platform = windowsPlatform;
			setBrowserPath();
			return true;
		} else if (macPlatform.equalsIgnoreCase(platfromName)) {
			platform = macPlatform;
			setBrowserPath();
			return true;
		} else if (linuxPlatform.equalsIgnoreCase(platfromName)) {
			platform = linuxPlatform;
			setBrowserPath();
			return true;
		} else {
			System.out.println(
					"Plaform:" + platfromName + " is not correct. Platform can only be Windows or Mac or Linux");
			return false;
		}
	}

	private void setBrowserPath() {
		if (platform.equalsIgnoreCase("Windows")) {
			if (browser.equalsIgnoreCase("Chrome"))
				browserPath = "resources/Windows/chromedriver.exe";
			else if (browser.equalsIgnoreCase("Firefox"))
				browserPath = "resources/Windows/geckodriver.exe";
			else
				browserPath = "resources/Windows/IEDriverServer.exe";
		} else if (platform.equalsIgnoreCase("Mac")) {
			if (browser.equalsIgnoreCase("Chrome"))
				browserPath = "resources/Mac/chromedriver";
			else if (browser.equalsIgnoreCase("Firefox"))
				browserPath = "resources/Mac/geckodriver";
			else
				browserPath = "resources/Mac/IEDriverServer.exe";
		} else {
			if (browser.equalsIgnoreCase("Chrome"))
				browserPath = "resources/Linux/chromedriver";
			else if (browser.equalsIgnoreCase("Firefox"))
				browserPath = "resources/Linux/geckodriver";
			else
				browserPath = "resources/Linux/IEDriverServer.exe";
		}
	}

}
