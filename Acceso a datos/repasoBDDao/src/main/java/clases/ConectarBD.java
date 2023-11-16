package clases;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConectarBD {

	public static void main(String[] args) {
		
		Connection conect = null;
		try {

			conect = DriverManager.getConnection("jdbc:mysql://localhost/phoneland", "root", "basket10");
			if (conect != null) {
				System.out.println("Conexion a la base de datos ok");
				conect.close();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return;

	}

}
