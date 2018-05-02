package EntregaPrimeraParte;
//Arbol auto -balanceado
public class AvlTree {

	
	NodoAvl root;
	int height;
	private int nodosVisitados;


	public AvlTree(Comparable o) {

		this.root= new NodoAvl(o);
		this.nodosVisitados=0;
	}
	
	public void resetNodosVisitados() {
		this.nodosVisitados=0;
	}
	
	public int getNodosVisitados() {
		return this.nodosVisitados;
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
		this.nodosVisitados++;
		if (rootAux!=null) {
			int compare= rootAux.getInfo().compareTo(o);
			if(compare==0) return rootAux;
			else if (compare<0) return hasElem(rootAux.getRight(), o);
			else return hasElem(rootAux.getLeft(), o);
		}
		else return null;
	}

	public void insert(Comparable o, Libro l) {
		if (this.root!=null)this.insert(o, root, l);
		else{
			 this.root= new NodoAvl(o);
			 root.setLibro(l);
			 this.nodosVisitados++;
		}
		
	}

	private void insert(Comparable o, NodoAvl nodo, Libro l) {
		this.nodosVisitados++;
		if(nodo.getInfo().compareTo(o)>0) {
			if(nodo.getLeft()!=null){
				this.insert(o, nodo.getLeft(), l);
			}
			else{
				NodoAvl nuevo= new NodoAvl(o);
				nodo.setLeft(nuevo);
				nuevo.setLibro(l);
			}
		}
		else if(nodo.getInfo().compareTo(o)<0) {
			if(nodo.getRight()!=null){
				this.insert(o, nodo.getRight(), l);
  			}
			else{
				NodoAvl nuevo= new NodoAvl(o);
				nodo.setRight(nuevo);
				nuevo.setLibro(l);
			}
		}
		
		nodo.balance();
		
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
