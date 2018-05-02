package EntregaPrimeraParte;

import java.util.ArrayList;
import java.util.List;

public class Abb{

	NodoArbol root;
	private int nodosVisitados;


	public Abb(Comparable o) {

		this.root= new NodoArbol(o);
		this.nodosVisitados=0;
	}

	public boolean isEmpty() {
		return (root==null);
	}

	public Comparable getRoot() {
		if (this.isEmpty()) {
			return null;
		}
		else return this.root.getInfo();
	}


	public NodoArbol hasElem(Comparable o) {
		if(!this.isEmpty()) return hasElem(this.root, o);
		else return null;
	}

	private NodoArbol hasElem(NodoArbol rootAux, Comparable o) {
		this.nodosVisitados++;
		if (rootAux!=null) {
			int compare= rootAux.getInfo().compareTo(o);
			if(compare==0) return rootAux;
			else if (compare<0) return hasElem(rootAux.getRight(), o);
			else return hasElem(rootAux.getLeft(), o);
		}
		else return null;
	}
	
	public int getNodosVisitados() {
		return this.nodosVisitados;
	}
	
	public void resetNodosVisitados() {
		this.nodosVisitados=0;
	}

	public void insert(Comparable o, Libro l) {
		this.root= insert(o, root, l);
	}

	private NodoArbol insert(Comparable o, NodoArbol nodo, Libro l) {
		this.nodosVisitados++;
		if(nodo==null) {
			nodo= new NodoArbol(o);
			nodo.setLibro(l);
		} 
		else if(nodo.getInfo().compareTo(o)>0) {
			nodo.setLeft(insert(o, 	nodo.getLeft(), l));
		}
		else if(nodo.getInfo().compareTo(o)<0) {
			nodo.setRight(insert(o, nodo.getRight(), l));
		}
		
		return nodo;
	}
	
	public void printPreOrder() {
		printPreOrder(this.root);
	}

	private void printPreOrder(NodoArbol root) {
		if(root != null) {
			System.out.print(root.getInfo() + "  ");
			printPreOrder(root.getLeft());
			printPreOrder(root.getRight());
		}
		else {
			System.out.print(" - ");
		}
	} 

}
