package tema5;
import java.sql.*;
/**
 * Tabla 4 del tema 5**
 * @author javid
 *
 */
public class tabla4 {

    public static void main(String[] args) {
    	//Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado con el nombre de cada cliente y el nombre y apellido de su representante de ventas (SQL-92)
            String consultaClientesRepresentantesSQL1 = "SELECT c.nombre AS nombre_cliente, r.nombre AS nombre_representante, r.apellido AS apellido_representante " +
                    "FROM clientes c, representantes r WHERE c.id_representante = r.id_representante";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaClientesRepresentantesSQL1);

            System.out.println("Clientes y sus representantes (SQL-92):");
            while (resultSet1.next()) {
                String nombreCliente = resultSet1.getString("nombre_cliente");
                String nombreRepresentante = resultSet1.getString("nombre_representante");
                String apellidoRepresentante = resultSet1.getString("apellido_representante");

                System.out.println("Cliente: " + nombreCliente + ", Representante: " + nombreRepresentante + " " + apellidoRepresentante);
            }
            System.out.println();

            // Listado de nombres de los clientes que hayan realizado pagos junto con el nombre de sus representantes de ventas (SQL-99 INNER JOIN)
            String consultaClientesConPagosRepresentantesSQL2 = "SELECT c.nombre AS nombre_cliente, r.nombre AS nombre_representante " +
                    "FROM clientes c INNER JOIN pagos p ON c.id_cliente = p.id_cliente " +
                    "INNER JOIN representantes r ON c.id_representante = r.id_representante";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaClientesConPagosRepresentantesSQL2);

            System.out.println("Clientes con pagos y sus representantes (SQL-99 INNER JOIN):");
            while (resultSet2.next()) {
                String nombreCliente = resultSet2.getString("nombre_cliente");
                String nombreRepresentante = resultSet2.getString("nombre_representante");

                System.out.println("Cliente: " + nombreCliente + ", Representante: " + nombreRepresentante);
            }
            System.out.println();

            // Listado de nombres de los clientes que no hayan realizado pagos junto con el nombre de sus representantes de ventas (SQL-99 LEFT JOIN)
            String consultaClientesSinPagosRepresentantesSQL2 = "SELECT c.nombre AS nombre_cliente, r.nombre AS nombre_representante " +
                    "FROM clientes c LEFT JOIN pagos p ON c.id_cliente = p.id_cliente " +
                    "INNER JOIN representantes r ON c.id_representante = r.id_representante " +
                    "WHERE p.id_cliente IS NULL";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaClientesSinPagosRepresentantesSQL2);

            System.out.println("Clientes sin pagos y sus representantes (SQL-99 LEFT JOIN):");
            while (resultSet3.next()) {
                String nombreCliente = resultSet3.getString("nombre_cliente");
                String nombreRepresentante = resultSet3.getString("nombre_representante");

                System.out.println("Cliente: " + nombreCliente + ", Representante: " + nombreRepresentante);
            }
            System.out.println();

            // Listadp de nombres de los clientes que han hecho pagos y el nombre de sus representantes junto con la ciudad de la oficina a la que pertenece el representante (SQL-99 INNER JOIN)
            String consultaClientesPagosOficinasSQL2 = "SELECT c.nombre AS nombre_cliente, r.nombre AS nombre_representante, o.ciudad AS ciudad_oficina " +
                    "FROM clientes c INNER JOIN pagos p ON c.id_cliente = p.id_cliente " +
                    "INNER JOIN representantes r ON c.id_representante = r.id_representante " +
                    "INNER JOIN oficinas o ON r.id_oficina = o.id_oficina";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaClientesPagosOficinasSQL2);

            System.out.println("Clientes con pagos, sus representantes y la ciudad de la oficina (SQL-99 INNER JOIN):");
            while (resultSet4.next()) {
                String nombreCliente = resultSet4.getString("nombre_cliente");
                String nombreRepresentante = resultSet4.getString("nombre_representante");
                String ciudadOficina = resultSet4.getString("ciudad_oficina");

                System.out.println("Cliente: " + nombreCliente + ", Representante: " + nombreRepresentante + ", Ciudad Oficina: " + ciudadOficina);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
