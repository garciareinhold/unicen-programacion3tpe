package EntregaPrimeraParte;

import java.util.ArrayList;
import java.util.List;

public class Abb{

	NodoArbol root;
	int height;


	public Abb(Comparable o) {

		this.root= new NodoArbol(o);
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
		if (rootAux!=null) {
			int compare= rootAux.getInfo().compareTo(o);
			if(compare==0) return rootAux;
			else if (compare<0) return hasElem(rootAux.getRight(), o);
			else return hasElem(rootAux.getLeft(), o);
		}
		else return null;
	}

	public void insert(Comparable o, int punteroLibro) {
		this.root= insert(o, root, punteroLibro);
	}

	private NodoArbol insert(Comparable o, NodoArbol nodo, int punteroLibro) {
		if(nodo==null) nodo= new NodoArbol(o);
		else if(nodo.getInfo().compareTo(o)>0) {
			nodo.setLeft(insert(o, 	nodo.getLeft(), punteroLibro));
		}
		else if(nodo.getInfo().compareTo(o)<0) {
			nodo.setRight(insert(o, nodo.getRight(), punteroLibro));
		}
		else;
		
		nodo.setPunteroLibro(punteroLibro);
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
