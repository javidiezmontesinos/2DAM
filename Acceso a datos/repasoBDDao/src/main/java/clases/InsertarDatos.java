package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
public class InsertarDatos {
	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;  	
		String sql = "INSERT INTO productos (id, NombreProduct, Fabricante) " +
	             "VALUES (1, 'Portatil', 'HP')"+
	             "VALUES (2, 'Tablet', 'Lenovo')";
	try {
	  conn = DriverManager.getConnection(
	         "jdbc:mysql://localhost/TiendaPc","root","basket10");
	  stmt = conn.createStatement();
	  stmt.executeUpdate(sql);
	  System.out.println("Datos insertados en la tabla clientes");
	  conn.close();
	  stmt.close();
	} catch (SQLException e) {
	  e.printStackTrace();
	}
	}
}