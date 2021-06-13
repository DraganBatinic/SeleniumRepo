package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {
	WebDriver driver;
	WebElement myAccountHeading;
	WebElement signOutButton;
	WebElement myAddressesTab;
	WebElement myPersonalInformationTab;
	
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

	public WebElement getMyAddressesTab() {
		return driver.findElement(By.linkText("MY ADDRESSES"));
	}

	public WebElement getMyPersonalInformationTab() {
		return driver.findElement(By.linkText("MY PERSONAL INFORMATION"));
	}

	public String myAccountHeadingText() {
		return this.getMyAccountHeading().getText();
	}
	
	public void signOutButtonClick() {
		this.getSignOutButton().click();
	}
	
	public void myAddressesTabClick() {
		this.getMyAddressesTab().click();
	}
	
	public void myPersonalInformationTabClick() {
		this.getMyPersonalInformationTab().click();
	}

}
