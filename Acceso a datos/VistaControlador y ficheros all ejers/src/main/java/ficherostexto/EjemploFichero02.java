package ficherostexto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class EjemploFichero02 {
	
	
	public static void main(String[] args) {
		try {
			String fichero="c:\\prueba\\malaga.txt";
			BufferedWriter bw = new BufferedWriter(new FileWriter(fichero,false));
			// false va a permitir que no se queda en memoria todas las veces
			// que ejecuto esta clase, con lo que se almacenaria en el mismo fichero, de nuevo los mismos
			// datos duplicados
	
			
			bw.write("naranja\n");
			bw.write("mango\n");
			bw.write("chirimoya\n");
			bw.write("fresa\n");
			System.out.println("Fichero creado");
			
			bw.close();
		} catch (IOException ioe) {
			System.out.println("No se ha podido escribir en el fichero");
		}
	}
}
