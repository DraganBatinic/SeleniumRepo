package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import tests.ExcelReader;

public class MyWishlistPage {
	WebDriver driver;
	WebElement nameField;
	WebElement saveButton;
	WebElement wishlistTableName;
	WebElement wishlistTableName2;
	WebElement wishlistTableName3;
	WebElement wishlistTableName4;
	WebElement deleteWishlistButton;
	WebElement backToYourAccountButton;
	WebElement pageBody;
	
	public MyWishlistPage(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public WebElement getNameField() {
		return driver.findElement(By.id("name"));
	}

	public WebElement getSaveButton() {
		return driver.findElement(By.id("submitWishlist"));
	}

	public WebElement getWishlistTableName() {
		return driver.findElement(By.linkText("List of dresses"));
	}
	
	public WebElement getWishlistTableName2() {
		return driver.findElement(By.linkText("List of blouses"));
	}

	public WebElement getWishlistTableName3() {
		return driver.findElement(By.linkText("List of shirts"));
	}

	public WebElement getWishlistTableName4() {
		return driver.findElement(By.linkText("List of T-shirts"));
	}

	public WebElement getDeleteWishlistButton() {
		return driver.findElement(By.className("icon-remove"));
	}

	public WebElement getPageBody() {
		return driver.findElement(By.xpath("//body"));
	}	

	public WebElement getBackToYourAccountButton() {
		return driver.findElement(By.linkText("Back to Your Account"));
	}

	public void enterName(String string) {
		this.getNameField().sendKeys(string);
	}
	
	public void saveButtonClick() {
		this.getSaveButton().click();
	}
	
	public String wishlistTableNameText() {
		return this.getWishlistTableName().getText();
	}
	
	public String wishlistTableName2Text() {
		return this.getWishlistTableName2().getText();		
	}
	
	public String wishlistTableName3Text() {
		return this.getWishlistTableName3().getText();
	}
	
	public String wishlistTableName4Text() {
		return this.getWishlistTableName4().getText();
	}
	
	public void deleteWishlistButtonClick() {
		this.getDeleteWishlistButton().click();
	}
	
	public void pageBodyEnterClick() {
		this.getPageBody().sendKeys(Keys.ENTER);
	}
	
	public void backToYourAccountButtonClick() {
		this.getBackToYourAccountButton().click();
	}
	
	
		

}
