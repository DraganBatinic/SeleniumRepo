package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;

public class RegistrationTests extends BaseTests{
	
	@BeforeMethod
	public void preSvakogTesta() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 0)
	public void signInButtonTest() {
		mainPage.signInButtonClick();
		
		String actualText = authenticationPage.authenticationHeadingText();
		String textForAssertion = "AUTHENTICATION";
		
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 3)
	public void registrationWithValidEmail() throws InterruptedException {
		this.signInButtonTest();		
		String username = excelReader.getStringData("TCReg2", 8, 2);
		authenticationPage.enterEmailAddress(username);
		authenticationPage.createAnAccountButtonClick();
		Thread.sleep(3000);
		
		String actualText = authenticationPage.creataAccountErrorMessageText();
		String textForAssertion = "Invalid email address.";
		
		assertEquals(actualText, textForAssertion);
		
		driver.navigate().refresh();
		
		username = excelReader.getStringData("TCReg2", 11, 2);
		authenticationPage.enterEmailAddress(username);
		authenticationPage.createAnAccountButtonClick();
		Thread.sleep(3000);
		
		actualText = createAnAccountPage.createAnAccountHeadingText();
		textForAssertion = "CREATE AN ACCOUNT";
		
		assertEquals(actualText, textForAssertion);
		
	}
	
	@AfterMethod 
	public void posleSvakogTesta() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
