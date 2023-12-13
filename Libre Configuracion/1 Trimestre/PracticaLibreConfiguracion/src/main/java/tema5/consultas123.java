package tema5;
import java.sql.*;
/**
 * Consultas 1,2 y 3 del Tema 5
 * @author javid
 *
 */
public class consultas123 {

    public static void main(String[] args) {
    	//Conexion de la base datos
        String url = "jdbc:mysql://localhost/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Lista el nombre de todos los productos en la tabla producto
            String consultaNombresProductos = "SELECT nombre FROM producto";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaNombresProductos);

            System.out.println("Nombres de los productos:");
            while (resultSet1.next()) {
                String nombreProducto = resultSet1.getString("nombre");
                System.out.println(nombreProducto);
            }
            System.out.println();

            // Lista los nombres y los precios de todos los productos de la tabla producto
            String consultaNombresPrecios = "SELECT nombre, precio FROM producto";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaNombresPrecios);

            System.out.println("Nombres y precios de los productos:");
            while (resultSet2.next()) {
                String nombreProducto = resultSet2.getString("nombre");
                double precioProducto = resultSet2.getDouble("precio");
                System.out.println(nombreProducto + " - Precio: " + precioProducto);
            }
            System.out.println();

            // Lista todas las columnas de la tabla producto
            String consultaTodasColumnas = "SELECT * FROM producto";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaTodasColumnas);

            System.out.println("Todos los datos de la tabla producto:");
            while (resultSet3.next()) {
                int idProducto = resultSet3.getInt("id");
                String nombreProducto = resultSet3.getString("nombre");
                double precioProducto = resultSet3.getDouble("precio");
                // Agrega aquí todas las columnas que quieras mostrar

                System.out.println("ID: " + idProducto + ", Nombre: " + nombreProducto + ", Precio: " + precioProducto);
                // Muestra aquí todas las columnas que quieras mostrar
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

