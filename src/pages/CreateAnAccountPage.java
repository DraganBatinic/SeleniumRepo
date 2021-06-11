package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateAnAccountPage {
	WebDriver driver;
	WebElement createAnAccountHeading;
	WebElement titleMrRadioButton;
	WebElement firstName;
	WebElement lastName;
	WebElement email;
	WebElement password;
	WebElement dayOfBirthDropdownMenu;
	WebElement monthOfBirthDropdownMenu;
	WebElement yearOfBirthDropdownMenu;
	WebElement yourAddressFirstName;
	WebElement yourAddressLastName;
	WebElement address;
	WebElement city;
	WebElement stateDropdownMenu;
	WebElement postalCode;
	WebElement mobilePhone;
	WebElement addressAlias;
	WebElement registerButton;
	WebElement errorMessage;
	WebDriverWait wdwait;
	
	public CreateAnAccountPage(WebDriver driver) {
		super();
		this.driver = driver;
		wdwait = new WebDriverWait(driver, 30);
	}

	public WebElement getCreateAnAccountHeading() {
		return driver.findElement(By.className("page-subheading"));
	}
		
	public WebElement getTitleMrRadioButton() {
		return driver.findElement(By.id("id_gender1"));
	}

	public WebElement getFirstName() {
		return driver.findElement(By.id("customer_firstname"));
	}

	public WebElement getLastName() {
		return driver.findElement(By.id("customer_lastname"));
	}

	public WebElement getEmail() {
		return driver.findElement(By.id("email"));
	}

	public WebElement getPassword() {
		return driver.findElement(By.id("passwd"));
	}

	public WebElement getDayOfBirthDropdownMenu() {
		return driver.findElement(By.id("days"));
	}

	public WebElement getMonthOfBirthDropdownMenu() {
		return driver.findElement(By.id("months"));
	}

	public WebElement getYearOfBirthDropdownMenu() {
		return driver.findElement(By.id("years"));
	}

	public WebElement getYourAddressFirstName() {
		return driver.findElement(By.id("firstname"));
	}

	public WebElement getYourAddressLastName() {
		return driver.findElement(By.id("lastname"));
	}

	public WebElement getAddress() {
		return driver.findElement(By.id("address1"));
	}

	public WebElement getCity() {
		return driver.findElement(By.id("city"));
	}

	public WebElement getStateDropdownMenu() {
		return driver.findElement(By.id("id_state"));
	}

	public WebElement getPostalCode() {
		return driver.findElement(By.id("postcode"));
	}

	public WebElement getMobilePhone() {
		return driver.findElement(By.id("phone_mobile"));
	}

	public WebElement getAddressAlias() {
		return driver.findElement(By.id("alias"));
	}
	
	public WebElement getRegisterButton() {
		return driver.findElement(By.id("submitAccount"));
	}

	public WebElement getErrorMessage() {
		return driver.findElement(By.cssSelector(".alert.alert-danger"));
	}

	public String createAnAccountHeadingText() {		
		return this.getCreateAnAccountHeading().getText();
	}
	
	public void titleMrRadioButtonClick() {		 
		titleMrRadioButton = wdwait.until(ExpectedConditions.elementToBeClickable(this.getTitleMrRadioButton()));
		this.getTitleMrRadioButton().click();
	}
	
	public void enterFirstName(String string) {
		this.getFirstName().sendKeys(string);
	}
	
	public void enterLastName(String string) {
		this.getLastName().sendKeys(string);
	}
	
	public void enterEmail(String string) {
		this.getEmail().sendKeys(string);
	}
		
	public void enterPassword(String string) {
		this.getPassword().sendKeys(string);
	}
	
	public void dayOfBirthDropdownMenuClick() {
		this.getDayOfBirthDropdownMenu().click();
	}
	
	public void enterDayOfBirth(String string) {
		this.getDayOfBirthDropdownMenu().sendKeys(string);
	}
	
	public void monthOfBirthDropdownMenuClick() {
		this.getMonthOfBirthDropdownMenu().click();
	}
	
	public void enterMonthOfBirth(String string) {
		this.getMonthOfBirthDropdownMenu().sendKeys(string);
	}
	
	public void yearOfBirthDropdownMenuClick() {
		this.getYearOfBirthDropdownMenu().click();
	}
	
	public void enterYearOfBirth(String string) {
		this.getYearOfBirthDropdownMenu().sendKeys(string);
	}
	
	public void enterYourAddressFirstName(String string) {
		this.getYourAddressFirstName().sendKeys(string);
	}
	
	public void enterYourAddressLastNameText(String string) {
		this.getYourAddressLastName().sendKeys(string);
	}
	
	public void enterAddress(String string) {
		this.getAddress().sendKeys(string);
	}
	
	public void enterCity(String string) {
		this.getCity().sendKeys(string);
	}
	
	public void stateDropdownMenuClick() {
		this.getStateDropdownMenu().click();
	}
	
	public void enterState(String string) {
		this.getStateDropdownMenu().sendKeys(string);
	}
	
	public void enterPostalCode(String string) {
		this.getPostalCode().sendKeys(string);
	}
	
	public void enterMobilePhone(String string) {
		this.getMobilePhone().sendKeys(string);
	}
	
	public void enterAddressAlias(String string) {
		this.getAddressAlias().sendKeys(string);
	}
	
	public void registerButtonClick() {
		this.getRegisterButton().click();
	}
	
	public String errorMessageText() {
		return this.getErrorMessage().getText();
	}

}
