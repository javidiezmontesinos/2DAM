module InterfacesAvanzadosT5 {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.graphics;
	
	opens ejerCalculadora to javafx.graphics, javafx.fxml;
	opens ejerVideojuegos to javafx.graphics, javafx.fxml;
	 exports ejerCalculadora;
	 exports ejerVideojuegos;
	 opens ejerHilos to javafx.graphics, javafx.fxml;
	 exports ejerHilos;
}
