package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CreateAnAccountPage {
	WebDriver driver;
	WebElement createAnAccountHeading;
	
	public CreateAnAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getCreateAnAccountHeading() {
		return driver.findElement(By.className("page-heading"));
	}
	
	public String createAnAccountHeadingText() {
		return this.getCreateAnAccountHeading().getText();
	}
	
	

}
