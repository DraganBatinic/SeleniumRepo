package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AuthenticationPage {
	WebDriver driver;
	WebElement authenticationHeading;
	WebElement emailAddressField;
	WebElement createAnAccountButton;
	WebElement createAccountErrorMessage;
	WebElement logInEmailAddressField;
	WebElement logInPasswordField;
	WebElement signInButton;
	WebElement authenticatonErrorMessage;
	WebDriverWait wdwait;
	
	public AuthenticationPage(WebDriver driver) {
		super();
		this.driver = driver;
		wdwait = new WebDriverWait(driver, 30);
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

	public WebElement getLogInEmailAddressField() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getLogInPasswordField() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.id("SubmitLogin"));
	}
	
	public WebElement getAuthenticatonErrorMessage() {
		return driver.findElement(By.cssSelector(".alert.alert-danger"));
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
	
	public String createAnAccountErrorMessageText() {
		WebElement errorMessage = getCreateAccountErrorMessage();
		Boolean textIsVisible = wdwait.until(ExpectedConditions.textToBePresentInElement(errorMessage, "Invalid email address."));
		return this.getCreateAccountErrorMessage().getText();
	}
	
	public void enterLogInEmail(String string) {
		this.getLogInEmailAddressField().sendKeys(string);
	}
	
	public void enterLogInPassword(String string) {
		this.getLogInPasswordField().sendKeys(string);
	}
	
	public void signInButtonClick() {
		this.getSignInButton().click();
	}
	
	public String signInButtonText() {
		return this.getSignInButton().getText();
	}
	
	public String authenticatonErrorMessageText() {		
		return this.getAuthenticatonErrorMessage().getText();
	}
	
	public String createAnAccountButtonText() {
		return this.getCreateAnAccountButton().getText();
	}

	
	
	
	
	

}
