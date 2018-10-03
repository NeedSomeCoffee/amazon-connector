package edu.amazon.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class ArgumentsValidatorTest {

	@Test
	public void givenValidHttpUrl_WhenChecked_ThenShouldReturnTrueTest() {
		String url = "http://amazon.com";
		
		assertTrue(ArgumentsValidator.isUrl(url));
	}
	
	@Test
	public void givenValidHttpsUrl_WhenChecked_ThenShouldReturnTrueTest() {
		String url = "https://amazon.com";
		
		assertTrue(ArgumentsValidator.isUrl(url));
	}
	
	@Test
	public void givenUrlWithSpace_WhenChecked_ThenShouldReturnFalseTest() {
		String url = "http://amazon.com aloe";
		
		assertTrue(ArgumentsValidator.isUrl(url));
	}
	
	@Test
	public void givenInvalidUrl_WhenChecked_ThenShouldReturnFalseTest() {
		String url = "dfgdfg://amazon.com aloe";
		
		assertTrue(ArgumentsValidator.isUrl(url));
	}

}
