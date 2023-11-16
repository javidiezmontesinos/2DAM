package interfacesgraficas;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ejercicio3JframeJOptionPane {

    public static void main(String[] args) {
        JFrame ventana = new JFrame("Ventana con Botón");
    	String nombre="Alberto";
		
        ventana.setSize(400, 200);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //cierra la ventana y la aplicacion

        JButton boton = new JButton("Haz clic aquí"); //instanciamos el botón
        ventana.add(boton); //añadimos el boton

        boton.addActionListener(new ActionListener() 
        {
            public void actionPerformed(ActionEvent e) 
               {
            	//al asociarlo aparece en el mismo sitio
            	String nombre = JOptionPane.showInputDialog(ventana, 
        				"Dime tu nombre", "Datos personales", 
        				JOptionPane.QUESTION_MESSAGE);
                
            }
        });
        ventana.setVisible(true);
    }
}
