package interfacesgraficas;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JPanel;
//usando metodo constructor para inicializar la ventana
public class Ventana5ConMetodos2 extends JFrame {
    private JPanel panel;

    public Ventana5ConMetodos2() {
        //super("Ventana4");
        inicializarVentana();
        agregarBoton();
    }
    private void inicializarVentana() {
        setSize(300, 300);
        setVisible(true);
        panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);
    }

    private void agregarBoton() {
        JButton botonBienvenido = new JButton("Bienvenido");
        botonBienvenido.setBounds(50, 50, 100, 50); // Posición (x, y) y tamaño (ancho, alto) del botón en relación al panel.
        panel.add(botonBienvenido);
    }

    public static void main(String[] args) {
    	Ventana5ConMetodos2 ventana=new Ventana5ConMetodos2();
    	
    }
}
