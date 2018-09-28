package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.OpenCart;
import edu.amazon.interfaces.ProductSearch;

public class BasePage extends PageObject implements ProductSearch, OpenCart {		
	@FindBy(id = "nav-link-accountList")
	private WebElement loginPopup;
	
	@FindBy(css = "#nav-flyout-ya-newCust a")
	private WebElement createAccountButton;
		
	public BasePage(WebDriver driver) {
		super(driver, AMAZON_BASE_URL);		
	}
	
	public RegistrationPage goToRegistrationPage() {		
		Actions builder = new Actions(driver); 
		
		builder.moveToElement(loginPopup).build().perform();
		
		createAccountButton.click();
		
		return new RegistrationPage(driver);
	}
}
