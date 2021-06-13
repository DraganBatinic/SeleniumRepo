package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyPersonalInfoEditTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
		
		mainPage.signInButtonClick();
		String email = excelReader.getStringData("TCLogIn2", 10, 2);		
		String password = excelReader.getStringData("TCLogIn2", 12, 3);		
		authenticationPage.enterLogInEmail(email);
		authenticationPage.enterLogInPassword(password);	
		authenticationPage.signInButtonClick();
		
		myAccountPage.myPersonalInformationTabClick();
		
	}
	
	@Test (priority = 0)
	public void updatePersonalInformation() {
		yourPersonalInformationPage.titleMrsRadioButtonClick();
		
		String actualFirstName = yourPersonalInformationPage.getFirstName().getAttribute("value");
		yourPersonalInformationPage.getFirstName().clear();
		String firstName = excelReader.getStringData("TCMA4", 13, 2);
		yourPersonalInformationPage.enterFirstname(firstName);
		
		String actualLastName = yourPersonalInformationPage.getLastName().getAttribute("value");
		yourPersonalInformationPage.getLastName().clear();
		String lastName = excelReader.getStringData("TCMA4", 16, 2);
		yourPersonalInformationPage.enterLastname(lastName);
		
		yourPersonalInformationPage.dayOfBirthClick();
		yourPersonalInformationPage.getDayOfBirth().sendKeys(Keys.ARROW_DOWN);
		yourPersonalInformationPage.getDayOfBirth().sendKeys(Keys.ENTER);
		
		yourPersonalInformationPage.monthOfBirthClick();
		yourPersonalInformationPage.getMonthOfBirth().sendKeys(Keys.ARROW_DOWN);
		yourPersonalInformationPage.getMonthOfBirth().sendKeys(Keys.ENTER);
		
		yourPersonalInformationPage.yearOfBirthClick();
		yourPersonalInformationPage.getYearOfBirth().sendKeys(Keys.ARROW_DOWN);
		yourPersonalInformationPage.getYearOfBirth().sendKeys(Keys.ENTER);
		
		String password = excelReader.getStringData("TCMA4", 24, 2);
		yourPersonalInformationPage.enterPassword(password);
		
		yourPersonalInformationPage.saveButtonClick();
		
		String textFromConfirmationMessage = yourPersonalInformationPage.updateInfoMessageText();
		String textForAssertion = "Your personal information has been successfully updated.";
		
		assertEquals(textFromConfirmationMessage, textForAssertion);
		
		mainPage.userAccountButonClick();
		myAccountPage.myPersonalInformationTabClick();
		
		String mrsRadioButtonChecked = yourPersonalInformationPage.getTitleMrsRadioButton().getAttribute("checked");
		String updatedFirstName = yourPersonalInformationPage.getFirstName().getAttribute("value");
		String updatedLastName = yourPersonalInformationPage.getLastName().getAttribute("value");
		String updatedDay = yourPersonalInformationPage.getDayOfBirth().getAttribute("value");
		String updatedMonth = yourPersonalInformationPage.getMonthOfBirth().getAttribute("value");
		String updatedYear = yourPersonalInformationPage.getYearOfBirth().getAttribute("value");
		
		assertEquals(mrsRadioButtonChecked, "true");
		assertEquals(updatedFirstName, firstName);
		assertEquals(updatedLastName, lastName);
		assertEquals(updatedDay, "2");
		assertEquals(updatedMonth, "2");
		assertEquals(updatedYear, "1999");
		
		//clean up update
		mainPage.userAccountButonClick();
		myAccountPage.myPersonalInformationTabClick();
		
		yourPersonalInformationPage.titleMrRadioButtonClick();
		
		yourPersonalInformationPage.getFirstName().clear();		
		yourPersonalInformationPage.enterFirstname(actualFirstName);
		
		yourPersonalInformationPage.getLastName().clear();
		yourPersonalInformationPage.enterLastname(actualLastName);
		
		yourPersonalInformationPage.dayOfBirthClick();
		yourPersonalInformationPage.getDayOfBirth().sendKeys(Keys.ARROW_UP);
		yourPersonalInformationPage.getDayOfBirth().sendKeys(Keys.ENTER);
		
		yourPersonalInformationPage.monthOfBirthClick();
		yourPersonalInformationPage.getMonthOfBirth().sendKeys(Keys.ARROW_UP);
		yourPersonalInformationPage.getMonthOfBirth().sendKeys(Keys.ENTER);
		
		yourPersonalInformationPage.yearOfBirthClick();
		yourPersonalInformationPage.getYearOfBirth().sendKeys(Keys.ARROW_UP);
		yourPersonalInformationPage.getYearOfBirth().sendKeys(Keys.ENTER);		
		
		yourPersonalInformationPage.enterPassword(password);
		
		yourPersonalInformationPage.saveButtonClick();
		
		textFromConfirmationMessage = yourPersonalInformationPage.updateInfoMessageText();
		textForAssertion = "Your personal information has been successfully updated.";
		
		assertEquals(textFromConfirmationMessage, textForAssertion);
	}
	
	@AfterMethod 
	public void afterEveryTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
