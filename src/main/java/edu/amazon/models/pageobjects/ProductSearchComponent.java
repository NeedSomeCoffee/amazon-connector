package edu.amazon.models.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductSearchComponent {
	private By locator = By.id("twotabsearchtextbox");
	
	public SearchResultPage searchProductByAsin(WebDriver driver, String asin) {
		WebElement searchField = driver.findElement(locator);
		searchField.sendKeys(asin);
		searchField.submit();
		
		return new SearchResultPage(driver);
	}
}
