package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAccountHeading;
	WebElement signOutButton;
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getMyAccountHeading() {
		return driver.findElement(By.className("page-heading"));
	}
		
	public WebElement getSignOutButton() {
		return driver.findElement(By.className("logout"));
	}

	public String myAccountHeadingText() {
		return this.getMyAccountHeading().getText();
	}
	
	public void signOutButtonClick() {
		this.getSignOutButton().click();
	}

}
