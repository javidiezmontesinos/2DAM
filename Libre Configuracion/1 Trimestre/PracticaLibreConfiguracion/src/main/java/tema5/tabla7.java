package tema5;
import java.sql.*;
/**
 * Tabla 7 del tema 5
 * @author javid
 *
 */
public class tabla7 {

    public static void main(String[] args) {
    	// Conexion con la base de datos
        String url = "jdbc:mysql://localhost:3306/tienda";
        String usuario = "root";
        String contraseña = "basket10";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña)) {
            // Listado con los profesores que no imparten ninguna asignatura
            String consultaProfesoresSinAsignaturas = "SELECT p.* FROM profesores p LEFT JOIN asignaturas_profesores ap ON p.id_profesor = ap.id_profesor WHERE ap.id_asignatura IS NULL";
            Statement statement1 = conexion.createStatement();
            ResultSet resultSet1 = statement1.executeQuery(consultaProfesoresSinAsignaturas);

            System.out.println("Profesores que no imparten ninguna asignatura (LEFT JOIN):");
            while (resultSet1.next()) {
                System.out.println(resultSet1.getString("nombre") + " " + resultSet1.getString("apellidos"));
            }
            System.out.println();

            // Listado con las asignaturas que no tienen un profesor asignado
            String consultaAsignaturasSinProfesor = "SELECT a.* FROM asignaturas a RIGHT JOIN asignaturas_profesores ap ON a.id_asignatura = ap.id_asignatura WHERE ap.id_profesor IS NULL";
            Statement statement2 = conexion.createStatement();
            ResultSet resultSet2 = statement2.executeQuery(consultaAsignaturasSinProfesor);

            System.out.println("Asignaturas que no tienen un profesor asignado (RIGHT JOIN):");
            while (resultSet2.next()) {
                System.out.println(resultSet2.getString("nombre_asignatura"));
            }
            System.out.println();

            // Listado con todos los departamentos que no han impartido asignaturas en ningún curso escolar (LEFT JOIN)
            String consultaDepartamentosSinAsignaturas = "SELECT d.* FROM departamentos d LEFT JOIN asignaturas a ON d.id_departamento = a.id_departamento WHERE a.id_asignatura IS NULL";
            Statement statement3 = conexion.createStatement();
            ResultSet resultSet3 = statement3.executeQuery(consultaDepartamentosSinAsignaturas);

            System.out.println("Departamentos que no han impartido asignaturas en ningún curso escolar (LEFT JOIN):");
            while (resultSet3.next()) {
                System.out.println(resultSet3.getString("nombre_departamento"));
            }
            System.out.println();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
