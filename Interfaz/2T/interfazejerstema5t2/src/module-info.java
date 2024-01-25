module ejerstema5t2 {
    requires javafx.controls;
    requires javafx.fxml;

    opens application to javafx.graphics, javafx.fxml;
    opens ejer5 to javafx.fxml;
    

    exports ejer2;
    exports ejer3;
    exports ejer4;
    exports ejer5;
    exports ejer6;
    exports ejer7;
    exports ejer8;
    exports ejer9;
    exports ejer10;
    
    
    
    opens ejer11 to javafx.fxml;
   
    exports ejer11;
    
    opens ejer12 to javafx.fxml;
    
    exports ejer12;
    
}
