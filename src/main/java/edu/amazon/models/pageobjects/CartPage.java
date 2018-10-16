package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.pagecomponents.OpenCart;
import edu.amazon.interfaces.pagecomponents.ProductSearch;
import edu.amazon.models.Account;

public class CartPage extends PageObject implements ProductSearch, OpenCart {
	@FindBy(name = "proceedToCheckout")
	private WebElement checkoutButton;
	
	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	public void checkout(Account account) {
		checkoutButton.click();
	}
}
