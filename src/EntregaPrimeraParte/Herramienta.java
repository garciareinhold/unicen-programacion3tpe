package EntregaPrimeraParte;

import java.util.ArrayList;

public class Herramienta {

	private CSVReader reader;
	private CSVWritter writter;
	private Indice indice;
	ArrayList<Libro> coleccion;

	public Herramienta() {
		this.reader = new CSVReader();
		this.writter = new CSVWritter();
	}

	public void setColeccion(String path) {
		// Genero un arraylist de libros con la lectura del path
		this.coleccion = reader.ReadCsv(path);
	}

	public void setSalida(String path) {
		// Seteo el archivo de salida del writter
		this.writter.setPath(path);
	}

	public int generarIndice() {
		// Seteo el primer nodo del árbol
		int comparaciones = 0;
		this.indice = new Indice();
		// Recorro todos los libros de la coleccion
		for (int i = 0; i < coleccion.size(); i++) {
			// Por cada libro tomo su arreglo de generos
			String[] generos = coleccion.get(i).getGeneros();
			// Recorro todos sus generos
			for (int j = 0; j < generos.length; j++) {
				Comparable gen = generos[j];	
				comparaciones = comparaciones + this.indice.agregarLibroPorGenero(gen, coleccion.get(i));
			}

		}
		return comparaciones;
	}

	public void mostrarIndice() {
		this.indice.mostrarIndice();
	}

}
