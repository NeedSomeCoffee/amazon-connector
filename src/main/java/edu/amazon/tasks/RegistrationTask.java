package edu.amazon.tasks;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import edu.amazon.exceptions.RegistrationException;
import edu.amazon.interfaces.Logging;
import edu.amazon.models.Account;
import edu.amazon.models.pageobjects.BasePage;
import edu.amazon.models.pageobjects.MainPage;
import edu.amazon.models.pageobjects.RegistrationPage;
import edu.amazon.util.DriverProvider;

public class RegistrationTask implements Logging, Runnable {	
	private WebDriver driver;
	private Account account;
	
	public RegistrationTask(Account account) {
		driver = DriverProvider.getDriver();
		this.account = account;
	}
	
	@Override
	public void run() {		
		try{
		BasePage startPage = new BasePage(driver);
		RegistrationPage registration = startPage.goToRegistrationPage();
		
		registration.registerAccount(account);
		
		} catch(NoSuchElementException e) {
			logger.warning("Can't register user\n" + e.getMessage());
		}
	}
}
