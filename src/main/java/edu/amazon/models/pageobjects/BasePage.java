package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	private WebDriver driver;
		
	@FindBy(id = "nav-link-accountList")
	private WebElement loginPopup;
	
	@FindBy(css = "#nav-flyout-ya-newCust a")
	private WebElement createAccountButton;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		driver.get("https://www.amazon.com");
		
	}
	
	public RegistrationPage goToRegistrationPage() {
		PageFactory.initElements(driver, this);
		Actions builder = new Actions(driver); 
		
		builder.moveToElement(loginPopup).build().perform();
		
		createAccountButton.click();
		
		return new RegistrationPage(driver);
	}
}
