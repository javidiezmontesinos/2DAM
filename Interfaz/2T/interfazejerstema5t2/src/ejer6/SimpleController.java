package ejer6;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class SimpleController {

	@FXML
	private Button boton;

	@FXML
	private void handleButtonClick(ActionEvent event) {
		String idBotonPulsado = ((Button) event.getSource()).getId();
		System.out.println("Informacion del usuario enviada: " + idBotonPulsado);

	}
}