package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
	WebDriver driver;
	WebElement authenticationHeading;
	WebElement emailAddressField;
	WebElement createAnAccountButton;
	WebElement createAccountErrorMessage;
	
	public AuthenticationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getAuthenticationHeading() {
		return driver.findElement(By.className("page-heading"));
	}
	
	public WebElement getEmailAddressField() {
		return driver.findElement(By.id("email_create"));
	}

	public WebElement getCreateAnAccountButton() {
		return driver.findElement(By.id("SubmitCreate"));
	}
		
	public WebElement getCreateAccountErrorMessage() {
		return driver.findElement(By.id("create_account_error"));
	}

	public String authenticationHeadingText() {
		return this.getAuthenticationHeading().getText();
	}
	
	public void enterEmailAddress(String string) {
		this.getEmailAddressField().sendKeys(string);
	}
	
	public void createAnAccountButtonClick() {
		this.getCreateAnAccountButton().click();
	}
	
	public String creataAccountErrorMessageText() {
		return this.getCreateAccountErrorMessage().getText();
	}

	
	
	
	
	

}
