package ejer5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ejer5 extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("estilo5.fxml"));
		Parent root = loader.load();

		primaryStage.setTitle("Ejercicio 5 layaouts");
		primaryStage.setScene(new Scene(root, 600, 300));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}