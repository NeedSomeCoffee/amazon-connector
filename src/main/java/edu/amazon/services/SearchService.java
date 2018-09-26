package edu.amazon.services;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

import edu.amazon.models.Account;
import edu.amazon.models.Product;
import edu.amazon.models.pageobjects.BasePage;
import edu.amazon.models.pageobjects.ProductPage;
import edu.amazon.models.pageobjects.SearchResultPage;
import edu.amazon.util.DriverProvider;

public class SearchService {
	private WebDriver driver = DriverProvider.getDriver();
		
	public Optional<Product> findProductByLink(String link) {
		driver.get(link);
		
		ProductPage page = new ProductPage(driver);
		
		Product fetched = page.getProductInfo();
		
		return Optional.ofNullable(fetched);
	}
	
	public Optional<Product> findProductByText(String text) {
		BasePage firstPage = new BasePage(driver);
		
		SearchResultPage searchResults = firstPage.findProductByAsin(driver, text);
		
		Optional<ProductPage> optionalPage = searchResults.openFirstProduct();
		
		if(optionalPage.isPresent()) {
			ProductPage page = optionalPage.get();
			
			return Optional.ofNullable(page.getProductInfo());			
		} else {
			return Optional.ofNullable(null);
		}
	}
}
