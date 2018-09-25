package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage extends AbstractPage {		
	@FindBy(id = "nav-link-accountList")
	private WebElement loginPopup;
	
	@FindBy(css = "#nav-flyout-ya-newCust a")
	private WebElement createAccountButton;
	
	private LogonChecker loginedChecker = new LogonChecker();
	
	public BasePage(WebDriver driver) {
		super(driver, "https://amazon.com");		
	}
	
	public RegistrationPage goToRegistrationPage() {		
		Actions builder = new Actions(driver); 
		
		builder.moveToElement(loginPopup).build().perform();
		
		createAccountButton.click();
		
		return new RegistrationPage(driver);
	}
}
