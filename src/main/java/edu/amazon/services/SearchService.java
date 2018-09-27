package edu.amazon.services;

import java.util.Optional;

import org.openqa.selenium.WebDriver;

import edu.amazon.interfaces.Logging;
import edu.amazon.models.Product;
import edu.amazon.models.pageobjects.BasePage;
import edu.amazon.models.pageobjects.ProductPage;
import edu.amazon.models.pageobjects.SearchResultPage;
import edu.amazon.util.DriverProvider;

public class SearchService implements Logging {
	private WebDriver driver;
	
	public SearchService() {
		driver  = DriverProvider.getDriver();
	}
	
	public SearchService(WebDriver driver) {
		this.driver = driver;
	}
	
	public Optional<Product> findProductByLink(String link) {
		driver.get(link);
		
		ProductPage page = new ProductPage(driver);
		
		Product fetched = page.getProductInfo();
		
		return Optional.ofNullable(fetched);
	}
	
	public Optional<Product> findProductByText(String text) {
		Optional<ProductPage> optionalPage = openProductPageByText(text);
		
		if(optionalPage.isPresent()) {
			ProductPage page = optionalPage.get();
			
			return Optional.ofNullable(page.getProductInfo());			
		} else {
			return Optional.ofNullable(new Product().setDescription("NULL"));
		}
	}
	
	public Optional<ProductPage> openProductPageByText(String text) {
		BasePage firstPage = new BasePage(driver);
		
		SearchResultPage searchResults = firstPage.findProductByAsin(driver, text);
		
		return searchResults.openFirstProduct();
	}
}
