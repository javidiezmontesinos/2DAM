package conectarmysqlEmpresa;

import java.sql.SQLException;

public class MainEmpresa {
    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost/simulacro1t"; // URL de la base de datos
        String dbUser = "root"; // Usuario de la base de datos
        String dbPassword = "basket10"; // Contraseña del usuario

        try {
            ClienteController controller = new ClienteController(dbURL, dbUser, dbPassword); // Crea una instancia del controlador
            controller.mostrarClientes(); // Llama al método del controlador para mostrar los clientes
            controller.cerrarConexion(); // Llama al método del controlador para cerrar la conexión a la base de datos
        } catch (SQLException e) {
            e.printStackTrace(); // Maneja las excepciones de SQL imprimiendo el error
        }
    }
}

