package tema5;
import java.sql.*;
/**
 * Tabla 2 del tema 5
 * @author javid
 *
 */
public class tabla2 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado de todos los fabricantes con sus productos
            String consultaFabricantesProductos = "SELECT f.id_fabricante, f.nombre AS nombre_fabricante, p.id_producto, p.nombre AS nombre_producto " +
                    "FROM fabricantes f LEFT JOIN productos p ON f.id_fabricante = p.id_fabricante";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaFabricantesProductos);

            System.out.println("Listado de fabricantes y sus productos:");
            while (resultSet1.next()) {
                int idFabricante = resultSet1.getInt("id_fabricante");
                String nombreFabricante = resultSet1.getString("nombre_fabricante");
                int idProducto = resultSet1.getInt("id_producto");
                String nombreProducto = resultSet1.getString("nombre_producto");

                System.out.println("ID Fabricante: " + idFabricante + ", Fabricante: " + nombreFabricante +
                        ", ID Producto: " + idProducto + ", Producto: " + nombreProducto);
            }
            System.out.println();

            // listado de fabricantes que no tienen productos asociados 
            String consultaFabricantesSinProductos = "SELECT f.id_fabricante, f.nombre AS nombre_fabricante " +
                    "FROM fabricantes f LEFT JOIN productos p ON f.id_fabricante = p.id_fabricante " +
                    "WHERE p.id_producto IS NULL";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaFabricantesSinProductos);

            System.out.println("Fabricantes sin productos asociados:");
            while (resultSet2.next()) {
                int idFabricante = resultSet2.getInt("id_fabricante");
                String nombreFabricante = resultSet2.getString("nombre_fabricante");

                System.out.println("ID Fabricante: " + idFabricante + ", Fabricante: " + nombreFabricante);
            }
            System.out.println();

            // Listado de fabricantes que no tienen ningún producto asociado
            String consultaFabricantesSinProductosRightJoin = "SELECT f.id_fabricante, f.nombre AS nombre_fabricante " +
                    "FROM fabricantes f RIGHT JOIN productos p ON f.id_fabricante = p.id_fabricante " +
                    "WHERE f.id_fabricante IS NULL";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaFabricantesSinProductosRightJoin);

            System.out.println("Fabricantes sin productos asociados (RIGHT JOIN):");
            while (resultSet3.next()) {
                int idFabricante = resultSet3.getInt("id_fabricante");
                String nombreFabricante = resultSet3.getString("nombre_fabricante");

                System.out.println("ID Fabricante: " + idFabricante + ", Fabricante: " + nombreFabricante);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
