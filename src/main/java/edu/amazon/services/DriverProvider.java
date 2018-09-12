package edu.amazon.services;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {
	
	public static WebDriver getDriver () {		
		System.setProperty("webdriver.chrome.driver", new File("src/main/resources/drivers/chromedriver/chromedriver.exe").getAbsolutePath());
		
		return new ChromeDriver();
	}
}
