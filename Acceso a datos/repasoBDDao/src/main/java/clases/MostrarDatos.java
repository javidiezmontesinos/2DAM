package clases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {
  public static void main(String[] args) {
    Connection conn = null;
    Statement stmt = null;
    String sql = "SELECT * FROM productos";
    try {
      conn = DriverManager.getConnection(
             "jdbc:mysql://localhost/TiendaPc","root","basket10");
      stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      while (rs.next()) {
        int id = rs.getInt("id");
        String nombreP = rs.getString("nombreProduct");
        String fabricante = rs.getString("Fabricante");
        System.out.println("id: " + id + ", nombreProducto: " + nombreP + ", Fabricante: " + fabricante);
      }
      rs.close();
      conn.close();
      stmt.close();
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
