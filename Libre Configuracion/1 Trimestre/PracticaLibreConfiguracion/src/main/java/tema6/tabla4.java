package tema6;
import java.sql.*;
/**
 * Tabla 5 del tema 6
 * @author javid
 *
 */
public class tabla4 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tiendapc";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Cantidad de empleados en la compañia
            String consultaEmpleados = "SELECT COUNT(*) AS cantidad_empleados FROM empleados";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaEmpleados);

            if (resultSet1.next()) {
                int cantidadEmpleados = resultSet1.getInt("cantidad_empleados");
                System.out.println("Cantidad de empleados en la compañía: " + cantidadEmpleados);
            }
            System.out.println();

            // Cantidad de clientes por pais
            String consultaClientesPorPais = "SELECT pais, COUNT(*) AS cantidad_clientes FROM clientes GROUP BY pais";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaClientesPorPais);

            System.out.println("Cantidad de clientes por país:");
            while (resultSet2.next()) {
                String pais = resultSet2.getString("pais");
                int cantidadClientes = resultSet2.getInt("cantidad_clientes");
                System.out.println("País: " + pais + ", Cantidad de clientes: " + cantidadClientes);
            }
            System.out.println();

            // Pago medio en 2009
            String consultaPagoMedio2009 = "SELECT AVG(monto_pago) AS pago_medio_2009 FROM pagos WHERE YEAR(fecha_pago) = 2009";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaPagoMedio2009);

            if (resultSet3.next()) {
                double pagoMedio2009 = resultSet3.getDouble("pago_medio_2009");
                System.out.println("Pago medio en 2009: " + pagoMedio2009);
            }
            System.out.println();

            // Cantidad de pedidos por estado, ordenado de forma descendente por el numero de pedidos
            String consultaPedidosPorEstado = "SELECT estado, COUNT(*) AS cantidad_pedidos FROM pedidos GROUP BY estado ORDER BY cantidad_pedidos DESC";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaPedidosPorEstado);

            System.out.println("Cantidad de pedidos por estado (orden descendente por número de pedidos):");
            while (resultSet4.next()) {
                String estado = resultSet4.getString("estado");
                int cantidadPedidos = resultSet4.getInt("cantidad_pedidos");
                System.out.println("Estado: " + estado + ", Cantidad de pedidos: " + cantidadPedidos);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

