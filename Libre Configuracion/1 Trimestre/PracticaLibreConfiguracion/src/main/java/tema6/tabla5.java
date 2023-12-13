package tema6;
import java.sql.*;
/**
 * Tabla 5 del tema 6
 * @author javid
 *
 */
public class tabla5 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tiendapc";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Numero total de alumnas
            String consultaTotalAlumnas = "SELECT COUNT(*) AS total_alumnas FROM alumnos WHERE genero = 'Femenino'";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaTotalAlumnas);

            if (resultSet1.next()) {
                int totalAlumnas = resultSet1.getInt("total_alumnas");
                System.out.println("Número total de alumnas: " + totalAlumnas);
            }
            System.out.println();

            // Numero de alumnos nacidos en 1999
            String consultaAlumnos1999 = "SELECT COUNT(*) AS alumnos_1999 FROM alumnos WHERE YEAR(fecha_nacimiento) = 1999";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaAlumnos1999);

            if (resultSet2.next()) {
                int alumnos1999 = resultSet2.getInt("alumnos_1999");
                System.out.println("Número de alumnos nacidos en 1999: " + alumnos1999);
            }
            System.out.println();

            // Numero de profesores por departamento con profesores asociados de mayor a menor
            String consultaProfesoresPorDepartamento = "SELECT departamento, COUNT(*) AS cantidad_profesores FROM profesores GROUP BY departamento ORDER BY cantidad_profesores DESC";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaProfesoresPorDepartamento);

            System.out.println("Número de profesores por departamento (solo con profesores):");
            while (resultSet3.next()) {
                String departamento = resultSet3.getString("departamento");
                int cantidadProfesores = resultSet3.getInt("cantidad_profesores");
                System.out.println("Departamento: " + departamento + ", Número de profesores: " + cantidadProfesores);
            }
            System.out.println();

            // Número de profesores por departamento incluyendo aquellos sin profesores asociados
            String consultaProfesoresPorDepartamentoTodos = "SELECT d.nombre_departamento, COUNT(p.id_profesor) AS cantidad_profesores " +
                    "FROM departamentos d LEFT JOIN profesores p ON d.id_departamento = p.id_departamento " +
                    "GROUP BY d.nombre_departamento ORDER BY cantidad_profesores DESC";
            Statement statement4 = conexion.createStatement();
            ResultSet resultSet4 = statement4.executeQuery(consultaProfesoresPorDepartamentoTodos);

            System.out.println("Número de profesores por departamento (incluso sin profesores):");
            while (resultSet4.next()) {
                String nombreDepartamento = resultSet4.getString("nombre_departamento");
                int cantidadProfesores = resultSet4.getInt("cantidad_profesores");
                System.out.println("Departamento: " + nombreDepartamento + ", Número de profesores: " + cantidadProfesores);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
