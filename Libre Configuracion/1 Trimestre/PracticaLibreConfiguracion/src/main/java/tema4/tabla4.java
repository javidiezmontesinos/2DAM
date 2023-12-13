package tema4;
import java.sql.*;
/**
 * Tabla 4 del tema 4
 * @author javid
 *
 */
public class tabla4 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/jardineria";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Devuelve un listado con el código de oficina y la ciudad donde hay oficinas
            String consultaOficinas = "SELECT codigo_oficina, ciudad FROM oficinas";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaOficinas);

            System.out.println("Código de oficina y ciudad:");
            while (resultSet1.next()) {
                int codigoOficina = resultSet1.getInt("codigo_oficina");
                String ciudad = resultSet1.getString("ciudad");
                System.out.println("Código de oficina: " + codigoOficina + ", Ciudad: " + ciudad);
            }
            System.out.println();

            // Devuelve un listado con la ciudad y el teléfono de las oficinas de España
            String consultaOficinasEspaña = "SELECT ciudad, telefono FROM oficinas WHERE pais = 'España'";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaOficinasEspaña);

            System.out.println("Ciudad y teléfono de oficinas en España:");
            while (resultSet2.next()) {
                String ciudadEspaña = resultSet2.getString("ciudad");
                String telefono = resultSet2.getString("telefono");
                System.out.println("Ciudad: " + ciudadEspaña + ", Teléfono: " + telefono);
            }
            System.out.println();

            // Devuelve un listado con el nombre, apellidos y email de los empleados cuyo jefe tiene un código de jefe igual a 7
            String consultaEmpleadosJefe7 = "SELECT nombre, apellidos, email FROM empleados WHERE codigo_jefe = 7";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaEmpleadosJefe7);

            System.out.println("Empleados cuyo jefe tiene código de jefe igual a 7:");
            while (resultSet3.next()) {
                String nombre = resultSet3.getString("nombre");
                String apellidos = resultSet3.getString("apellidos");
                String email = resultSet3.getString("email");
                System.out.println("Nombre: " + nombre + ", Apellidos: " + apellidos + ", Email: " + email);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
