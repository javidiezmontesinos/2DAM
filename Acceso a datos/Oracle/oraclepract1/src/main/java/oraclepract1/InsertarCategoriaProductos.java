package oraclepract1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;


public class InsertarCategoriaProductos {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;


        try {
            // Registrar el driver JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");


            // Establecer la conexión con la base de datos
            String url = "jdbc:oracle:thin:@localhost:1521:xe";
            String usuario = "SYSTEM";
            String contrasena = "basket10";
            conn = DriverManager.getConnection(url, usuario, contrasena);


            // Iniciar la transacción
            conn.setAutoCommit(false);


            // Crear el objeto Empresa con los datos a insertar
            
            /*int id = 1;
            String categoria = "Informatica";
            String subcategoria = "Portatiles";*/
            int id = 3;
            String categoria = "Informatica";
            String subcategoria = "Portatiles";
            

            // Insertar el objeto en la tabla empresa
            String sql = "INSERT INTO Categorias_Productos (id, categoria, subcategoria) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            stmt.setString(2, categoria);
            stmt.setString(3, subcategoria);
            stmt.executeUpdate();


            // Mostrar todos los datos de la tabla empresa
            sql = "SELECT * FROM Categorias_Productos";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int id_empresa = rs.getInt("id");
                String nombre_empresa = rs.getString("categoria");
                String pais_empresa = rs.getString("subcategoria");
                System.out.println("ID: " + id_empresa + " | Categoria: " + categoria + " | Subcategoria: " + subcategoria);
            }


            // Hacer commit de la transacción
            conn.commit();


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            // Si ocurre algún error, hacer rollback de la transacción
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            e.printStackTrace();
        } finally {
            // Cerrar la conexión y los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
