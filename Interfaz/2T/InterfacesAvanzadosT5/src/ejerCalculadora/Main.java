package ejerCalculadora;
	
import ejerCalculadora.SimpleController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	    FXMLLoader loader = new FXMLLoader(getClass().getResource("estilocalcu.fxml"));
	    Parent root = loader.load();

	    // Obtener el controlador después de cargar el FXML
	    SimpleController controller = loader.getController();


	    primaryStage.setTitle("Ejer Calcu Avanzado");
	    primaryStage.setScene(new Scene(root, 600, 300));
	    primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}