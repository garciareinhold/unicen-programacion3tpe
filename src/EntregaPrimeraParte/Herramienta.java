package EntregaPrimeraParte;

import java.util.ArrayList;

public class Herramienta {

	private CSVReader reader;
	private CSVWritter writter;
	private Abb indice;
	ArrayList <Libro> coleccion;
	
	public Herramienta() {
		this.reader= new CSVReader();
		this.writter= new CSVWritter();
	}
	
	public void setColeccion(String path) {
		//Genero un arraylist de libros con la lectura del path
		this.coleccion= reader.ReadCsv(path);
	}


	public void setSalida(String path) {
		//Seteo el archivo de salida del writter
		this.writter.setPath(path);
	}
	
	public Abb getIndice() {
		return this.indice;
	}
	
	public void generarIndice() {
		//Seteo el primer nodo del árbol
		this.indice= new Abb(coleccion.get(0).getGeneros()[0]);
		//Recorro todos los libros de la coleccion
		for(int i=0; i<coleccion.size(); i++) {
			//Por cada libro tomo su arreglo de generos
			String [] generos= coleccion.get(i).getGeneros();
			//Recorro todos sus generos
			for (int j=0; j<generos.length; j++) {
				//Me fijo en el árbol de indice si tiene el genero 
				NodoArbol aux= indice.hasElem(generos[j]);
				String nombreLibro=this.coleccion.get(i).getNombre();
				if(aux==null) {
					indice.insert(generos[j],nombreLibro );
				}
				else aux.setNombreLibro(nombreLibro);

			}
		}
	}
	
	public void VerLibrosXGenero(String generoBusqueda) {
		//Me fijo si el genero que me piden existe, si es así genero el archivo de salida
		NodoArbol genero= indice.hasElem(generoBusqueda);
		
		if (genero!=null) writter.generarCSV(genero.getNombreLibros());
	}
}
