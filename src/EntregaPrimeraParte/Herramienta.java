package EntregaPrimeraParte;

import java.util.Iterator;
import java.util.LinkedList;

public class Herramienta {

	private CSVReader reader;
	private CSVWritter writter;
	private Abb indice;
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
	
	public Abb getIndice() {
		return this.indice;
	}
	
	public int getNodosVisitados() {
		return this.indice.getNodosVisitados();
	}
	
	public void generarIndice() {
		//Seteo el primer nodo del árbol
		this.indice= new Abb(coleccion.getFirst().getGeneros()[0]);
		//Recorro todos los libros de la coleccion
		Iterator<Libro> itBooks= coleccion.iterator();
		while (itBooks.hasNext()) {
			//Recorro todos sus generos
			Libro libro= itBooks.next();
			String [] generos=libro.getGeneros();
			
			for (int j=0; j<generos.length; j++) {
				//Me fijo en el árbol de indice si tiene el genero 
				NodoArbol aux= indice.getElem(generos[j]);
				if(aux==null) {
					indice.insert(generos[j],libro );
				}
				else aux.setLibro(libro);

			}

		}
	}
	
	public void VerLibrosXGenero(String generoBusqueda) {
		//Me fijo si el genero que me piden existe, si es así genero el archivo de salida
		NodoArbol genero= indice.getElem(generoBusqueda);
		if (genero!=null) writter.generarCSV(genero.getLibros());
		else System.out.println("No se encuentra tal género");
	}
}
