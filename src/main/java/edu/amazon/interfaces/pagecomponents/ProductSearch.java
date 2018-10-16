package edu.amazon.interfaces.pagecomponents;

import org.openqa.selenium.WebDriver;

import edu.amazon.models.pageobjects.ProductSearchComponent;
import edu.amazon.models.pageobjects.SearchResultPage;

public interface ProductSearch {
	public ProductSearchComponent component = new ProductSearchComponent();
	
	default SearchResultPage findProductByAsin(WebDriver driver, String asin) {
		return component.searchProductByAsin(driver, asin);
	}
}
