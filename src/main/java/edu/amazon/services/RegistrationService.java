package edu.amazon.services;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import edu.amazon.exceptions.RegistrationException;
import edu.amazon.models.Account;
import edu.amazon.models.pageobjects.BasePage;
import edu.amazon.models.pageobjects.MainPage;
import edu.amazon.models.pageobjects.RegistrationPage;
import edu.amazon.util.DriverProvider;

public class RegistrationService {	
	private WebDriver driver = DriverProvider.getDriver();
	
	public MainPage registerUser(Account account) throws RegistrationException {	
		
		try{
		BasePage startPage = new BasePage(driver);
		RegistrationPage registration = startPage.goToRegistrationPage();
		
		return registration.registerAccount(account);
		
		} catch(NoSuchElementException e) {
			throw new RegistrationException("Can't register user\n" + e.getMessage(), e);
		}
	}
}
