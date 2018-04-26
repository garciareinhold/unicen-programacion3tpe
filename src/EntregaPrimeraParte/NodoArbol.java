package EntregaPrimeraParte;

import java.util.LinkedList;

public class NodoArbol {
	
	Comparable info;
	LinkedList<Libro> libros;
	NodoArbol left;
	NodoArbol right;
	
	public NodoArbol(Comparable o) {
		info=o;
		left=null;
		right=null;
		libros= new LinkedList<Libro>();
	}
	
	public Comparable getInfo() {
		return this.info;
	}
	
	public NodoArbol getLeft() {
		return this.left;
	}
	
	public NodoArbol getRight() {
		return this.right;
	}
	
	public void setLeft(NodoArbol left) {
		this.left=left;
	}
	
	public void setRight(NodoArbol right) {
		this.right=right;
	}

	public void setValor(Comparable info) {
		this.info=info;
	}
	
	public void setLibro(Libro l) {
		this.libros.add(l);
	}
	
	public LinkedList<Libro> getLibros() {
		return this.libros;
	}
	
	

}
