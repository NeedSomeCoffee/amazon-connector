package edu.amazon.gui;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import static java.util.concurrent.CompletableFuture.runAsync;

import edu.amazon.models.Account;
import edu.amazon.models.Product;
import edu.amazon.tasks.PurchaseTask;
import edu.amazon.tasks.RegistrationTask;
import edu.amazon.tasks.SearchTask;
import edu.amazon.util.ArgumentsValidator;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


public class MainController {
	@FXML AnchorPane dialogWindow;
	@FXML TextField registrationNameField;
	@FXML TextField registrationPasswordField;
	@FXML TextField registrationEmailField;
	@FXML TextField productSearchField;
	@FXML TextField addToCartLoginField;
	@FXML TextField addToCartPasswordField;
	@FXML TextField addToCartTextField;

	@FXML Label messageLabel = new Label("Message");

	@FXML Button proceedRegistrationButton;
	@FXML Button proceedProductSearchButton;
	@FXML Button addToCartButton;
	@FXML Button closeDialogButton;

	private Logger logger = Logger.getLogger("Controller");

	@FXML
	void registerUser() {
		messageLabel.setWrapText(true);

		String userName = registrationNameField.getText();
		String password = registrationPasswordField.getText();
		String email = registrationEmailField.getText();

		List<String> errors = ArgumentsValidator.validateRegistrationInput(userName, password, email);

		if(!errors.isEmpty()) {			
			messageLabel.setText(errors + " cannot be blank");
			dialogWindow.setVisible(true);
			return;
		}

		Account account = new Account(userName, password, email);

		RegistrationTask register = new RegistrationTask(account);

		
		runTask(register, proceedRegistrationButton);

		}
	

	@FXML
	void searchProduct() {
		String input = productSearchField.getText();
				
		if(input.isEmpty()) {
			messageLabel.setText("Input can't be blank");
			dialogWindow.setVisible(true);			
			
			return;
		}
		
		SearchTask finder = new SearchTask();
		
		if(ArgumentsValidator.isUrl(input)) {
			Optional<Product> finded = finder.findProductByLink(input);
			logger.info(finded.get().toString());
		} else {
			Optional<Product> finded = finder.findProductByText(input);
			logger.info(finded.get().toString());
		}
	}

	@FXML
	void addProductToCart() {
		String query = addToCartTextField.getText();
		String login = addToCartLoginField.getText();
		String password = addToCartPasswordField.getText();
		
		List<String> errors = ArgumentsValidator.validateAddProductInput(query, login, password);

		if(!errors.isEmpty()) {			
			messageLabel.setText(errors + " cannot be blank");
			dialogWindow.setVisible(true);
			return;
		}
		
		PurchaseTask purchaser = new PurchaseTask(query);
		
		runTask(purchaser, addToCartButton) ;
	}

	@FXML
	void closeDialogWindow() {
		dialogWindow.setVisible(false);
	}

	
	private void runTask(Runnable task, Node button) {
	    button.setDisable(true);
	    runAsync(task).whenComplete((a, b) -> button.setDisable(false));
	  }

}
