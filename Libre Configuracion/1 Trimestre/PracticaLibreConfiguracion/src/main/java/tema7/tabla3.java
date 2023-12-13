package tema7;
import java.sql.*;

public class tabla3 {
	/**
	 * Tabla 3 del tema 7
	 * @param args
	 */
    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tiendapc";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Clientes que no han realizado ni un pago
            String consultaClientesSinPago = "SELECT * FROM cliente WHERE NOT EXISTS (SELECT * FROM pago WHERE codigo_cliente = cliente.codigo_cliente)";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaClientesSinPago);

            System.out.println("Clientes que no han realizado ningún pago:");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("nombre_cliente"));
            }
            System.out.println();

            // Clientes que han realizado algun pago
            String consultaClientesConPago = "SELECT * FROM cliente WHERE EXISTS (SELECT * FROM pago WHERE codigo_cliente = cliente.codigo_cliente)";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaClientesConPago);

            System.out.println("Clientes que han realizado algún pago:");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("nombre_cliente"));
            }
            System.out.println();

            // Productos que nunca han aparecido en un pedido
            String consultaProductosSinPedido = "SELECT * FROM producto WHERE NOT EXISTS (SELECT * FROM detalle_pedido WHERE codigo_producto = producto.codigo_producto)";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaProductosSinPedido);

            System.out.println("Productos que nunca han aparecido en un pedido:");
            while (resultSet3.next()) {
                System.out.println(resultSet3.getString("nombre_producto"));
            }
            System.out.println();

            // Productos que han aparecido en algun pedido
            String consultaProductosConPedido = "SELECT * FROM producto WHERE EXISTS (SELECT * FROM detalle_pedido WHERE codigo_producto = producto.codigo_producto)";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaProductosConPedido);

            System.out.println("Productos que han aparecido en algún pedido:");
            while (resultSet4.next()) {
                System.out.println(resultSet4.getString("nombre_producto"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
