package EntregaPrimeraParte;

import java.util.LinkedList;

public class Genero {

	private Comparable nombre;
	private LinkedList <Libro> libros;
	
	public Genero(Comparable nombre) {
		this.nombre=nombre;
		libros= new LinkedList<Libro>();
	}
	public Genero() {
		this.nombre=null;
		this.libros=null;
	}
	public void setNombre(Comparable nombre) {
		this.nombre=nombre;
	}
	public Comparable getNombre() {
		return this.nombre;
	}
	
	public void agregarLibro(Libro l) {
		libros.add(l);
	}
	
	public LinkedList<Libro> getLibros(){
		return this.libros;
	}
}
