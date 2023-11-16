package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearTabla {
	public static void main(String[] args) throws Exception {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;  	
		String sql="CREATE TABLE productos (id INT PRIMARY KEY,"
				+ "NombreProduct VARCHAR(40) NOT NULL, "
				+ "Fabricante VARCHAR(30))";   	 
		try {
		  conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/TiendaPc","root","basket10");
		  stmt = conn.createStatement();
		  stmt.execute(sql);
		  System.out.println("Creada la tabla");
		  conn.close();
		  stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
}
