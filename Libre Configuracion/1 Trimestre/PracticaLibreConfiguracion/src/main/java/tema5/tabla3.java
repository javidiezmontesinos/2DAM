package tema5;
import java.sql.*;
/**
 * Tabla 3 del Tema 5
 * @author javid
 *
 */
public class tabla3 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado de clientes que han realizado algún pedido 
            String consultaClientesPedidosSQL1 = "SELECT DISTINCT c.id_cliente, c.nombre, c.apellidos " +
                    "FROM clientes c, pedidos p WHERE c.id_cliente = p.id_cliente ORDER BY c.nombre, c.apellidos";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaClientesPedidosSQL1);

            System.out.println("Clientes que han realizado algún pedido (SQL-92):");
            while (resultSet1.next()) {
                int idCliente = resultSet1.getInt("id_cliente");
                String nombre = resultSet1.getString("nombre");
                String apellidos = resultSet1.getString("apellidos");

                System.out.println("ID Cliente: " + idCliente + ", Nombre: " + nombre + ", Apellidos: " + apellidos);
            }
            System.out.println();

            // Listado de pedidos de cada cliente
            String consultaPedidosClientesSQL2 = "SELECT * FROM clientes c LEFT JOIN pedidos p ON c.id_cliente = p.id_cliente ORDER BY c.nombre, c.apellidos";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaPedidosClientesSQL2);

            System.out.println("Pedidos realizados por cada cliente (SQL-99):");
            while (resultSet2.next()) {
                
                int idCliente = resultSet2.getInt("c.id_cliente");
                String nombreCliente = resultSet2.getString("c.nombre");
                String apellidosCliente = resultSet2.getString("c.apellidos");
                int idPedido = resultSet2.getInt("p.id_pedido");
                System.out.println("ID Cliente: " + idCliente + ", Nombre: " + nombreCliente + ", Apellidos: " + apellidosCliente +
                        ", ID Pedido: " + idPedido);
            }
            System.out.println();

            // Listado de pedidos en los que ha participado un comercial
            String consultaPedidosComercialSQL1 = "SELECT * FROM comerciales c, pedidos p WHERE c.id_comercial = p.id_comercial ORDER BY c.nombre, c.apellidos";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaPedidosComercialSQL1);

            System.out.println("Pedidos en los que ha participado un comercial (SQL-92):");
            while (resultSet3.next()) {
                int idComercial = resultSet3.getInt("c.id_comercial");
                String nombreComercial = resultSet3.getString("c.nombre");
                String apellidosComercial = resultSet3.getString("c.apellidos");
                int idPedido = resultSet3.getInt("p.id_pedido");
                System.out.println("ID Comercial: " + idComercial + ", Nombre: " + nombreComercial + ", Apellidos: " + apellidosComercial +
                        ", ID Pedido: " + idPedido);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
