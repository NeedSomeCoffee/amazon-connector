package edu.amazon.services;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

import edu.amazon.interfaces.Logging;
import edu.amazon.models.Product;
import edu.amazon.models.pageobjects.CartPage;
import edu.amazon.models.pageobjects.ProductPage;
import edu.amazon.util.DriverProvider;

public class PurchaseService implements Logging {
	private WebDriver driver;
	
	public PurchaseService() {
		driver = DriverProvider.getDriver();
	}
	
	public CartPage addProductToCart(String asin) {
		SearchService search = new SearchService(driver);
		
		Optional<ProductPage> productPage = search.openProductPageByText(asin);
		
		if (productPage.isPresent()) {
			return productPage.get().addProductToCart().proceedToCart();			
		} else {
			logger.warning("Product hasn't been found!");
			driver.quit();
			return null;
		}
	}
	
	
	/**
	 * Product with valid url must be provided
	 * 	adds product to cart.
	 * @return {@link CartPage} with this product added
	 * */
	public CartPage addProductToCart(Product product) {
		driver.get(product.getUrl());
		
		ProductPage productPage = new ProductPage(driver);
		
		productPage.addProductToCart();
		return productPage.proceedToCart();
	}
}
