package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
	WebDriver driver;
	WebElement signInButton;
	WebElement userAccountButton;
	
	public MainPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	public WebElement getUserAccountButton() {
		return driver.findElement(By.className("header_user_info"));
	}

	public void signInButtonClick() {
		this.getSignInButton().click();
	}
	
	public void userAccountButonClick() {
		this.getUserAccountButton().click();
	}
	
	

}
