package tema8;
import java.sql.*;
/**
 * Tabla 3 del tema 8
 * @author javid
 *
 */
public class tabla3 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tiendapc";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Insertar una nueva oficina en Almeria
            String insertarOficina = "INSERT INTO oficina (ciudad) VALUES ('Almería')";
            PreparedStatement statement1 = conexion.prepareStatement(insertarOficina);
            statement1.executeUpdate();
            System.out.println("Nueva oficina insertada en Almería");

            // Insertar un empleado para la oficina de Almeria que sea representante de ventas
            String insertarEmpleado = "INSERT INTO empleado (nombre, cargo, codigo_oficina) VALUES ('Representante', 'Ventas', (SELECT codigo_oficina FROM oficina WHERE ciudad = 'Almería'))";
            PreparedStatement statement2 = conexion.prepareStatement(insertarEmpleado);
            statement2.executeUpdate();
            System.out.println("Nuevo empleado representante de ventas insertado en la oficina de Almería");

            // Insertar un cliente que tenga como representante de ventas el empleado que hemos creado en el paso anterior
            String insertarCliente = "INSERT INTO cliente (nombre, codigo_empleado) VALUES ('Nuevo Cliente', (SELECT codigo_empleado FROM empleado WHERE nombre = 'Representante'))";
            PreparedStatement statement3 = conexion.prepareStatement(insertarCliente);
            statement3.executeUpdate();
            System.out.println("Nuevo cliente insertado con el representante de ventas asociado");

            // Insertar un pedido para el cliente que acabamos de crear, que contenga al menos dos productos
            String insertarPedido = "INSERT INTO pedido (codigo_cliente) VALUES ((SELECT codigo_cliente FROM cliente WHERE nombre = 'Nuevo Cliente'))";
            PreparedStatement statement4 = conexion.prepareStatement(insertarPedido, Statement.RETURN_GENERATED_KEYS);
            statement4.executeUpdate();
            ResultSet generatedKeys = statement4.getGeneratedKeys();
            int codigoPedido = -1;
            if (generatedKeys.next()) {
                codigoPedido = generatedKeys.getInt(1);
            }

            // Insertar detalles del pedido con al menos dos productos
            if (codigoPedido != -1) {
                String insertarDetallesPedido = "INSERT INTO detalle_pedido (codigo_pedido, codigo_producto, cantidad) VALUES (?, ?, ?)";
                PreparedStatement statement5 = conexion.prepareStatement(insertarDetallesPedido);
                statement5.setInt(1, codigoPedido);
                statement5.setInt(2, 1);
                statement5.setInt(3, 2); 
                statement5.executeUpdate();

                statement5.setInt(1, codigoPedido);
                statement5.setInt(2, 2); 
                statement5.setInt(3, 3);
                statement5.executeUpdate();
            }
            System.out.println("Nuevo pedido insertado para el cliente con al menos dos productos");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
