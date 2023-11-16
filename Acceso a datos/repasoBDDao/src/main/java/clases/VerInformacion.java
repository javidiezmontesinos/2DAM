package clases;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerInformacion {
	static String login = "root";
	static String password = "";
	static String url = "jdbc:mysql://localhost:33306/empresa";

	public static void main(String[] args) throws Exception {
		Connection conn = null;
		try {
			// Desde aqui se encarga del driver JDBC
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, login, password);
			if (conn != null) {

				System.out.println("Conexión a BBDD " + url + " ...Ok");
				DatabaseMetaData meta = conn.getMetaData();
				System.out.println("Versión del driver JDBC " + meta.getDriverVersion());
				System.out.println("Nombre " + meta.getDatabaseProductName());
				System.out.println("Versión " + meta.getDatabaseProductVersion());
				ResultSet columnas = meta.getColumns("empresa", null, "clientes", null);
				System.out.println("Consulta realizada");
				System.out.println("BBDD empresa");
				System.out.println("Columna   tipo    tamaño");
				System.out.println("......................");
				while (columnas.next()) {
					String nombrecol = columnas.getString("COLUMN_NAME");
					String tipo = columnas.getString("TYPE_NAME");
					String tamcol = columnas.getString("COLUMN_SIZE");
					System.out.println(nombrecol + " " + tipo + " " + tamcol);
				}
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("Error");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("ERROR");
			e.printStackTrace();
		}

	}

}