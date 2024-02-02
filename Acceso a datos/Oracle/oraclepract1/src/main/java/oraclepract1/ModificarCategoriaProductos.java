package oraclepract1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class ModificarCategoriaProductos {
    public static void modificarRegistro(int id, String nuevacategoria, String nuevasubcategoria) {
        Connection conexion = CrearTabla.obtenerConexion();
        if (conexion != null) {
            PreparedStatement preparedStatement = null;


            try {
                // Actualizar el registro en la tabla "empresa"
            	String actualizarRegistroSQL = "UPDATE Categorias_Productos SET categoria=?, subcategoria=? WHERE id=?";
            	preparedStatement = conexion.prepareStatement(actualizarRegistroSQL);
            	preparedStatement.setString(1, nuevacategoria);
            	preparedStatement.setString(2, nuevasubcategoria);
            	preparedStatement.setInt(3, id);

            	int filasAfectadas = preparedStatement.executeUpdate();

            	if (filasAfectadas > 0) {
            	    System.out.println("Registro actualizado con éxito.");
            	    System.out.println(id + " , " + nuevacategoria + " , " + nuevasubcategoria);
            	} else {
            	    System.out.println("No se encontró el registro con ID: " + id);
            	}
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (conexion != null) {
                        conexion.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No se pudo establecer la conexión.");
        }     
    }
    public static void main(String[] args) {
        // Ejemplo de uso
    	 modificarRegistro(2, "Alimentacion", "Verduras");
    }
}
