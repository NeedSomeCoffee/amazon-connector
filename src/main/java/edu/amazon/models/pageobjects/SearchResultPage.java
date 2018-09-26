package edu.amazon.models.pageobjects;

import java.util.List;
import java.util.Optional;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.ProductSearch;

public class SearchResultPage extends PageObject implements ProductSearch {	
	@FindBy(id = "s-results-list-atf")
	private List<WebElement> resultTable;
		
	protected SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public Optional<ProductPage> openFirstProduct() {
		return openProductFromResult(0);
	}
	
	/**
	 * Indexing starts from 0
	 * 
	 * */
	public Optional<ProductPage> openProductFromResult(int index) {
		Document source = Jsoup.parse(driver.getPageSource());
		Element productContainer = source.select("#result_" + index).first();
		
		if(null == productContainer) {
			return Optional.ofNullable(null);
		}
		
		String productUrl = productContainer.select(".a-fixed-left-grid-col.a-col-right a").attr("href");
		
		driver.get(productUrl);
		
		return Optional.of(new ProductPage(driver));
		
	}
}
