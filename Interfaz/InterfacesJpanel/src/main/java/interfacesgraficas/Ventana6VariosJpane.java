package interfacesgraficas;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana6VariosJpane extends JFrame {
	private JPanel panel;

    public Ventana6VariosJpane() {
    	setTitle("Examen Practico");
		setSize(400, 300);
		setVisible(true);
		panel = new JPanel();
		panel.setLayout(null);
		getContentPane().add(panel);
		
        
        JPanel panelBotones = new JPanel();
      
        for (int i = 1; i <= 3; i++) {
            JButton boton = new JButton("Boton " + i);
            
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	
                	String textoBoton = ((JButton) e.getSource()).getText();
                	 
                	}
            });
            panelBotones.add(boton);
        }
        
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.NORTH);
      
        pack();
       
        setVisible(true);
    }

    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(new Runnable() {
    	    public void run() {
    	        new Ventana6VariosJpane();
    	    }
    	});

    }
}


