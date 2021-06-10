package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthenticationPage {
	WebDriver driver;
	WebElement authenticationHeading;
	
	public AuthenticationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getAuthenticationHeading() {
		return driver.findElement(By.className("page-heading"));
	}
	
	public String authenticationHeadingText() {
		return this.getAuthenticationHeading().getText();
	}
	
	
	
	

}
