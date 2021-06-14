package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ShoppingAddressesPage {
	WebDriver driver;
	WebElement proceedToCheckoutButton;
	
	public ShoppingAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getProceedToCheckoutButton() {
		return driver.findElement(By.name("processAddress"));
	}
	
	public String proceedToCheckoutButtonText() {
		return this.getProceedToCheckoutButton().getText();
	}
	
	
	
	
	

}
