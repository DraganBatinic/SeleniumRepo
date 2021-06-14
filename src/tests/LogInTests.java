package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class LogInTests extends BaseTests{
		
	@BeforeMethod
	public void beforeEveryTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 0)
	public void logInWithValidCredentials() {
		
		String email = excelReader.getStringData("TCLogIn1", 10, 2);		
		String password = excelReader.getStringData("TCLogIn1", 12, 2);
		this.logInFormFilling(email, password);
		
		String actualText = myAccountPage.myAccountHeadingText();
		String textForAssertion = "MY ACCOUNT";
		
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 3)
	public void logInWithInvalidCredentials() {
		
		for (int i = 2; i <=3; i++) {
			String email = excelReader.getStringData("TCLogIn2", 10, i);		
			String password = excelReader.getStringData("TCLogIn2", 12, i);
			this.logInFormFilling(email, password);
			
			String actualText = authenticationPage.signInButtonText();		
			String textForAssertion = "Sign in";
			
			assertEquals(actualText, textForAssertion);
		}		
		
	}
	
	@Test (priority = 6)
	public void loginWithEmptyCredentials() {
		
		mainPage.signInButtonClick();
		authenticationPage.signInButtonClick();
				
		String actualText = authenticationPage.signInButtonText();		
		String textForAssertion = "Sign in";
			
		assertEquals(actualText, textForAssertion);		
	}
	
	@Test (priority = 9)
	public void logOut() {
		
		this.logInWithValidCredentials();
		myAccountPage.signOutButtonClick();
				
		String actualText = authenticationPage.signInButtonText();		
		String textForAssertion = "Sign in";
			
		assertEquals(actualText, textForAssertion);		
	}
	
	
	public void logInFormFilling(String email, String password) {
		mainPage.signInButtonClick();
		authenticationPage.enterLogInEmail(email);
		authenticationPage.enterLogInPassword(password);	
		authenticationPage.signInButtonClick();
	}
	
	@AfterMethod 
	public void afterEveryTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
