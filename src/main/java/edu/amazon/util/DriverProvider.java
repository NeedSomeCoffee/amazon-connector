package edu.amazon.util;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverProvider {
	
	private DriverProvider () {}
	
	static {
		System.setProperty("webdriver.chrome.driver", new File("src/main/resources/drivers/chromedriver/chromedriver.exe").getAbsolutePath());
	}
	
	public static WebDriver getDriver () {		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		return driver;
	}
}
