package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourAddressesPage {
	WebDriver driver;
	WebElement address1;
	WebElement address2;
	WebElement backButton;
	WebElement saveButton;
	
	public YourAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getAddress1() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getAddress2() {
		return driver.findElement(By.id("address2"));
	}
		
	public WebElement getBackButton() {
		return driver.findElement(By.linkText("Back to your addresses"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitAddress"));
	}

	public String getAddress1Text() {
		return this.getAddress1().getAttribute("value");
	}
	
	public void enterAddress1(String string) {
		this.getAddress1().sendKeys(string);
	}
	
	public String getAddress2Text() {
		return this.getAddress2().getAttribute("value");
	}
	
	public void enterAddress2(String string) {
		this.getAddress2().sendKeys(string);
	}
	
	public void backButtonClick() {
		this.getBackButton().click();
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	
	
	

}
