package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.ProductSearch;
import edu.amazon.models.Product;
import edu.amazon.util.ProductParser;

public class ProductPage extends PageObject implements ProductSearch {
	@FindBy(id = "add-to-cart-button-ubb")
	private WebElement addToCartButton;
	
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
}
