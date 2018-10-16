package edu.amazon.models.pageobjects;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.pagecomponents.OpenCart;
import edu.amazon.interfaces.pagecomponents.ProductSearch;
import edu.amazon.util.DriverProvider;

public class SearchResultPage extends PageObject implements ProductSearch, OpenCart {	
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
		Elements productContainers = source.select("li.s-result-item.celwidget:not(.s-result-item.celwidget.AdHolder):not(.s-result-item.celwidget.acs-private-brands-container-background)");
				
		List<String> productUrls = productContainers.select("a.a-link-normal.s-access-detail-page.s-color-twister-title-link.a-text-normal")
														.stream().map(E -> E.attr("href"))
														.collect(Collectors.toList());
		
		if(productUrls.isEmpty() || productUrls.size() <= index) {
			return Optional.ofNullable(null);
		}
		
		driver.get(productUrls.get(index));
		
		return Optional.of(new ProductPage(driver));
		
	}
}
