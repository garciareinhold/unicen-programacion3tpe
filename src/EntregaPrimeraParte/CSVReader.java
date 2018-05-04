package EntregaPrimeraParte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;

public class CSVReader {

	final static int NOMBRE= 0;
	final static int GENERO=3;
	
	public LinkedList<Libro> ReadCsv(String archivo){
	    //Leo linea por linea del archivo generando los libros con su nombre y un arreglo de generos,
		//los agregamos a la lista vinculada y la retornamos
        String line = "";
        String cvsSplitBy = ",";
        LinkedList<Libro> coleccion= new LinkedList<Libro>();
        //Usamos un contador para tomar desde el primer libro y no los nombres de las "columnas"
        int contador=0;
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {

            while ((line = br.readLine()) != null) {
            	
            	if(contador>=1) {
            		String[] items = line.split(cvsSplitBy);
                    Libro libro= new Libro(items[NOMBRE], items[GENERO]);
                    coleccion.add(libro);
            	}
            	contador++;
            }
            	
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return coleccion;
        
    }
    
    
}

