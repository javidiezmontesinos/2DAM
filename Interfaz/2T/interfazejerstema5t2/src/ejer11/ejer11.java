package ejer11;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ejer11  extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("estilo11.fxml"));
	    Parent root = loader.load();

	    // Obtener el controlador después de cargar el FXML
	    SimpleController controller = loader.getController();

	    

	    primaryStage.setTitle("Ejercicio 11 layaouts");
	    primaryStage.setScene(new Scene(root, 600, 300));
	    primaryStage.show();
	}



}