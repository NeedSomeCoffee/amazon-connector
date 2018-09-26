package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;

import edu.amazon.interfaces.ProductSearch;
import edu.amazon.models.Product;
import edu.amazon.util.ProductParser;

public class ProductPage extends AbstractPage implements ProductSearch {
	
	public ProductPage(WebDriver driver) {
		super(driver);
	}
	
	public Product getProductInfo() {
		Product parsed = ProductParser.parseProduct(driver.getPageSource());
		
		parsed.setUrl(driver.getCurrentUrl());
		
		return parsed;
	}
}
