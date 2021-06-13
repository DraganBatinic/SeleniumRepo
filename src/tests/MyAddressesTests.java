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
		
		mainPage.signInButtonClick();
		String email = excelReader.getStringData("TCLogIn2", 10, 2);		
		String password = excelReader.getStringData("TCLogIn2", 12, 3);		
		authenticationPage.enterLogInEmail(email);
		authenticationPage.enterLogInPassword(password);	
		authenticationPage.signInButtonClick();
		
		myAccountPage.myAddressesTabClick();
		myAddressesPage.updateButtonClick();
	}
	
	@Test (priority = 0)
	public void updateUsersAddress() {
		String actualAddress1 = yourAddressesPage.getAddress1Text();
		yourAddressesPage.getAddress1().clear();
		String address1 = excelReader.getStringData("TCMA1", 13, 2);
		yourAddressesPage.enterAddress1(address1);
		
		yourAddressesPage.saveButtonClick();
		
		String updatedAddress = myAddressesPage.getAddress1Text();
		String addressToAssert = "Meseceva 10";
		
		assertEquals(updatedAddress, addressToAssert);
		
		//clean up update
		myAddressesPage.updateButtonClick();
		yourAddressesPage.getAddress1().clear();		
		yourAddressesPage.enterAddress1(actualAddress1);
		
		yourAddressesPage.saveButtonClick();
		
		String defaultAddress = myAddressesPage.getAddress1Text();
		addressToAssert = actualAddress1;
		
		assertEquals(defaultAddress, addressToAssert);
		
	}
	
	@Test (priority = 3)
	public void addUsersAddress() {			
		yourAddressesPage.getAddress2().clear();
		String address2 = excelReader.getStringData("TCMA2", 12, 2);
		yourAddressesPage.enterAddress2(address2);
		
		yourAddressesPage.saveButtonClick();
		
		String updatedAddress = myAddressesPage.getAddress2Text();
		String addressToAssert = "Vetrova 22";
		
		assertEquals(updatedAddress, addressToAssert);		
		
	}
	
	@Test (priority = 6)
	public void removeUsersAddress() {		
		yourAddressesPage.getAddress2().clear();		
		
		yourAddressesPage.saveButtonClick();
		
		String updatedAddress = myAddressesPage.getAddress2Text();
		String addressToAssert = "";
		
		assertEquals(updatedAddress, addressToAssert);	
		
	}	
	
	@AfterMethod 
	public void afterEveryTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
