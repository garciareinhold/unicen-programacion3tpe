package EntregaPrimeraParte;

import java.util.Iterator;
import java.util.LinkedList;

public class BookFinder {

	private CSVReader reader;
	private CSVWritter writter;
	private Abb indice;
	LinkedList <Libro> coleccion;
	
	public BookFinder() {
		this.reader= new CSVReader();
		this.writter= new CSVWritter();
		this.indice=null;
		this.coleccion= null;
	}
	
	public void setColeccion(String path) {
		//Genero una lista vinculada de libros con la lectura del path
		this.coleccion= reader.ReadCsv(path);
	}


	public void setSalida(String path) {
		//Seteo el archivo de salida del writter
		this.writter.setPath(path);
	}
	
	public int getNodosVisitados() {
		return this.indice.getNodosVisitados();
	}
		
	public void generarIndice() {
		//Seteo el root del árbol
		this.indice= new Abb(coleccion.getFirst().getGeneros()[0]);
		//Recorro todos los libros de la coleccion
		Iterator<Libro> itBooks= coleccion.iterator();
		while (itBooks.hasNext()) {
			//Recorro todos sus generos
			Libro libro= itBooks.next();
			String [] generos=libro.getGeneros();
			
			for (int j=0; j<generos.length; j++) {
				//Me fijo en el árbol de indice si tiene el genero en generos[j], si lo tiene le agrego el libro, sino lo inserto
				Genero aux= indice.getElem(generos[j]);
				if(aux==null) {
					indice.insert(generos[j],libro );
				}
				else aux.agregarLibro(libro);

			}
		}
	}
	
	public void verLibrosGenero(String generoBusqueda) {
		this.indice.resetNodosVisitados();
		//Me fijo si el genero que me piden existe, si es así genero el archivo de salida
		Genero genero= indice.getElem(generoBusqueda);
		if (genero!=null) writter.generarCSV(genero.getLibros());
		else System.out.println("No se encuentra tal género");
	}

	public void imprimirGeneros() {
		this.indice.printPreOrder();
	}
}
