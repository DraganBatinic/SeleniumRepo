package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pages.YourAddressesPage;

public class MyAddressesTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 0)
	public void updateUsersAddress() {
		mainPage.signInButtonClick();
		String email = excelReader.getStringData("TCLogIn2", 10, 2);		
		String password = excelReader.getStringData("TCLogIn2", 12, 3);		
		authenticationPage.enterLogInEmail(email);
		authenticationPage.enterLogInPassword(password);	
		authenticationPage.signInButtonClick();
		
		myAccountPage.myAddressesTabClick();
		myAddressesPage.updateButtonClick();
		
		yourAddressesPage.getAddress1().clear();
		String address1 = excelReader.getStringData("TCMA1", 13, 2);
		yourAddressesPage.enterAddress1(address1);
		
		yourAddressesPage.saveButtonClick();
		
		String updatedAddress = myAddressesPage.getAddress1Text();
		String addressToAssert = "Meseceva 10";
		
		assertEquals(updatedAddress, addressToAssert);		
		
	}
	
	@AfterMethod 
	public void afterEveryTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
