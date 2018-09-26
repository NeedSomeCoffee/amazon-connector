package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.models.Account;


public class RegistrationPage extends PageObject {	
	@FindBy(id = "ap_customer_name")
	private WebElement nameField;
	@FindBy(id = "ap_email")
	private WebElement emailField;
	@FindBy(id = "ap_password")
	private WebElement passwordField;
	@FindBy(id = "ap_password_check")
	private WebElement passwordCheckField;
	@FindBy(id = "continue")
	private WebElement submitButton;
	
	protected RegistrationPage(WebDriver driver) {
		super(driver);		
	}
	
	public MainPage registerAccount(Account account) {
		nameField.sendKeys(account.getLogin());
		
		emailField.sendKeys(account.getEmail());
		
		passwordField.sendKeys(account.getPassword());
		
		passwordCheckField.sendKeys(account.getPassword());
		
		submitButton.submit();
		
		return new MainPage(driver);
	}
}
