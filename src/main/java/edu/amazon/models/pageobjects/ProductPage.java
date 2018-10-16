package edu.amazon.models.pageobjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.pagecomponents.OpenCart;
import edu.amazon.interfaces.pagecomponents.ProductSearch;
import edu.amazon.models.Product;
import edu.amazon.util.ProductParser;

public class ProductPage extends PageObject implements ProductSearch, OpenCart {
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

	public boolean addProductToCart() {
		try {
			addToCartButton.click();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public CartPage proceedToCart() {
		goToCartButton.click();

		return new CartPage(driver);
	}
}
