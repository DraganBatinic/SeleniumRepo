package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTests extends BaseTests{
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test
	public void signInButtonTest() {
		mainPage.signInButtonClick();
		
		String actualText = authenticationPage.authenticationHeadingText();
		String textForAssertion = "AUTHENTICATION";
		
		assertEquals(actualText, textForAssertion);
	}
	
	@AfterMethod 
	public void posleSvakogTesta() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
