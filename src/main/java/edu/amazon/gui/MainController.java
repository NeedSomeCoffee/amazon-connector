package edu.amazon.gui;

import edu.amazon.models.Account;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

@SuppressWarnings("restriction")
public class MainController {
	@FXML TextField registrationNameField;
	@FXML TextField registrationPasswordField;
	@FXML TextField registrationEmailField;
	@FXML TextField productSerachField;
	@FXML TextField addToCartLoginField;
	@FXML TextField addToCartPasswordField;
	@FXML TextField addToCartAsinField;
	
	@FXML Button proceedRegistrationButton;
	@FXML Button proceedProductSearchButton;
	@FXML Button addToCartButton;
	
	
	@FXML
	void registerUser() {
		String userName = registrationNameField.getText();
		String password = registrationPasswordField.getText();
		String email = registrationPasswordField.getText();
		
		Account acc = new Account(userName, password, email);
		
		System.out.println(acc);
	}
	
	@FXML
	void searchProduct() {
		
	}
	
	@FXML
	void addProductToCart() {
		
	}
}
