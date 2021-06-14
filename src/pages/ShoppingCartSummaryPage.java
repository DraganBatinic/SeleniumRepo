package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingCartSummaryPage {
	WebDriver driver;
	WebElement addedProductBlouse;
	WebElement addedProductBlouseQty;
	WebElement unregisteredAddedProductBlouseQty;
	WebElement addedProductPrintedDress;
	WebElement addedProductPrintedDressQty;
	WebElement addedProductPrintedSummerDress;
	WebElement addedProductPrintedSummerDressQty;
	WebElement proceedToCheckoutButton;
	WebElement increaseQtyButton;
	WebElement removeProductButton;
	WebElement emptyCartMessage;
	
	public ShoppingCartSummaryPage(WebDriver driver) {
		super();
		this.driver = driver;		
	}

	public WebElement getAddedProductBlouse() {
		return driver.findElement(By.linkText("Blouse"));
	}

	public WebElement getAddedProductBlouseQty() {
		return driver.findElement(By.name("quantity_2_7_0_520489"));
	}

	public WebElement getAddedProductPrintedDress() {
		return driver.findElement(By.linkText("Printed Dress"));
	}

	public WebElement getAddedProductPrintedDressQty() {
		return driver.findElement(By.name("quantity_3_13_0_520489"));
	}

	public WebElement getAddedProductPrintedSummerDress() {
		return driver.findElement(By.linkText("Printed Summer Dress"));
	}

	public WebElement getAddedProductPrintedSummerDressQty() {
		return driver.findElement(By.name("quantity_5_19_0_520489"));
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.linkText("Proceed to checkout"));
	}	
	
	public WebElement getIncreaseQtyButton() {
		return driver.findElement(By.id("cart_quantity_up_2_7_0_520489"));
	}

	public WebElement getRemoveProductButton() {
		return driver.findElement(By.className("cart_quantity_delete"));
	}

	public WebElement getEmptyCartMessage() {
		return driver.findElement(By.cssSelector(".alert.alert-warning"));
	}

	public WebElement getUnregisteredAddedProductBlouseQty() {
		return driver.findElement(By.name("quantity_2_7_0_0"));
	}

	public String addedProductBlouseText() {
		return this.getAddedProductBlouse().getText();
	}
	
	public String addedProductBlouseQtyText() {
		return this.getAddedProductBlouseQty().getAttribute("value");
	}
	
	public String unregisteredAddedProductBlouseQtyText() {
		return this.getUnregisteredAddedProductBlouseQty().getAttribute("value");
	}
	
	public String addedProductPrintedDressText() {
		return this.getAddedProductPrintedDress().getText();
	}
	
	public String addedProductPrintedDressQtyText() {
		return this.getAddedProductPrintedDressQty().getAttribute("value");
	}
	
	public String addedProductPrintedSummerDressText() {
		return this.getAddedProductPrintedSummerDress().getText();
	}
	
	public String addedProductPrintedSummerDressQtyText() {
		return this.getAddedProductPrintedSummerDressQty().getAttribute("value");
	}
	
	public void proceedToCheckoutButtonClick() {
		this.getProceedToCheckoutButton().click();
	}
	
	public void increaseQtyButtonClick() {
		this.getIncreaseQtyButton().click();
	}
	
	public void removeProductButtonClick() {
		this.getRemoveProductButton().click();
	}
	
	public String emptyCartMessageText() {
		return this.getEmptyCartMessage().getText();
	}
	
	

}
