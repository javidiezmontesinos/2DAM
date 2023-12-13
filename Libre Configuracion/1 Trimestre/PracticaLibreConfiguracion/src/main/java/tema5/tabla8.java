package tema5;
import java.sql.*;
/**
 * Tabla 8 del tema 5
 * @author javid
 *
 */
public class tabla8 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado de los nombres de todos los productos que hay en la tabla producto
            String consultaNombresProductos = "SELECT nombre FROM producto";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaNombresProductos);

            System.out.println("Nombres de todos los productos:");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("nombre"));
            }
            System.out.println();

            // Listado de los nombres y los precios de todos los productos de la tabla producto
            String consultaNombresPreciosProductos = "SELECT nombre, precio FROM producto";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaNombresPreciosProductos);

            System.out.println("Nombres y precios de todos los productos:");
            while (resultSet2.next()) {
                System.out.println("Nombre: " + resultSet2.getString("nombre") + ", Precio: " + resultSet2.getDouble("precio"));
            }
            System.out.println();

            // Listado de todas las columnas de la tabla producto
            String consultaTodasColumnasProductos = "SELECT * FROM producto";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaTodasColumnasProductos);

            ResultSetMetaData metaData = resultSet3.getMetaData();
            int columnCount = metaData.getColumnCount();
            System.out.println("Todas las columnas de la tabla producto:");
            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Columna " + i + ": " + metaData.getColumnName(i));
            }
            System.out.println();

            // Listado de el nombre de los productos, el precio en euros y el precio en dolares
            String consultaPreciosEnDolares = "SELECT nombre, precio, precio * tipo_cambio AS precio_usd FROM producto";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaPreciosEnDolares);

            System.out.println("Nombre, Precio en Euros, Precio en USD:");
            while (resultSet4.next()) {
                System.out.println("Nombre: " + resultSet4.getString("nombre") +
                        ", Precio EUR: " + resultSet4.getDouble("precio") +
                        ", Precio USD: " + resultSet4.getDouble("precio_usd"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
