package edu.amazon.models.pageobjects;

import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class PageObject {
	protected static final String AMAZON_BASE_URL = "https://amazon.com";
	protected WebDriver driver;
	
	protected PageObject(WebDriver driver, String url) {
		this.driver = driver;
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	protected PageObject(WebDriver driver) {
		this.driver = driver;		
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Checks, if signin button is present on page. 
	 * 
	 * */
	public boolean isLogged(WebDriver driver) {
		return !Jsoup.parse(driver.getPageSource()).select("#nav-flyout-ya-signin").isEmpty();		
	}
}