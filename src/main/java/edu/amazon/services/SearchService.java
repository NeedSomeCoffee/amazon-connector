package edu.amazon.services;

import org.openqa.selenium.WebDriver;

import edu.amazon.models.Account;
import edu.amazon.models.Product;
import edu.amazon.models.pageobjects.BasePage;
import edu.amazon.util.DriverProvider;

public class SearchService {
	private WebDriver driver = DriverProvider.getDriver();
	private Account account;
	
	public SearchService() {
		
	}
	
	public SearchService(Account account) {
		this.account = account;
	}
	
	public Product findProductByLink(String link) {
		driver.get(link);
		
		return new Product();
	}
	
	public Product findProductByText(String text) {
		BasePage firstPage = new BasePage(driver);
		
		
	}
}
