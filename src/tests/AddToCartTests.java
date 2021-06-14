package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class AddToCartTests extends BaseTests{
	
	@BeforeMethod
	public void beforeEveryTest() {
		driver.navigate().to(homeUrl);
		driver.manage().window().maximize();
	}
	
	@Test (priority = 0)
	public void addOneProductToCart() {
		this.logInProcedure();		
		
		mainPage.blouseAddToCartButtonClick();
		mainPage.proceedToCheckOutButtonClick();
		
		String actualProductName = shoppingCartSummaryPage.addedProductBlouseText();
		String actualProductQty = shoppingCartSummaryPage.addedProductBlouseQtyText();
		
		String productNameForAssertion = excelReader.getStringData("TCAddPr1", 10, 2);
		String productQtyForAssertion = excelReader.getStringData("TCAddPr1", 11, 2);
		
		assertEquals(actualProductName, productNameForAssertion);
		assertEquals(actualProductQty, productQtyForAssertion);
		
		shoppingCartSummaryPage.proceedToCheckoutButtonClick();
		
		String actualText = shoppingAddressesPage.proceedToCheckoutButtonText();
		String textForAssertion = "Proceed to checkout";
		
		assertEquals(actualText, textForAssertion);
		
	}
	
	@Test (priority = 3)
	public void changeProductQuantityFromCartToThree() {
		this.logInProcedure();		
		
		mainPage.blouseAddToCartButtonClick();
		mainPage.proceedToCheckOutButtonClick();
		
		String actualProductName = shoppingCartSummaryPage.addedProductBlouseText();
		String actualProductQty = shoppingCartSummaryPage.addedProductBlouseQtyText();
		
		String productNameForAssertion = excelReader.getStringData("TCAddPr2", 10, 2);
		String productQtyForAssertion = excelReader.getStringData("TCAddPr2", 12, 2);
		
		assertEquals(actualProductName, productNameForAssertion);
		assertEquals(actualProductQty, productQtyForAssertion);
		
		shoppingCartSummaryPage.increaseQtyButtonClick();
		shoppingCartSummaryPage.increaseQtyButtonClick();
		
		driver.navigate().refresh();
		
		actualProductQty = shoppingCartSummaryPage.addedProductBlouseQtyText();	
		productQtyForAssertion = excelReader.getStringData("TCAddPr2", 13, 2);		
		
		assertEquals(actualProductQty, productQtyForAssertion);
		
		shoppingCartSummaryPage.proceedToCheckoutButtonClick();
		
		String actualText = shoppingAddressesPage.proceedToCheckoutButtonText();
		String textForAssertion = "Proceed to checkout";
		
		assertEquals(actualText, textForAssertion);
		
	}
	
	@Test (priority = 6)
	public void addThreeSameProductsInCart() {
		this.logInProcedure();		
		
		mainPage.blouseAddToCartButtonClick();		
		mainPage.continueShoppingButtonClick();
		
		mainPage.blouseAddToCartButtonClick();
		mainPage.continueShoppingButtonClick();
		
		mainPage.blouseAddToCartButtonClick();
		mainPage.proceedToCheckOutButtonClick();
		
		String actualProductName = shoppingCartSummaryPage.addedProductBlouseText();
		String actualProductQty = shoppingCartSummaryPage.addedProductBlouseQtyText();
		
		String productNameForAssertion = excelReader.getStringData("TCAddPr3", 10, 2);
		String productQtyForAssertion = excelReader.getStringData("TCAddPr3", 16, 2);
		
		assertEquals(actualProductName, productNameForAssertion);
		assertEquals(actualProductQty, productQtyForAssertion);
		
		shoppingCartSummaryPage.proceedToCheckoutButtonClick();
		
		String actualText = shoppingAddressesPage.proceedToCheckoutButtonText();
		String textForAssertion = "Proceed to checkout";
		
		assertEquals(actualText, textForAssertion);
	}
	
	@Test (priority = 9)
	public void addThreeDifferentProductsInCart() {
		this.logInProcedure();
		
		mainPage.blouseAddToCartButtonClick();		
		mainPage.continueShoppingButtonClick();
		
		mainPage.printedDressAddToCartButtonClick();
		mainPage.continueShoppingButtonClick();
		
		mainPage.printedSummerDressAddToCartButtonClick();
		mainPage.proceedToCheckOutButtonClick();
		
		String actualProductName1 = shoppingCartSummaryPage.addedProductBlouseText();
		String actualProductQty1 = shoppingCartSummaryPage.addedProductBlouseQtyText();
		
		String actualProductName2 = shoppingCartSummaryPage.addedProductPrintedDressText();
		String actualProductQty2 = shoppingCartSummaryPage.addedProductPrintedDressQtyText();
		
		String actualProductName3 = shoppingCartSummaryPage.addedProductPrintedSummerDressText();
		String actualProductQty3 = shoppingCartSummaryPage.addedProductPrintedSummerDressQtyText();
		
		String productNameForAssertion1 = excelReader.getStringData("TCAddPr4", 10, 2);
		String productNameForAssertion2 = excelReader.getStringData("TCAddPr4", 12, 2);
		String productNameForAssertion3 = excelReader.getStringData("TCAddPr4", 14, 2);
		
		String productQtyForAssertion = excelReader.getStringData("TCAddPr4", 16, 2);
		
		assertEquals(actualProductName1, productNameForAssertion1);
		assertEquals(actualProductQty1, productQtyForAssertion);
		
		assertEquals(actualProductName2, productNameForAssertion2);
		assertEquals(actualProductQty2, productQtyForAssertion);
		
		assertEquals(actualProductName3, productNameForAssertion3);
		assertEquals(actualProductQty3, productQtyForAssertion);
		
		shoppingCartSummaryPage.proceedToCheckoutButtonClick();
		
		String actualText = shoppingAddressesPage.proceedToCheckoutButtonText();
		String textForAssertion = "Proceed to checkout";
		
		assertEquals(actualText, textForAssertion);		
	}
	
	@Test (priority = 12)
	public void removeOneProductFromCart() {
		this.logInProcedure();		
		
		mainPage.blouseAddToCartButtonClick();
		mainPage.proceedToCheckOutButtonClick();
		
		String actualProductName = shoppingCartSummaryPage.addedProductBlouseText();
		String actualProductQty = shoppingCartSummaryPage.addedProductBlouseQtyText();
		
		String productNameForAssertion = excelReader.getStringData("TCAddPr5", 10, 2);
		String productQtyForAssertion = excelReader.getStringData("TCAddPr5", 12, 2);
		
		assertEquals(actualProductName, productNameForAssertion);
		assertEquals(actualProductQty, productQtyForAssertion);
		
		shoppingCartSummaryPage.removeProductButtonClick();
		
		driver.navigate().refresh();
		
		String actualMessageText = shoppingCartSummaryPage.emptyCartMessageText();
		String textForAssertion = "Your shopping cart is empty.";
		
		assertEquals(actualMessageText, textForAssertion);
	}
	
	@Test (priority = 13)
	public void removeProductFromCartTab() {
		this.logInProcedure();		
		
		mainPage.blouseAddToCartButtonClick();
		mainPage.continueShoppingButtonClick();
		
		mainPage.shoppingCartTabHover();		
		mainPage.removeProductButton();
		
		driver.navigate().refresh();
		
		String actualTextOnCartTab = mainPage.emptyCartInfoMessageText();
		String textForAssertion = "";
		
		assertEquals(actualTextOnCartTab, textForAssertion);
	}
	
	@Test (priority = 16)
	public void unregisteredUserCantProceedWithPurchase() {
		mainPage.blouseAddToCartButtonClick();
		mainPage.proceedToCheckOutButtonClick();
		
		String actualProductName = shoppingCartSummaryPage.addedProductBlouseText();
		String actualProductQty = shoppingCartSummaryPage.unregisteredAddedProductBlouseQtyText();
		
		String productNameForAssertion = excelReader.getStringData("TCAddPr7", 8, 2);
		String productQtyForAssertion = excelReader.getStringData("TCAddPr7", 10, 2);
		
		assertEquals(actualProductName, productNameForAssertion);
		assertEquals(actualProductQty, productQtyForAssertion);
		
		shoppingCartSummaryPage.proceedToCheckoutButtonClick();
		
		String actualCreateAnAccountButtonText = authenticationPage.createAnAccountButtonText();
		String textForAssertion = "Create an account";
		
		assertEquals(actualCreateAnAccountButtonText, textForAssertion);
		
	}
		
	public void logInProcedure() {
		mainPage.signInButtonClick();
		String email = excelReader.getStringData("TCLogIn2", 10, 2);		
		String password = excelReader.getStringData("TCLogIn2", 12, 3);		
		authenticationPage.enterLogInEmail(email);
		authenticationPage.enterLogInPassword(password);	
		authenticationPage.signInButtonClick();
		
		myAccountPage.returnToHomeButtonClick();
		js.executeScript("arguments[0].scrollIntoView();", mainPage.getBestSellersButton());
	}
			
	@AfterMethod 
	public void afterEveryTest() {		
		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
	}

}
