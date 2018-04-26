package EntregaPrimeraParte;
//Arbol auto -balanceado
public class AvlTree {

	
	NodoAvl root;
	int height;


	public AvlTree(Comparable o) {

		this.root= new NodoAvl(o);
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


	public NodoAvl hasElem(Comparable o) {
		if(!this.isEmpty()) return hasElem(this.root, o);
		else return null;
	}

	private NodoAvl hasElem(NodoAvl rootAux, Comparable o) {
		if (rootAux!=null) {
			int compare= rootAux.getInfo().compareTo(o);
			if(compare==0) return rootAux;
			else if (compare<0) return hasElem(rootAux.getRight(), o);
			else return hasElem(rootAux.getLeft(), o);
		}
		else return null;
	}

	public void insert(Comparable o, Libro l) {
		this.root= insert(o, root, l);
	}

	private NodoAvl insert(Comparable o, NodoAvl nodo, Libro l) {
		if(nodo==null) {
			nodo= new NodoAvl(o);
			nodo.setLibro(l);
			return nodo;
		} 
		else if(nodo.getInfo().compareTo(o)>0) {
			nodo.setLeft(insert(o, 	nodo.getLeft(), l));
		}
		else if(nodo.getInfo().compareTo(o)<0) {
			nodo.setRight(insert(o, nodo.getRight(), l));
		}
		
		return nodo.balance();
	}
	
	public void printPreOrder() {
		printPreOrder(this.root);
	}

	private void printPreOrder(NodoAvl root) {
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
