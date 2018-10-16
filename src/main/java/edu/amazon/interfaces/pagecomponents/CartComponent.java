package edu.amazon.interfaces.pagecomponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import edu.amazon.models.pageobjects.CartPage;

public class CartComponent {
private By locator = By.id("#hlb-view-cart");
	
	public CartPage proceedToCart(WebDriver driver) {
		driver.findElement(locator).click();
				
		return new CartPage(driver);
	}
}
