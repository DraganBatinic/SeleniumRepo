package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.CreateAnAccountPage;
import pages.MyAccountPage;

public class RegistrationTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest() {
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
	public void usingValidEmailForRegistration() throws InterruptedException {				
		String email = excelReader.getStringData("TCReg2", 8, 2);
		this.registerFormFilling(email);
				
		String actualText = createAnAccountPage.createAnAccountHeadingText();
		String textForAssertion = "CREATE AN ACCOUNT";
		
		assertEquals(actualText, textForAssertion);
		
	}
	
	@Test (priority = 6)
	public void usingInvalidEmailForRegistration() throws InterruptedException {				
		String email = excelReader.getStringData("TCReg3", 8, 2);
		this.registerFormFilling(email);			
		
		String actualText = authenticationPage.createAnAccountErrorMessageText();
		String textForAssertion = "Invalid email address.";
		
		assertEquals(actualText, textForAssertion);
		
		driver.navigate().refresh();
		
		this.signInButtonTest();			
		authenticationPage.createAnAccountButtonClick();		
		
		actualText = authenticationPage.createAnAccountErrorMessageText();
		textForAssertion = "Invalid email address.";
		
		assertEquals(actualText, textForAssertion);
		
	}
	
	@Test (priority = 9)
	public void registrationWithValidEmail() throws InterruptedException {
		this.usingValidEmailForRegistration();
		
		createAnAccountPage.titleMrRadioButtonClick();
		
		String firstName = excelReader.getStringData("TCReg4", 9, 2);
		createAnAccountPage.getFirstName().clear();
		createAnAccountPage.enterFirstName(firstName);
		
		String lastName = excelReader.getStringData("TCReg4", 10, 2);
		createAnAccountPage.getLastName().clear();
		createAnAccountPage.enterLastName(lastName);
		
		String email = excelReader.getStringData("TCReg4", 11, 2);
		createAnAccountPage.getEmail().clear();
		createAnAccountPage.enterEmail(email);		
		
		String password = excelReader.getStringData("TCReg4", 12, 2);
		createAnAccountPage.getPassword().clear();
		createAnAccountPage.enterPassword(password);
		
		createAnAccountPage.dayOfBirthDropdownMenuClick();		
		createAnAccountPage.getDayOfBirthDropdownMenu().sendKeys(Keys.ARROW_DOWN);
		createAnAccountPage.getDayOfBirthDropdownMenu().sendKeys(Keys.ENTER);
		
		createAnAccountPage.monthOfBirthDropdownMenuClick();		
		createAnAccountPage.getMonthOfBirthDropdownMenu().sendKeys(Keys.ARROW_DOWN);
		createAnAccountPage.getMonthOfBirthDropdownMenu().sendKeys(Keys.ENTER);
		
		createAnAccountPage.yearOfBirthDropdownMenuClick();		
		for (int i = 0; i <= 11; i++) {
			createAnAccountPage.getYearOfBirthDropdownMenu().sendKeys(Keys.ARROW_DOWN);
		}
		createAnAccountPage.getYearOfBirthDropdownMenu().sendKeys(Keys.ENTER);
		
		String yourAddressFirstName = excelReader.getStringData("TCReg4", 16, 2);
		createAnAccountPage.getYourAddressFirstName().clear();
		createAnAccountPage.enterYourAddressFirstName(yourAddressFirstName);
		
		String yourAddressLastName = excelReader.getStringData("TCReg4", 17, 2);
		createAnAccountPage.getYourAddressLastName().clear();
		createAnAccountPage.enterYourAddressLastNameText(yourAddressLastName);
		
		String address = excelReader.getStringData("TCReg4", 18, 2);
		createAnAccountPage.getAddress().clear();
		createAnAccountPage.enterAddress(address);
		
		String city = excelReader.getStringData("TCReg4", 19, 2);
		createAnAccountPage.getCity().clear();
		createAnAccountPage.enterCity(city);
		
		createAnAccountPage.stateDropdownMenuClick();
		for (int i = 0; i < 22; i++) {
			createAnAccountPage.getStateDropdownMenu().sendKeys(Keys.ARROW_DOWN);
		}
		createAnAccountPage.getStateDropdownMenu().sendKeys(Keys.ENTER);
		
		String postalCode = excelReader.getStringData("TCReg4", 21, 2);
		createAnAccountPage.getPostalCode().clear();
		createAnAccountPage.enterPostalCode(postalCode);	
		
		String mobilePhone = excelReader.getStringData("TCReg4", 22, 2);
		createAnAccountPage.getMobilePhone().clear();
		createAnAccountPage.enterMobilePhone(mobilePhone);	
		
		String alias = excelReader.getStringData("TCReg4", 23, 2);
		createAnAccountPage.getAddressAlias().clear();
		createAnAccountPage.enterAddressAlias(alias);	
		
		createAnAccountPage.registerButtonClick();
		
		String actualText = myAccountPage.myAccountHeadingText();
		String textForAssertion = "MY ACCOUNT";
		
		assertEquals(actualText, textForAssertion);		
		
	}
	
	@Test (priority = 12)
	public void registartionWithAlreadyUsedEmail() {
				
		String email = excelReader.getStringData("TCReg5", 9, 2);
		this.registerFormFilling(email);			
		
		String actualText = authenticationPage.createAnAccountErrorMessageText();
		String textForAssertion = "Invalid email address.";
		
		assertEquals(actualText, textForAssertion);
				
	}
	
	public void registerFormFilling(String email) {
		this.signInButtonTest();		
		authenticationPage.getEmailAddressField().clear();
		authenticationPage.enterEmailAddress(email);
		authenticationPage.createAnAccountButtonClick();
	}
	
	@AfterMethod 
	public void afterEveryTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
