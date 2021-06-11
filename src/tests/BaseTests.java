package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthenticationPage;
import pages.CreateAnAccountPage;
import pages.MainPage;
import pages.MyAccountPage;

public class BaseTests {
	WebDriver driver;
	MainPage mainPage;
	AuthenticationPage authenticationPage;
	CreateAnAccountPage createAnAccountPage;
	MyAccountPage myAccountPage;
	ExcelReader excelReader;
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
		excelReader = new ExcelReader("data/ProjekatData.xlsx");
		homeUrl = "http://automationpractice.com/";
				
	}
	
	@AfterClass
	public void afterAllTests() {
		driver.close();
	}

}
