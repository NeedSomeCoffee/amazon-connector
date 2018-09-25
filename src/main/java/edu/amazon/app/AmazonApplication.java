package edu.amazon.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AmazonApplication extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception{
		Parent root = FXMLLoader.load(getClass().getResource("/fxml/MainStage.fxml"));
		primaryStage.setTitle("Amazon tool");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
