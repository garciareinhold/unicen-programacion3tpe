package EntregaPrimeraParte;

import java.util.Vector;

public class NodoIndice {
	
	private String genero;
	Vector<Libro> libros;
	
	public NodoIndice (String genero) {
		this.genero = genero;
		libros = new Vector<Libro>();
	}
	
	public String getGenero() {
		return genero;
	}
	
	public void agregarLibro (Libro libro) {
		this.libros.addElement(libro);
	}
	
	public Vector<Libro> getLibros() {
		return libros;
	}
	
	public void setLibros(Vector<Libro> libros) {
		this.libros = libros;
	}
	
}
