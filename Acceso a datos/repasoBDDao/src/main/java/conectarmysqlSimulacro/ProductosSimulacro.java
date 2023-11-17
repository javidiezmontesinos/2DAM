package conectarmysqlSimulacro;

public class ProductosSimulacro {
    private int id;
    private String nif;
    private String nombre;
    private String edad;
	private String descripcion;
	private String fabricante;

   

    public ProductosSimulacro(int id, String nombre, String descripcion, String fabricante) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fabricante = fabricante;
	}

	public int getId() {
        return id;
    }

    public String getNif() {
        return nif;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEdad() {
        return edad;
    }

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
}
