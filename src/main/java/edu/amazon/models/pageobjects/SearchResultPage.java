package edu.amazon.models.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.amazon.models.Product;

public class SearchResultPage extends AbstractPage {	
	@FindBy(id = "s-results-list-atf")
	private List<WebElement> resultTable;
		
	protected SearchResultPage(WebDriver driver) {
		super(driver);
	}
	
	public Product getFirstProduct() {
		
	}
}
