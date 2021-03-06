package edu.amazon.models.pageobjects;

import org.jsoup.Jsoup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import edu.amazon.interfaces.Logging;

public abstract class PageObject implements Logging {
	protected static final String AMAZON_BASE_URL = "https://amazon.com";
	protected volatile WebDriver driver;
	
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
	
	public WebDriver getDriver() {
		return driver;
	}
}
