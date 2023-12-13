package tema7;
import java.sql.*;
/**
 * Tabla 1 del Tema 7
 * @author javid
 *
 */
public class tabla1 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
    	String url = "jdbc:mysql://localhost:3306/tiendapc";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Devuelve todos los productos del fabricante Lenovo
            String consultaProductosLenovo = "SELECT * FROM productos WHERE fabricante = 'Lenovo'";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaProductosLenovo);

            System.out.println("Productos del fabricante Lenovo:");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("nombre_producto"));
            }
            System.out.println();

            // Devuelve todos los datos de los productos con el mismo precio que el producto mas caro del fabricante Lenovo
            String consultaProductosMismoPrecioLenovo = "SELECT * FROM productos WHERE precio = (SELECT MAX(precio) FROM productos WHERE fabricante = 'Lenovo')";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaProductosMismoPrecioLenovo);

            System.out.println("Productos con el mismo precio que el más caro de Lenovo:");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("nombre_producto"));
            }
            System.out.println();

            // Lista el nombre del producto más caro del fabricante Lenovo
            String consultaProductoMasCaroLenovo = "SELECT nombre_producto FROM productos WHERE precio = (SELECT MAX(precio) FROM productos WHERE fabricante = 'Lenovo')";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaProductoMasCaroLenovo);

            if (resultSet3.next()) {
                System.out.println("Producto más caro de Lenovo: " + resultSet3.getString("nombre_producto"));
            }
            System.out.println();

            // Lista el nombre del producto más barato del fabricante Hewlett-Packard
            String consultaProductoMasBaratoHP = "SELECT nombre_producto FROM productos WHERE precio = (SELECT MIN(precio) FROM productos WHERE fabricante = 'Hewlett-Packard')";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaProductoMasBaratoHP);

            if (resultSet4.next()) {
                System.out.println("Producto más barato de Hewlett-Packard: " + resultSet4.getString("nombre_producto"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

