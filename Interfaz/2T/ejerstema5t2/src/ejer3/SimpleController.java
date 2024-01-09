package ejer3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SimpleController {

    @FXML
    public void handleButtonClick(ActionEvent event) {
        System.out.println("¡Ha pulsado el botón!");
    }
    
    @FXML
    public void pulsame(ActionEvent event) {
        System.out.println("¡Hssssa pulsado el botón!");
    }
}