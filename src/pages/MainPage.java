package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
	WebDriver driver;
	WebElement signInButton;
	WebElement userAccountButton;
	WebElement bestSellersButton;
	WebElement blouseProductTitle;
	WebElement printedDressProductTitle;
	WebElement printedSummerDressProductTitle;
	WebElement blouseAddToCartButton;
	WebElement printedDressAddToCartButton;
	WebElement printedSummerDressAddToCartButton;
	WebElement proceedToCheckOutButton;
	WebElement continueShoppingButton;
	WebElement shoppingCartTab;
	WebElement removeProductButton;
	WebElement emptyCartInfoMessage;
	WebDriverWait wdwait;
	Actions actions;
	
	
	
	public MainPage(WebDriver driver) {
		super();
		this.driver = driver;
		wdwait = new WebDriverWait(driver, 30);
		actions = new Actions(driver);
	}

	public WebElement getSignInButton() {
		return driver.findElement(By.className("login"));
	}
	
	public WebElement getUserAccountButton() {
		return driver.findElement(By.className("header_user_info"));
	}

	public WebElement getBestSellersButton() {
		return driver.findElement(By.className("blockbestsellers"));
	}

	public WebElement getBlouseProductTitle() {
		return driver.findElement(By.linkText("Blouse"));
	}

	public WebElement getPrintedDressProductTitle() {
		return driver.findElement(By.linkText("Printed Dress"));
	}

	public WebElement getPrintedSummerDressProductTitle() {
		return driver.findElement(By.linkText("Printed Summer Dress"));
	}

	public WebElement getBlouseAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[2]/div/div[2]/div[2]/a[1]"));
	}

	public WebElement getPrintedDressAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]"));
	}

	public WebElement getPrintedSummerDressAddToCartButton() {
		return driver.findElement(By.xpath("//*[@id=\"homefeatured\"]/li[5]/div/div[2]/div[2]/a[1]"));
	}

	public WebElement getProceedToCheckOutButton() {
		return driver.findElement(By.linkText("Proceed to checkout"));
	}

	public WebElement getContinueShoppingButton() {
		return driver.findElement(By.xpath("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/span"));
	}

	public WebElement getShoppingCartTab() {
		return driver.findElement(By.partialLinkText("Cart"));
	}

	public WebElement getRemoveProductButton() {
		return driver.findElement(By.className("ajax_cart_block_remove_link"));
	}

	public WebElement getEmptyCartInfoMessage() {
		return driver.findElement(By.cssSelector(".unvisible"));
	}

	public void signInButtonClick() {
		this.getSignInButton().click();
	}
	
	public void userAccountButonClick() {
		this.getUserAccountButton().click();
	}
	
	public void blouseAddToCartButtonClick() {
		actions.moveToElement(this.getBlouseProductTitle()).perform();		
		this.getBlouseAddToCartButton().click();
	}
	
	public void printedDressAddToCartButtonClick() {
		actions.moveToElement(this.getPrintedDressProductTitle()).perform();
		this.getPrintedDressAddToCartButton().click();
	}
	
	public void printedSummerDressAddToCartButtonClick() {
		actions.moveToElement(this.getPrintedSummerDressProductTitle()).perform();
		this.getPrintedSummerDressAddToCartButton().click();
	}
	
	public void proceedToCheckOutButtonClick() {
		proceedToCheckOutButton = wdwait.until(ExpectedConditions.elementToBeClickable(this.getProceedToCheckOutButton()));
		this.getProceedToCheckOutButton().click();
	}
	
	public void continueShoppingButtonClick() {
		continueShoppingButton = wdwait.until(ExpectedConditions.elementToBeClickable(this.getContinueShoppingButton()));
		this.getContinueShoppingButton().click();
	}
	
	public void shoppingCartTabHover() {
		actions.moveToElement(this.getShoppingCartTab()).perform();
	}
	
	public void removeProductButton() {
		removeProductButton = wdwait.until(ExpectedConditions.elementToBeClickable(this.getRemoveProductButton()));
		this.getRemoveProductButton().click();
	}
	
	public String emptyCartInfoMessageText() {
		return this.getEmptyCartInfoMessage().getText();
	}
	
	
	
	

}
