package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MainPage extends AbstractPage {	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchField;
	
	protected MainPage(WebDriver driver) {
		super(driver);		
	}
	
	public SearchResultPage searchForProduct(String asin) {
		searchField.sendKeys(asin);
		searchField.submit();
		
		return new SearchResultPage(driver);
	}
	
	
}
