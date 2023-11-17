package conectarmysqlSimulacro;
import java.util.List;
import java.sql.Connection;

public class ProductosView {
    // Método para mostrar los clientes en la vista
    public void mostrarProductos(List<ProductosSimulacro> productos) {
        for (ProductosSimulacro producto : productos) {
            System.out.println("ID: " + producto.getId()); // Imprime el ID del cliente
            System.out.println("Nombre: " + producto.getNombre()); // Imprime el NIF del cliente
            System.out.println("Descripcion: " + producto.getDescripcion()); // Imprime el nombre del cliente
            System.out.println("Fabricante: " + producto.getFabricante()); // Imprime la edad del cliente
            System.out.println(); // Imprime una línea en blanco para separar los clientes
        }
    }
}
