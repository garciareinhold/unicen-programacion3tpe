package EntregaPrimeraParte;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {

	final static int NOMBRE= 0;
	final static int GENERO=3;
	
	public ArrayList<Libro> ReadCsv(String archivo){
	    
        String line = "";
        String cvsSplitBy = ",";
        ArrayList<Libro> coleccion= new ArrayList<Libro>();
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

