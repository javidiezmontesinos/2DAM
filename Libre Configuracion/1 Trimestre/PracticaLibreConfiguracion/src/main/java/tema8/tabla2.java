package tema8;
import java.sql.*;
/**
 * Tabla 2 del tema 8
 * @author javid
 *
 */
public class tabla2 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tiendapc";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Insertar un nuevo departamento indicando su codigo, nombre y presupuesto
            String insertarDepartamentoCodigoNombrePresupuesto = "INSERT INTO departamento (codigo_departamento, nombre, presupuesto) VALUES (?, ?, ?)";
            PreparedStatement statement1 = conexion.prepareStatement(insertarDepartamentoCodigoNombrePresupuesto);
            statement1.setInt(1, 201);
            statement1.setString(2, "Nuevo Departamento 1");
            statement1.setDouble(3, 100000.0); 
            statement1.executeUpdate();
            System.out.println("Nuevo departamento insertado con código, nombre y presupuesto");

            // Insertar un nuevo departamento indicando su nombre y presupuesto
            String insertarDepartamentoNombrePresupuesto = "INSERT INTO departamento (nombre, presupuesto) VALUES (?, ?)";
            PreparedStatement statement2 = conexion.prepareStatement(insertarDepartamentoNombrePresupuesto);
            statement2.setString(1, "Nuevo Departamento 2");
            statement2.setDouble(2, 75000.0); 
            statement2.executeUpdate();
            System.out.println("Nuevo departamento insertado con nombre y presupuesto");

            // Insertar un nuevo departamento indicando su código, nombre, presupuesto y gastos
            String insertarDepartamentoConGastos = "INSERT INTO departamento (codigo_departamento, nombre, presupuesto, gastos) VALUES (?, ?, ?, ?)";
            PreparedStatement statement3 = conexion.prepareStatement(insertarDepartamentoConGastos);
            statement3.setInt(1, 202); 
            statement3.setString(2, "Nuevo Departamento 3");
            statement3.setDouble(3, 120000.0); 
            statement3.setDouble(4, 25000.0);
            statement3.executeUpdate();
            System.out.println("Nuevo departamento insertado con código, nombre, presupuesto y gastos");

            // Insertar un nuevo empleado asociado a uno de los nuevos departamentos
            String insertarEmpleado = "INSERT INTO empleado (codigo_empleado, nif, nombre, apellido1, apellido2, codigo_departamento) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement4 = conexion.prepareStatement(insertarEmpleado);
            statement4.setInt(1, 1001); 
            statement4.setString(2, "12345678A"); 
            statement4.setString(3, "Nuevo"); 
            statement4.setString(4, "Empleado"); 
            statement4.setString(5, "1"); 
            statement4.setInt(6, 201); 
            statement4.executeUpdate();
            System.out.println("Nuevo empleado insertado con código, NIF, nombre, apellidos y código de departamento");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

