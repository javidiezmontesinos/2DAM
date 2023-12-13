package tema7;
import java.sql.*;
/**
 * Tabla 2 del tema 7
 * @author javid
 *
 */
public class tabla2 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tiendapc";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Producto mas caro sin usar MAX, ORDER BY ni LIMIT
            String consultaProductoMasCaro = "SELECT nombre_producto FROM productos WHERE precio >= ALL (SELECT precio FROM productos)";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaProductoMasCaro);

            if (resultSet1.next()) {
                System.out.println("Producto más caro: " + resultSet1.getString("nombre_producto"));
            }
            System.out.println();

            // Producto mas barato sin usar MIN, ORDER BY ni LIMIT
            String consultaProductoMasBarato = "SELECT nombre_producto FROM productos WHERE precio <= ALL (SELECT precio FROM productos)";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaProductoMasBarato);

            if (resultSet2.next()) {
                System.out.println("Producto más barato: " + resultSet2.getString("nombre_producto"));
            }
            System.out.println();

            // Nombres de fabricantes con productos asociados utilizando IN
            String consultaFabricantesConProductos = "SELECT DISTINCT fabricante FROM productos WHERE fabricante IN (SELECT DISTINCT fabricante FROM productos)";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaFabricantesConProductos);

            System.out.println("Fabricantes con productos asociados:");
            while (resultSet3.next()) {
                System.out.println(resultSet3.getString("fabricante"));
            }
            System.out.println();

            // Nombres de fabricantes sin productos asociados utilizando NOT IN
            String consultaFabricantesSinProductos = "SELECT DISTINCT fabricante FROM productos WHERE fabricante NOT IN (SELECT DISTINCT fabricante FROM productos)";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaFabricantesSinProductos);

            System.out.println("Fabricantes sin productos asociados:");
            while (resultSet4.next()) {
                System.out.println(resultSet4.getString("fabricante"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
