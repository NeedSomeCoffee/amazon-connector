package edu.amazon.interfaces.pagecomponents;

import org.openqa.selenium.WebDriver;

import edu.amazon.models.pageobjects.CartPage;

public interface OpenCart {
	public CartComponent component = new CartComponent();

	default CartPage findProductByAsin(WebDriver driver) {
		return component.proceedToCart(driver);
	}
}
