package ejer4;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class SimpleController {

    @FXML
    public void handleButtonClick(ActionEvent event) {
        System.out.println("¡Ha pulsado el botón!");
    }
    
    @FXML
    public void pulsame1(ActionEvent event) {
        System.out.println("¡Hssssa pulsado el botón 1!");
    }
    public void pulsame2(ActionEvent event) {
        System.out.println("¡Hssssa pulsado el botón 2!");
    }
    public void pulsame3(ActionEvent event) {
        System.out.println("¡Hssssa pulsado el botón 3!");
    }
    public void pulsame4(ActionEvent event) {
        System.out.println("¡Hssssa pulsado el botón 4!");
    }
}