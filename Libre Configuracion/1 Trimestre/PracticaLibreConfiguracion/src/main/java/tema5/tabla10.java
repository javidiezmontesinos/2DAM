package tema5;
import java.sql.*;

public class tabla10 {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // 1. Lista el primer apellido de todos los empleados
            String consultaPrimerApellido = "SELECT apellido1 FROM empleado";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaPrimerApellido);

            System.out.println("Primer apellido de todos los empleados:");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("apellido1"));
            }
            System.out.println();

            // 2. Lista el primer apellido de los empleados eliminando los apellidos repetidos
            String consultaPrimerApellidoUnico = "SELECT DISTINCT apellido1 FROM empleado";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaPrimerApellidoUnico);

            System.out.println("Primer apellido de empleados sin repetir:");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("apellido1"));
            }
            System.out.println();

            // 3. Lista todas las columnas de la tabla empleado
            DatabaseMetaData metaData = conexion.getMetaData();
            ResultSet resultSet3 = metaData.getColumns(null, null, "empleado", null);

            System.out.println("Todas las columnas de la tabla empleado:");
            while (resultSet3.next()) {
                System.out.println("Nombre columna: " + resultSet3.getString("COLUMN_NAME"));
            }
            System.out.println();

            // 4. Lista el nombre y los apellidos de todos los empleados
            String consultaNombresApellidos = "SELECT nombre, apellido1, apellido2 FROM empleado";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaNombresApellidos);

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
