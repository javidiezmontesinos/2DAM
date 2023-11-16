package interfacesgraficas;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana7Location extends JFrame {
    private JLabel etiquetaMensaje, etiquetaMensaje1;

    public Ventana7Location() {
        setTitle("Ejemplo con setLocation"); // Ponemos título a la ventana
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Al cerrar la ventana, cerramos la aplicación

        // Creamos el contenedor para los botones
        JPanel panelBotones = new JPanel();

        String[] botones = {"arriba", "abajo", "izquierda", "derecha"};

        for (String botonText : botones) {
            JButton boton = new JButton("Boton " + botonText);
            // Le añadimos el listener para cada botón
            boton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    String textoBoton = ((JButton) e.getSource()).getText();

                    if (textoBoton.equals("Boton arriba")) {
                        // Cambiar la ubicación de la ventana si se pulsó el botón "arriba"
                        setLocation(100, 100); // Cambia las coordenadas según lo desees
                    } else if (textoBoton.equals("Boton abajo")) {
                        // Cambiar la ubicación de la ventana si se pulsó el botón "abajo"
                        setLocation(100, 200); // Cambia las coordenadas según lo desees
                    } else if (textoBoton.equals("Boton izquierda")) {
                        // Cambiar la ubicación de la ventana si se pulsó el botón "izquierda"
                        setLocation(200, 100); // Cambia las coordenadas según lo desees
                    } else if (textoBoton.equals("Boton derecha")) {
                        // Cambiar la ubicación de la ventana si se pulsó el botón "derecha"
                        setLocation(600, 200); // Cambia las coordenadas según lo desees
                    }
                }
            });

            panelBotones.add(boton);
        }

        // Agregamos el layout, en este caso, BorderLayout en el centro
        setLayout(new BorderLayout());
        add(panelBotones, BorderLayout.CENTER);

        pack(); // Ajusta el tamaño de los elementos del JFrame
        setLocation(300, 300); // Establece la ubicación inicial de la ventana
        
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Ventana7Location();
            }
        });
    }
}

