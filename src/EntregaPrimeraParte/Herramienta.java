package EntregaPrimeraParte;

import java.util.Iterator;
import java.util.LinkedList;

public class Herramienta {

	private CSVReader reader;
	private CSVWritter writter;
	private AvlTree indice;
	LinkedList <Libro> coleccion;
	
	public Herramienta() {
		this.reader= new CSVReader();
		this.writter= new CSVWritter();
	}
	
	public void setColeccion(String path) {
		//Genero una lista vinculada de libros con la lectura del path
		this.coleccion= reader.ReadCsv(path);
	}


	public void setSalida(String path) {
		//Seteo el archivo de salida del writter
		this.writter.setPath(path);
	}
	
	public AvlTree getIndice() {
		return this.indice;
	}
	
	public void generarIndice() {
		//Seteo el primer nodo del árbol
		this.indice= new AvlTree(coleccion.getFirst().getGeneros()[0]);
		//Recorro todos los libros de la coleccion
		Iterator<Libro> itBooks= coleccion.iterator();
		while (itBooks.hasNext()) {
			//Recorro todos sus generos
			Libro libro= itBooks.next();
			String [] generos=libro.getGeneros();
			
			for (int j=0; j<generos.length; j++) {
				//Me fijo en el árbol de indice si tiene el genero 
				NodoAvl aux= indice.hasElem(generos[j]);
				if(aux==null) {
					indice.insert(generos[j],libro );
				}
				else aux.setLibro(libro);

			}

		}
	}
	
	public void VerLibrosXGenero(String generoBusqueda) {
		//Me fijo si el genero que me piden existe, si es así genero el archivo de salida
		NodoAvl genero= indice.hasElem(generoBusqueda);
		if (genero!=null) writter.generarCSV(genero.getLibros());
	}
}
