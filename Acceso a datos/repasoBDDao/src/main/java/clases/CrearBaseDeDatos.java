package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CrearBaseDeDatos {
	public static void main(String[] args) throws SQLException {
		// TODO Esbozo de método generado automáticamente
		Connection conn = null;
		Statement stmt = null;  	
		String sql="CREATE DATABASE TiendaPc;";  	 

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/","root","basket10");
			stmt = conn.createStatement();
			stmt.execute(sql);
			System.out.println("Creada la base de datos ");
				
			conn.close();
			stmt.close();
		} catch (SQLException e) {
			// TODO Bloque catch generado automáticamente
			e.printStackTrace();
		}
	}
}