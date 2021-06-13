package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YourPersonalInformationPage {
	WebDriver driver;
	WebElement updateInfoMessage;
	WebElement titleMrRadioButton;
	WebElement titleMrsRadioButton;
	WebElement firstName;
	WebElement lastName;
	WebElement dayOfBirth;
	WebElement monthOfBirth;
	WebElement yearOfBirth;
	WebElement password;
	WebElement saveButton;
	
	public YourPersonalInformationPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getUpdateInfoMessage() {
		return driver.findElement(By.cssSelector(".alert.alert-success"));
	}
	
	public WebElement getTitleMrRadioButton() {
		return driver.findElement(By.id("id_gender1"));
	}

	public WebElement getTitleMrsRadioButton() {
		return driver.findElement(By.id("id_gender2"));
	}

	public WebElement getFirstName() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getDayOfBirth() {
		return driver.findElement(By.id("days"));
	}

	public WebElement getMonthOfBirth() {
		return driver.findElement(By.id("months"));
	}

	public WebElement getYearOfBirth() {
		return driver.findElement(By.id("years"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("old_passwd"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.name("submitIdentity"));
	}

	public String updateInfoMessageText() {
		return this.getUpdateInfoMessage().getText();
	}
	
	public void titleMrRadioButtonClick() {
		this.getTitleMrRadioButton().click();
	}
	
	public void titleMrsRadioButtonClick() {
		this.getTitleMrsRadioButton().click();
	}
	
	public void enterFirstname(String string) {
		this.getFirstName().sendKeys(string);
	}
	
	public void enterLastname(String string) {
		this.getLastName().sendKeys(string);
	}
	
	public void dayOfBirthClick() {
		this.getDayOfBirth().click();
	}
	
	public void monthOfBirthClick() {
		this.getMonthOfBirth().click();
	}
	
	public void yearOfBirthClick() {
		this.getYearOfBirth().click();
	}
	
	public void enterPassword(String string) {
		this.getPassword().sendKeys(string);
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	
	

}
