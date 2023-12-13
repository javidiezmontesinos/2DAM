package tema8;
import java.sql.*;
/**
 * Tabla 1 del tema 8
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
            // Insertar un nuevo fabricante indicando su codigo y nombre
            String insertarFabricanteCodigoNombre = "INSERT INTO fabricante (codigo_fabricante, nombre) VALUES (?, ?)";
            PreparedStatement statement1 = conexion.prepareStatement(insertarFabricanteCodigoNombre);
            statement1.setInt(1, 101); 
            statement1.setString(2, "Nuevo Fabricante 1"); 
            statement1.executeUpdate();
            System.out.println("Nuevo fabricante insertado con código y nombre");

            // Insertar un nuevo fabricante indicando solamente su nombre
            String insertarFabricanteNombre = "INSERT INTO fabricante (nombre) VALUES (?)";
            PreparedStatement statement2 = conexion.prepareStatement(insertarFabricanteNombre);
            statement2.setString(1, "Nuevo Fabricante 2");
            statement2.executeUpdate();
            System.out.println("Nuevo fabricante insertado con nombre");

            // Insertar un nuevo producto asociado a uno de los nuevos fabricantes (con código, nombre, precio y código_fabricante)
            String insertarProductoConCodigo = "INSERT INTO producto (codigo_producto, nombre_producto, precio, codigo_fabricante) VALUES (?, ?, ?, ?)";
            PreparedStatement statement3 = conexion.prepareStatement(insertarProductoConCodigo);
            statement3.setInt(1, 1001); 
            statement3.setString(2, "Nuevo Producto 1");
            statement3.setDouble(3, 99.99); 
            statement3.setInt(4, 101); 
            statement3.executeUpdate();
            System.out.println("Nuevo producto insertado con código, nombre, precio y código de fabricante");

            // Insertar un nuevo producto asociado a uno de los nuevos fabricantes (con nombre, precio y código_fabricante)
            String insertarProductoSinCodigo = "INSERT INTO producto (nombre_producto, precio, codigo_fabricante) VALUES (?, ?, ?)";
            PreparedStatement statement4 = conexion.prepareStatement(insertarProductoSinCodigo);
            statement4.setString(1, "Nuevo Producto 2");
            statement4.setDouble(2, 49.99); 
            statement4.setInt(3, 102); 
            statement4.executeUpdate();
            System.out.println("Nuevo producto insertado con nombre, precio y código de fabricante");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

