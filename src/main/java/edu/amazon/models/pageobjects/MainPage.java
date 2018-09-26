package edu.amazon.models.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import edu.amazon.interfaces.ProductSearch;


public class MainPage extends AbstractPage implements ProductSearch {	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchField;
	
	protected MainPage(WebDriver driver) {
		super(driver);		
	}
}
