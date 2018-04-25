package EntregaPrimeraParte;

import java.util.ArrayList;
import java.util.List;

public class NodoArbol {
	
	Comparable info;
	ArrayList<Integer> punterosLibros;
	NodoArbol left;
	NodoArbol right;
	
	public NodoArbol(Comparable o) {
		info=o;
		left=null;
		right=null;
		punterosLibros= new ArrayList<Integer>();
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
	
	public void setPunteroLibro(int l) {
		this.punterosLibros.add(l);
	}
	
	public ArrayList<Integer> getPunteroLibro() {
		return this.punterosLibros;
	}
	
	

}
