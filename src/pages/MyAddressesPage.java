package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAddressesPage {
	WebDriver driver;
	WebElement updateButton;
	WebElement address1;
	WebElement address2;
	WebElement addNewAddressButton;
	
	public MyAddressesPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUpdateButton() {
		return driver.findElement(By.linkText("Update"));
	}
	
	public WebElement getAddress1() {
		return driver.findElement(By.className("address_address1"));
	}

	public WebElement getAddress2() {
		return driver.findElement(By.className("address_address2"));
	}

	public WebElement getAddNewAddressButton() {
		return driver.findElement(By.linkText("Add a new address"));
	}

	public void updateButtonClick() {
		this.getUpdateButton().click();
	}
	
	public String getAddress1Text() {
		return this.getAddress1().getText();
	}
	
	public String getAddress2Text() {
		return this.getAddress2().getText();
	}
	
	public void addNewAddressButtonClick() {
		this.getAddNewAddressButton().click();
	}
	
	

}
