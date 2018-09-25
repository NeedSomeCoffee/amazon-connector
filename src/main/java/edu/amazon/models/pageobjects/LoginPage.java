package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.amazon.models.Account;

public class LoginPage extends AbstractPage {
	@FindBy(id = "ap_email")
	private WebElement loginField;
	@FindBy(id = "ap_password")
	private WebElement passwordField;
	@FindBy(name = "rememberMe")
	private WebElement rememberMeCheckBox;
	@FindBy(id = "signInSubmit")
	private WebElement submitButton;
	
	protected LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MainPage login(Account acc) {
		loginField.sendKeys(acc.getLogin());
		passwordField.sendKeys(acc.getPassword());
		
		submitButton.submit();
		
		return new MainPage(driver);
	}
}
