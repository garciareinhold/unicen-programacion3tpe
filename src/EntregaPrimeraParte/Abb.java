package EntregaPrimeraParte;
import java.util.ArrayList;
import java.util.LinkedList;


public class Abb{
	
	private class NodoArbol {
		
		private Genero info;
		private NodoArbol left;
		private NodoArbol right;
		
		private NodoArbol(Comparable o) {
			info= new Genero(o);
			left=null;
			right=null;
		}
		
		private NodoArbol() {
			info=null;
			left=null;
			right=null;
		}
		
		protected Genero getInfo() {
			return this.info;
		}
		
		protected NodoArbol getLeft() {
			return this.left;
		}
		
		protected NodoArbol getRight() {
			return this.right;
		}
		
		protected void setLeft(NodoArbol left) {
			this.left=left;
		}
		
		protected void setRight(NodoArbol right) {
			this.right=right;
		}
		
	}

	private NodoArbol root;
	private int nodosVisitados;


	public Abb(Comparable o) {

		this.root= new NodoArbol(o);
		this.nodosVisitados=0;
	}

	public boolean isEmpty() {
		return (root==null);
	}

	public Genero getElem(Comparable o) {
		if(!this.isEmpty()) return getElem(this.root, o);
		else return null;
	}

	private Genero getElem(NodoArbol rootAux, Comparable o) {
		this.nodosVisitados++;
		if (rootAux!=null) {
			int compare= rootAux.getInfo().getNombre().compareTo(o);
			if(compare==0) return rootAux.getInfo();
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
			 root.getInfo().agregarLibro(l);
			 this.nodosVisitados++;
		}
		
	}

	private void insert(Comparable o, NodoArbol nodo, Libro l) {
		this.nodosVisitados++;
		if(nodo.getInfo().getNombre().compareTo(o)>0) {
			if(nodo.getLeft()!=null){
				this.insert(o, nodo.getLeft(), l);
			}
			else{
				NodoArbol nuevo= new NodoArbol(o);
				nodo.setLeft(nuevo);
				nuevo.getInfo().agregarLibro(l);
			}
		}
		else if(nodo.getInfo().getNombre().compareTo(o)<0) {
			if(nodo.getRight()!=null){
				this.insert(o, nodo.getRight(), l);
  			}
			else{
				NodoArbol nuevo= new NodoArbol(o);
				nodo.setRight(nuevo);
				nuevo.getInfo().agregarLibro(l);
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
