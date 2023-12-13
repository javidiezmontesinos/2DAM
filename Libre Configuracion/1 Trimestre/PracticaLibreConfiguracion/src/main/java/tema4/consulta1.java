package tema4;
import java.sql.*;
/**
 * Ejercicio Consulta 1 tema4
 * @author javid
 *
 */
public class consulta1 {
	
    public static void main(String[] args) {
        try {
            // Conexion con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto", "root", "basket10");

            // Consulta SQL para obtener el nombre y su inversión
            String consulta = "SELECT nombre, REVERSE(nombre) AS nombre_invertido FROM alumnos";

            // Crear la sentencia SQL
            Statement sentencia = conexion.createStatement();

            // Ejecutar la consulta
            ResultSet resultado = sentencia.executeQuery(consulta);

            // Mostrar resultados
            while (resultado.next()) {
                String nombre = resultado.getString("nombre");
                String nombreInvertido = resultado.getString("nombre_invertido");
                System.out.println(nombre + " - " + nombreInvertido);
            }

            // Cerrar conexion con la base de datos
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
