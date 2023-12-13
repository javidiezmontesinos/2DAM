package tema6;
import java.sql.*;
/**
 * Tabla 3 del tema 6
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
            // Suma del presupuesto de todos los departamentos
            String consultaSumaPresupuesto = "SELECT SUM(presupuesto) AS suma_presupuesto FROM departamentos";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaSumaPresupuesto);

            if (resultSet1.next()) {
                double sumaPresupuesto = resultSet1.getDouble("suma_presupuesto");
                System.out.println("Suma del presupuesto de todos los departamentos: " + sumaPresupuesto);
            }
            System.out.println();

            // Media del presupuesto de todos los departamentos
            String consultaMediaPresupuesto = "SELECT AVG(presupuesto) AS media_presupuesto FROM departamentos";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaMediaPresupuesto);

            if (resultSet2.next()) {
                double mediaPresupuesto = resultSet2.getDouble("media_presupuesto");
                System.out.println("Media del presupuesto de todos los departamentos: " + mediaPresupuesto);
            }
            System.out.println();

            // Valor min del presupuesto de todos los departamentos
            String consultaMinPresupuesto = "SELECT MIN(presupuesto) AS min_presupuesto FROM departamentos";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaMinPresupuesto);

            if (resultSet3.next()) {
                double minPresupuesto = resultSet3.getDouble("min_presupuesto");
                System.out.println("Valor mínimo del presupuesto de todos los departamentos: " + minPresupuesto);
            }
            System.out.println();

            // Nombre y presupuesto del departamento con menor presupuesto
            String consultaDepartamentoMenorPresupuesto = "SELECT nombre, presupuesto FROM departamentos WHERE presupuesto = (SELECT MIN(presupuesto) FROM departamentos)";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaDepartamentoMenorPresupuesto);

            if (resultSet4.next()) {
                String nombreDepartamento = resultSet4.getString("nombre");
                double presupuestoDepartamento = resultSet4.getDouble("presupuesto");
                System.out.println("Departamento con menor presupuesto: " + nombreDepartamento + ", Presupuesto: " + presupuestoDepartamento);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

