package edu.amazon.util;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ArgumentsValidator {
	
	private ArgumentsValidator() {}
	
	public static List<String> validateRegistrationInput(String login, String password, String email) {
		List<String> failedFields = new ArrayList<>();
		
		if(login.isEmpty()) {
			failedFields.add("Login");
		}
		
		if(password.isEmpty()) {
			failedFields.add("Password");
		}
		
		if(email.isEmpty()) {
			failedFields.add("Email");
		}
		
		return failedFields;
	}
	
	public static boolean isUrl(String input) {
		try { 
            new URL(input).toURI(); 
            return true; 
        } 

        catch (Exception e) { 
            return false; 
        } 
	}
}
