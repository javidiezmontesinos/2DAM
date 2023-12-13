package tema5;
import java.sql.*;
/**
 * Tabla 6 del tema 5
 * @author javid
 *
 */
public class tabla6 {
	
    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado que muestre solamente los clientes que no han realizado ningún pago
            String consultaClientesSinPagos = "SELECT c.* FROM clientes c LEFT JOIN pagos p ON c.id_cliente = p.id_cliente WHERE p.id_pago IS NULL";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaClientesSinPagos);

            System.out.println("Clientes que no han realizado ningún pago (LEFT JOIN):");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("nombre") + " " + resultSet1.getString("apellidos"));
            }
            System.out.println();

            // Listado que muestre solamente los clientes que no han realizado ningún pedido
            String consultaClientesSinPedidos = "SELECT c.* FROM pedidos p RIGHT JOIN clientes c ON c.id_cliente = p.id_cliente WHERE p.id_pedido IS NULL";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaClientesSinPedidos);

            System.out.println("Clientes que no han realizado ningún pedido (RIGHT JOIN):");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("nombre") + " " + resultSet2.getString("apellidos"));
            }
            System.out.println();

            // Listado que muestre los clientes que no han realizado ningún pago y ningún pedido
            String consultaClientesSinPagosPedidos = "SELECT c.* FROM clientes c NATURAL LEFT JOIN pagos p NATURAL RIGHT JOIN pedidos pe WHERE p.id_pago IS NULL AND pe.id_pedido IS NULL";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaClientesSinPagosPedidos);

            System.out.println("Clientes que no han realizado ningún pago y ningún pedido (NATURAL LEFT JOIN y NATURAL RIGHT JOIN):");
            while (resultSet3.next()) {
                // Mostrar los datos del cliente
                // Asegúrate de ajustar los nombres de las columnas según la estructura de tu tabla clientes
                System.out.println(resultSet3.getString("nombre") + " " + resultSet3.getString("apellidos"));
            }
            System.out.println();

            // Listado que muestre solamente los empleados que no tienen un jefe asociado
            String consultaEmpleadosSinJefe = "SELECT e.* FROM empleados e LEFT JOIN empleados j ON e.id_jefe = j.id_empleado WHERE j.id_empleado IS NULL";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaEmpleadosSinJefe);

            System.out.println("Empleados que no tienen un jefe asociado (LEFT JOIN):");
            while (resultSet4.next()) {
                System.out.println(resultSet4.getString("nombre") + " " + resultSet4.getString("apellidos"));
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

