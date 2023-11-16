package interfacesgraficas;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class Ventana5ConMetodos4 extends JFrame {
    private JPanel panel;
   
   //inicializamos la ventana se podria haber realizado con un constructor
    private void inicializarVentana() {
        setSize(300, 300);
        setVisible(true);
        panel = new JPanel();
        panel.setLayout(null);
        getContentPane().add(panel);
    }

    // agregamos el boton y al mismo tiempo al pulsar crea una nueva ventana con un texto
    private void agregarBoton(String nombreBoton, int x, int y) {
        JButton boton = new JButton(nombreBoton);
        boton.setBounds(x, y, 100, 50); // Posición (x, y) y tamaño (ancho, alto) del botón en relación al panel.
        panel.add(boton);
        boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame ventanaNueva=new JFrame("Nueva ventana");
				ventanaNueva.setSize(200, 200);
				ventanaNueva.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				ventanaNueva.add(new JLabel("has pulsado el botón "+nombreBoton));
				ventanaNueva.setVisible(true);
				
			}
		});
        
        
    }
//añadimos botones usando un bucle
    
    public static void main(String[] args) {
    	Ventana5ConMetodos4 ventana=new Ventana5ConMetodos4();
    	ventana.inicializarVentana();
    	int y=50;
    	for (int i=1; i<4;i++) {
    	  		ventana.agregarBoton("Boton "+i,50,y);
    		y=y+50;
    	}
    	
    	
    	
    
    
    }
}
