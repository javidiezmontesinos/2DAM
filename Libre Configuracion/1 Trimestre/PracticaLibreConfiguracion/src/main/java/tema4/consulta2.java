package tema4;
import java.sql.*;
/**
 * Ejercicio consulta 2 tema 4
 * @author javid
 *
 */
public class consulta2 {

    public static void main(String[] args) {
        try {
            // Conexión con la base de datos
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/instituto", "root", "basket10");

            // Consulta SQL para obtener el nombre y apellidos junto con su inversión
            String consulta = "SELECT CONCAT(nombre, ' ', apellidos) AS nombre_completo, CONCAT(REVERSE(nombre), ' ', REVERSE(apellidos)) AS nombre_completo_invertido FROM alumnos";

            // Crear la sentencia SQL
            Statement sentencia = conexion.createStatement();

            // Ejecutar la consulta
            ResultSet resultado = sentencia.executeQuery(consulta);

            // Mostrar  resultados
            while (resultado.next()) {
                String nombreCompleto = resultado.getString("nombre_completo");
                String nombreCompletoInvertido = resultado.getString("nombre_completo_invertido");
                System.out.println(nombreCompleto + " - " + nombreCompletoInvertido);
            }

            // Cerrar la conexión con la base de datos
            conexion.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

