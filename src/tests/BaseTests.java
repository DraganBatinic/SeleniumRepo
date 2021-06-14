package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.MainPage;
import pages.MyAccountPage;
import pages.MyAddressesPage;
import pages.MyWishlistPage;
import pages.ShoppingAddressesPage;
import pages.ShoppingCartSummaryPage;
import pages.YourAddressesPage;
import pages.YourPersonalInformationPage;

public class BaseTests {
	WebDriver driver;
	MainPage mainPage;
	AuthenticationPage authenticationPage;
	CreateAnAccountPage createAnAccountPage;
	MyAccountPage myAccountPage;
	MyAddressesPage myAddressesPage;
	YourAddressesPage yourAddressesPage;
	YourPersonalInformationPage yourPersonalInformationPage;
	MyWishlistPage myWishlistPage;
	ShoppingCartSummaryPage shoppingCartSummaryPage;
	ShoppingAddressesPage shoppingAddressesPage;
	ExcelReader excelReader;
	JavascriptExecutor js;
	String homeUrl;
	
	
	@BeforeClass
	public void beforeAllTests() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		mainPage = new MainPage(driver);
		authenticationPage = new AuthenticationPage(driver);
		createAnAccountPage = new CreateAnAccountPage(driver);
		myAccountPage = new MyAccountPage(driver);
		myAddressesPage = new MyAddressesPage(driver);
		yourAddressesPage = new YourAddressesPage(driver);
		yourPersonalInformationPage = new YourPersonalInformationPage(driver);
		myWishlistPage = new MyWishlistPage(driver);
		shoppingCartSummaryPage = new ShoppingCartSummaryPage(driver);
		shoppingAddressesPage = new ShoppingAddressesPage(driver);
		js = (JavascriptExecutor) driver;
		excelReader = new ExcelReader("data/ProjekatData.xlsx");
		homeUrl = "http://automationpractice.com/";
				
	}
	
	@AfterClass
	public void afterAllTests() {
		driver.close();
	}

}
