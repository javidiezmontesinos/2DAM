package tema4;
import java.sql.*;
/**
 * Tabla 3 del Tema 4
 * @author javid
 *
 */
public class tabla3 {

    public static void main(String[] args) {
    	// Conexion base de datos
        String url = "jdbc:mysql://localhost:3306/instituto";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Lista el primer apellido de todos los empleados
            String consultaApellidos = "SELECT apellido1 FROM empleado";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaApellidos);

            System.out.println("Primer apellido de todos los empleados:");
            while (resultSet1.next()) {
                String apellido = resultSet1.getString("apellido1");
                System.out.println(apellido);
            }
            System.out.println();

            // Lista el primer apellido de los empleados eliminando los apellidos repetidos
            String consultaApellidosUnicos = "SELECT DISTINCT apellido1 FROM empleado";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaApellidosUnicos);

            System.out.println("Primer apellido de empleados sin duplicados:");
            while (resultSet2.next()) {
                String apellidoUnico = resultSet2.getString("apellido1");
                System.out.println(apellidoUnico);
            }
            System.out.println();

            // Lista todas las columnas de la tabla empleado
            String consultaTodasColumnas = "SELECT * FROM empleado";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaTodasColumnas);

            ResultSetMetaData metaData = resultSet3.getMetaData();
            int columnCount = metaData.getColumnCount();

            System.out.println("Todas las columnas de la tabla empleado:");
            while (resultSet3.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = metaData.getColumnName(i);
                    Object value = resultSet3.getObject(i);
                    System.out.println(columnName + ": " + value);
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
