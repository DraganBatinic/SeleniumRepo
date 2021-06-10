package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthenticationPage;
import pages.MainPage;

public class BaseTests {
	WebDriver driver;
	MainPage mainPage;
	AuthenticationPage authenticationPage;
	ExcelReader excelReader;
	String homeUrl;
	
	@BeforeClass
	public void beforeAllTests() throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver-lib\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mainPage = new MainPage(driver);
		authenticationPage = new AuthenticationPage(driver);
		excelReader = new ExcelReader("data/ProjekatData.xlsx");
		homeUrl = "http://automationpractice.com/";
				
	}
	
	@AfterClass
	public void afterAllTests() {
		driver.close();
	}

}
