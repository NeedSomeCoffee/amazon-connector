package edu.amazon.services;

import org.openqa.selenium.WebDriver;

import edu.regparsing.models.Account;
import edu.regparsing.models.pageobjects.BasePage;
import edu.regparsing.models.pageobjects.MainPage;
import edu.regparsing.models.pageobjects.RegistrationPage;

public class RegistrationService {	
	WebDriver driver = DriverProvider.getDriver();
	
	public void registerUser(Account account) {		
		BasePage startPage = new BasePage(driver);
		RegistrationPage registration = startPage.goToRegistrationPage();
		
		MainPage main = registration.registerAccount(account);
		
		main.skip();
	}
}
