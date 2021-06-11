package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAccountHeading;
	
	public MyAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getMyAccountHeading() {
		return driver.findElement(By.className("page-heading"));
	}
	
	public String myAccountHeadingText() {
		return this.getMyAccountHeading().getText();
	}

}
