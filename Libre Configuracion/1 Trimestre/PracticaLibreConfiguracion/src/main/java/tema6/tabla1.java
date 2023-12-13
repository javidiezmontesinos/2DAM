package tema6;
import java.sql.*;
/**
 * Tabla 1 del tema 6
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
            // Numero total de productos en la tabla productos
            String consultaTotalProductos = "SELECT COUNT(*) AS total_productos FROM productos";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaTotalProductos);

            if (resultSet1.next()) {
                int totalProductos = resultSet1.getInt("total_productos");
                System.out.println("Número total de productos: " + totalProductos);
            }
            System.out.println();

            // Numero total de fabricantes en la tabla fabricante
            String consultaTotalFabricantes = "SELECT COUNT(*) AS total_fabricantes FROM fabricante";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaTotalFabricantes);

            if (resultSet2.next()) {
                int totalFabricantes = resultSet2.getInt("total_fabricantes");
                System.out.println("Número total de fabricantes: " + totalFabricantes);
            }
            System.out.println();

            // Numero de valores distintos de código de fabricante en la tabla productos
            String consultaValoresDistintosFabricante = "SELECT COUNT(DISTINCT codigo_fabricante) AS distintos_fabricante FROM productos";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaValoresDistintosFabricante);

            if (resultSet3.next()) {
                int valoresDistintosFabricante = resultSet3.getInt("distintos_fabricante");
                System.out.println("Número de valores distintos de código de fabricante en productos: " + valoresDistintosFabricante);
            }
            System.out.println();

            // Media del precio de todos los productos
            String consultaMediaPrecio = "SELECT AVG(precio) AS media_precio FROM productos";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaMediaPrecio);

            if (resultSet4.next()) {
                double mediaPrecio = resultSet4.getDouble("media_precio");
                System.out.println("Media del precio de todos los productos: " + mediaPrecio);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

