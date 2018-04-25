package EntregaPrimeraParte;

import java.util.ArrayList;
import java.util.List;

public class NodoArbol {
	
	Comparable info;
	ArrayList<String> nombresLibros;
	NodoArbol left;
	NodoArbol right;
	
	public NodoArbol(Comparable o) {
		info=o;
		left=null;
		right=null;
		nombresLibros= new ArrayList<String>();
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
	
	public void setNombreLibro(String l) {
		this.nombresLibros.add(l);
	}
	
	public ArrayList<String> getNombreLibros() {
		return this.nombresLibros;
	}
	
	

}
