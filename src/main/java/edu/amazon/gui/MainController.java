package edu.amazon.gui;

import java.util.List;

import edu.amazon.exceptions.RegistrationException;
import edu.amazon.models.Account;
import edu.amazon.models.Product;
import edu.amazon.services.RegistrationService;
import edu.amazon.services.SearchService;
import edu.amazon.util.ArgumentsValidator;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

@SuppressWarnings("restriction")
public class MainController {
	@FXML AnchorPane dialogWindow;
	@FXML TextField registrationNameField;
	@FXML TextField registrationPasswordField;
	@FXML TextField registrationEmailField;
	@FXML TextField productSearchField;
	@FXML TextField addToCartLoginField;
	@FXML TextField addToCartPasswordField;
	@FXML TextField addToCartAsinField;

	@FXML Label messageLabel = new Label("Message");

	@FXML Button proceedRegistrationButton;
	@FXML Button proceedProductSearchButton;
	@FXML Button addToCartButton;
	@FXML Button closeDialogButton;

	//private Logger logger = Logger.getLogger("Controller");

	@FXML
	void registerUser() {
		messageLabel.setWrapText(true);

		String userName = registrationNameField.getText();
		String password = registrationPasswordField.getText();
		String email = registrationPasswordField.getText();

		List<String> errors = ArgumentsValidator.validateRegistrationInput(userName, password, email);

		if(!errors.isEmpty()) {			
			messageLabel.setText(errors + " cannot be blank");
			dialogWindow.setVisible(true);
			return;
		}

		Account account = new Account(userName, password, email);

		if(proceedRegistration(account)){

			messageLabel.setText("Registration finished");
			dialogWindow.setVisible(true);
		}
	}

	@FXML
	void searchProduct() {
		String input = productSearchField.getText();
				
		if(input.isEmpty()) {
			messageLabel.setText("Input cannot be blank");
			dialogWindow.setVisible(true);			
			
			return;
		}
		
		SearchService finder = new SearchService();
		
		if(ArgumentsValidator.isUrl(input)) {
			Product finded = finder.findProductByLink(input);
		} else {
			Product finded = finder.findProductByText(input);
		}
	}

	@FXML
	void addProductToCart() {

	}

	@FXML
	void closeDialogWindow() {
		dialogWindow.setVisible(false);
	}


	private boolean proceedRegistration(Account account) {
		RegistrationService register = new RegistrationService();

		try {
			register.registerUser(account);
		} catch (RegistrationException e) {
			messageLabel.setText("Error on registering user: \n" + e.getMessage());
			dialogWindow.setVisible(true);
			return false;
		}

		return true;
	}

}
