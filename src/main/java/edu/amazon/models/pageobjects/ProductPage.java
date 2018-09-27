package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.Logging;
import edu.amazon.interfaces.OpenCart;
import edu.amazon.interfaces.ProductSearch;
import edu.amazon.models.Account;
import edu.amazon.models.Product;
import edu.amazon.util.DriverProvider;
import edu.amazon.util.ProductParser;

public class ProductPage extends PageObject implements ProductSearch, OpenCart, Logging {
	@FindBy(css = "[id^=add-to-cart-button]")
	private WebElement addToCartButton;
	@FindBy(id="hlb-view-cart-announce")
	private WebElement goToCartButton;
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public Product getProductInfo() {
		Product parsed = ProductParser.parseProduct(driver.getPageSource());
		
		parsed.setUrl(driver.getCurrentUrl());
		
		return parsed;
	}
	
	public ProductPage addProductToCart() {
		addToCartButton.click();
		
		return this;
	}
	
	public CartPage proceedToCart() {
		goToCartButton.click();
				
		return new CartPage(driver);
	}
}
