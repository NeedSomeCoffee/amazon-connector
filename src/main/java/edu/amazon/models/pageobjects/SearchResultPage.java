package edu.amazon.models.pageobjects;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
		Elements productContainers = source.select("li.s-result-item.celwidget:not(.s-result-item.celwidget.AdHolder)");
		
		List<Element> filteredContainers = productContainers.stream().skip(2).collect(Collectors.toList());
		
		if(filteredContainers.isEmpty() || filteredContainers.size() <= index) {
			return Optional.ofNullable(null);
		}
		
		String productUrl = filteredContainers.get(index).select(".a-link-normal.s-access-detail-page.s-color-twister-title-link.a-text-normal").attr("href");
		
		driver.get(productUrl);
		
		return Optional.of(new ProductPage(driver));
		
	}
}
