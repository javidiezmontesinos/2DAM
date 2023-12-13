package tema5;
import java.sql.*;
/**
 * Tabla 9 del tema 5
 * @author javid
 *
 */
public class tabla9 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/nombre_base_datos";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado del primer apellido de todos los empleados
            String consultaPrimerApellidoEmpleados = "SELECT apellido1 FROM empleado";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaPrimerApellidoEmpleados);

            System.out.println("Primer apellido de todos los empleados:");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("apellido1"));
            }
            System.out.println();

            // Listado del primer apellido de los empleados eliminando los apellidos repetidos
            String consultaPrimerApellidoUnico = "SELECT DISTINCT apellido1 FROM empleado";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaPrimerApellidoUnico);

            System.out.println("Primer apellido de empleados sin repetir:");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("apellido1"));
            }
            System.out.println();

            // Listado de todas las columnas de la tabla empleado
            String consultaTodasColumnasEmpleado = "SELECT * FROM empleado";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaTodasColumnasEmpleado);

            ResultSetMetaData metaData = resultSet3.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Todas las columnas de la tabla empleado:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Columna " + i + ": " + metaData.getColumnName(i));
            }
            System.out.println();

            // Listadi el nombre y los apellidos de todos los empleados
            String consultaNombreApellidosEmpleados = "SELECT nombre, apellido1, apellido2 FROM empleado";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaNombreApellidosEmpleados);

            System.out.println("Nombre y apellidos de todos los empleados:");
            while (resultSet4.next()) {
                System.out.println("Nombre: " + resultSet4.getString("nombre") +
                        ", Apellidos: " + resultSet4.getString("apellido1") + " " + resultSet4.getString("apellido2"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
