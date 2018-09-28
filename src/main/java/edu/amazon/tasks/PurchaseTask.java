package edu.amazon.tasks;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

import edu.amazon.interfaces.Logging;
import edu.amazon.models.Product;
import edu.amazon.models.pageobjects.CartPage;
import edu.amazon.models.pageobjects.ProductPage;
import edu.amazon.util.ArgumentsValidator;
import edu.amazon.util.DriverProvider;

public class PurchaseTask implements Logging, Runnable {
	private WebDriver driver;
	private String query;
	
	public PurchaseTask(String query) {
		driver = DriverProvider.getDriver();
		this.query = query;
	}

	@Override
	public void run() {
		if(ArgumentsValidator.isUrl(query)) {
			addProductToCart(new Product().setUrl(query));
		} else {
			addProductToCart();
		}
		
	}
	
	public void addProductToCart() {
		SearchTask search = new SearchTask(driver);
		
		Optional<ProductPage> productPage = search.openProductPageByText(query);
		
		if (productPage.isPresent()) {
			ProductPage page = productPage.get();
			
			if(page.addProductToCart()) {
				page.proceedToCart();	
			}					
		} else {
			logger.warning("Product hasn't been found!");			
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
