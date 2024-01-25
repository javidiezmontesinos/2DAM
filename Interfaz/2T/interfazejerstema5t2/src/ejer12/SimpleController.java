package ejer12;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class SimpleController {

    @FXML
    private TextField importeTextField;

    @FXML
    private Label resultadoLabel;

    @FXML
    private void calcularResultado() {
        try {
            double importe = Double.parseDouble(importeTextField.getText());
            double result = importe; // Add your main calculation logic here
            resultadoLabel.setText("Result: " + result);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Invalid input");
        }
    }

    @FXML
    private void iva4() {
        try {
            double importe = Double.parseDouble(importeTextField.getText());
            double iva = importe * 0.04;
            double result = importe + iva;
            resultadoLabel.setText("IVA 4%: " + result);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Invalid input");
        }
    }

    @FXML
    private void iva10() {
        try {
            double importe = Double.parseDouble(importeTextField.getText());
            double iva = importe * 0.10;
            double result = importe + iva;
            resultadoLabel.setText("IVA 10%: " + result);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Invalid input");
        }
    }

    @FXML
    private void iva21() {
        try {
            double importe = Double.parseDouble(importeTextField.getText());
            double iva = importe * 0.21;
            double result = importe + iva;
            resultadoLabel.setText("IVA 21%: " + result);
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Invalid input");
        }
    }

    @FXML
    private void limpiar() {
        importeTextField.clear();
        resultadoLabel.setText("-");
    }

    @FXML
    private void salir() {
        
        System.exit(0); 
    }
}
