package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import edu.amazon.interfaces.pagecomponents.OpenCart;
import edu.amazon.interfaces.pagecomponents.ProductSearch;


public class MainPage extends PageObject implements ProductSearch, OpenCart {	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchField;
	
	protected MainPage(WebDriver driver) {
		super(driver);		
	}
}
