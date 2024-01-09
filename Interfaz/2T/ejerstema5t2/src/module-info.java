module ejerstema5t2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.graphics, javafx.fxml;
    opens ejer5 to javafx.fxml;

    exports ejer2;
    exports ejer3;
    exports ejer4;
    exports ejer5;
}
