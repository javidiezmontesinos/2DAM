package tema5;
import java.sql.*;
/**
 * Tabla 11 del tema 5
 * @author javid
 *
 */
public class tabla11 {
	
    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado de clientes que han realizado algún pedido
            String consultaClientesConPedidos = "SELECT DISTINCT c.id_cliente, c.nombre, c.apellidos FROM clientes c INNER JOIN pedidos p ON c.id_cliente = p.id_cliente ORDER BY c.nombre, c.apellidos";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaClientesConPedidos);

            System.out.println("Clientes que han realizado algún pedido:");
            while (resultSet1.next()) {
                System.out.println("ID: " + resultSet1.getInt("id_cliente") +
                        ", Nombre: " + resultSet1.getString("nombre") +
                        ", Apellidos: " + resultSet1.getString("apellidos"));
            }
            System.out.println();

            // Listado de todos los pedidos realizados por cada cliente
            String consultaPedidosPorCliente = "SELECT c.*, p.* FROM clientes c INNER JOIN pedidos p ON c.id_cliente = p.id_cliente ORDER BY c.nombre, c.apellidos";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaPedidosPorCliente);

            System.out.println("Pedidos realizados por cada cliente:");
            while (resultSet2.next()) {
                System.out.println("ID Cliente: " + resultSet2.getInt("id_cliente") +
                        ", Nombre Cliente: " + resultSet2.getString("nombre") +
                        ", Apellidos Cliente: " + resultSet2.getString("apellidos") +
                        ", ID Pedido: " + resultSet2.getInt("id_pedido") +
                        ", Otros datos pedido: " /* Mostrar los otros datos del pedido */);
            }
            System.out.println();

            // Listado de todos los pedidos en los que ha participado un comercial
            String consultaPedidosComerciales = "SELECT com.*, ped.* FROM comerciales com INNER JOIN pedidos ped ON com.id_comercial = ped.id_comercial ORDER BY com.nombre_comercial";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaPedidosComerciales);

            System.out.println("Pedidos en los que ha participado un comercial:");
            while (resultSet3.next()) {
                System.out.println("ID Comercial: " + resultSet3.getInt("id_comercial") +
                        ", Nombre Comercial: " + resultSet3.getString("nombre_comercial") + 
                        ", ID Pedido: " + resultSet3.getInt("id_pedido") +
                        ", Otros datos pedido: " );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

