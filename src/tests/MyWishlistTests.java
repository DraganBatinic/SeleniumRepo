package tests;

import static org.testng.Assert.assertEquals;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MyWishlistTests extends BaseTests{
	
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
		
		myAccountPage.myWishListTabClick();
	}
	
	@Test (priority = 0)
	public void addOneWishlist() {
		String name = excelReader.getStringData("TCMA5", 11, 2);
		addWishlistProcedure(name);	
		String actualWishlistName = myWishlistPage.wishlistTableNameText();
		String wishlistNameForAssertion = name;
		
		assertEquals(actualWishlistName, wishlistNameForAssertion);
	}
	
	@Test (priority = 3)
	public void removeWishlist() throws InterruptedException {		
		myWishlistPage.deleteWishlistButtonClick();
		Alert myAlert = new WebDriverWait(driver, 10).until(ExpectedConditions.alertIsPresent());
		myAlert.accept();
		myWishlistPage.backToYourAccountButtonClick();
		myAccountPage.myWishListTabClick();
		
		Boolean actualWishlistPresence;
		
		if (driver.findElements(By.linkText(excelReader.getStringData("TCMA5", 11, 2))).size() < 1){
			actualWishlistPresence = false;
		} else {
			actualWishlistPresence = true;
		}
		
		Boolean wishlistPresenceForAssertion = false;
		
		assertEquals(actualWishlistPresence, wishlistPresenceForAssertion);
	}
	
	@Test (priority = 6)
	public void addFourWishLists() {
		String name = excelReader.getStringData("TCMA6", 11, 2);
		addWishlistProcedure(name);	
		String actualWishlistName = myWishlistPage.wishlistTableNameText();
		String wishlistNameForAssertion = name;
		
		assertEquals(actualWishlistName, wishlistNameForAssertion);
		
		name = excelReader.getStringData("TCMA6", 15, 2);
		addWishlistProcedure(name);	
		actualWishlistName = myWishlistPage.wishlistTableName2Text();
		wishlistNameForAssertion = name;
		
		assertEquals(actualWishlistName, wishlistNameForAssertion);
		
		name = excelReader.getStringData("TCMA6", 19, 2);
		addWishlistProcedure(name);	
		actualWishlistName = myWishlistPage.wishlistTableName3Text();
		wishlistNameForAssertion = name;
		
		assertEquals(actualWishlistName, wishlistNameForAssertion);
		
		name = excelReader.getStringData("TCMA6", 23, 2);
		addWishlistProcedure(name);	
		actualWishlistName = myWishlistPage.wishlistTableName4Text();
		wishlistNameForAssertion = name;
		
		assertEquals(actualWishlistName, wishlistNameForAssertion);
		
	}
	
	public void addWishlistProcedure(String string) {
		myWishlistPage.getNameField().clear();
		myWishlistPage.enterName(string);		
		myWishlistPage.saveButtonClick();		
		
	}	
	
	
	@AfterMethod 
	public void afterEveryTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
