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


	public NodoArbol getElem(Comparable o) {
		if(!this.isEmpty()) return getElem(this.root, o);
		else return null;
	}

	private NodoArbol getElem(NodoArbol rootAux, Comparable o) {
		this.nodosVisitados++;
		if (rootAux!=null) {
			int compare= rootAux.getInfo().compareTo(o);
			if(compare==0) return rootAux;
			else if (compare<0) return getElem(rootAux.getRight(), o);
			else return getElem(rootAux.getLeft(), o);
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
		if (this.root!=null) {
			this.insert(o, root, l);
		}
		else{
			 this.root= new NodoArbol (o);
			 root.setLibro(l);
			 this.nodosVisitados++;
		}
		
	}

	private void insert(Comparable o, NodoArbol nodo, Libro l) {
		this.nodosVisitados++;
		if(nodo.getInfo().compareTo(o)>0) {
			if(nodo.getLeft()!=null){
				this.insert(o, nodo.getLeft(), l);
			}
			else{
				NodoArbol nuevo= new NodoArbol(o);
				nodo.setLeft(nuevo);
				nuevo.setLibro(l);
			}
		}
		else if(nodo.getInfo().compareTo(o)<0) {
			if(nodo.getRight()!=null){
				this.insert(o, nodo.getRight(), l);
  			}
			else{
				NodoArbol nuevo= new NodoArbol(o);
				nodo.setRight(nuevo);
				nuevo.setLibro(l);
			}
		}
		
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
