package EntregaPrimeraParte;

import java.util.Vector;

public class NodoIndice {
	
	private Comparable genero;
	private Vector<Libro> libros;
	
	public NodoIndice (Comparable genero) {
		this.genero = genero;
		libros = new Vector<Libro>();
	}
	
	public Comparable getGenero() {
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
	
	public void setLibro(Libro libro) {
		this.libros.add(libro);
	}
	
}
