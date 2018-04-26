package EntregaPrimeraParte;

import java.util.LinkedList;

public class NodoAvl {

	Comparable info;
	LinkedList<Libro> libros;
	NodoAvl left;
	NodoAvl right;
	int height;
	NodoAvl father;
	
	public NodoAvl(Comparable o) {
		info=o;
		left=null;
		right=null;
		libros= new LinkedList<Libro>();
		height= 1;
	}
	
	public Comparable getInfo() {
		return this.info;
	}
	
	public NodoAvl getLeft() {
		return this.left;
	}
	
	public NodoAvl getRight() {
		return this.right;
	}
	
	public NodoAvl moveRight() {
		NodoAvl aux= this.left;
		
		this.left=aux.getRight();
		this.calculateHeight();
		
		aux.setRight(this);
		aux.calculateHeight();
		
		aux.setFather(this.father);
		
		return aux;	
	}
	
	private void setFather(NodoAvl father) {
		this.father= father;
		
	}
	
	public NodoAvl moveLeft() {
		NodoAvl aux= this.right;
		
		this.right=aux.getLeft();
		this.calculateHeight();
		
		aux.setLeft(this);
		aux.calculateHeight();
				
		return aux;	
	}

	private NodoAvl getFather() {
		return null;
	}

	private void calculateHeight() {

		this.height=1;
		if (this.left!=null) this.height+=this.left.getHeight();
		if(this.right!=null) this.height+=this.right.getHeight();
	}

	private int getHeight() {
		return this.height;
	}

	public void setLeft(NodoAvl left) {
		this.left=left;
	}
	
	public void setRight(NodoAvl right) {
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
	
	private int getBalance() {
		int balance=0;
		if(this.left!=null) balance+=this.left.getHeight();
		if(this.right!=null) balance+=this.right.getHeight();
		return balance;
	}

	public NodoAvl balance() {
		this.calculateHeight();
		int balance= this.getBalance();
		if(balance<1) {
			if(this.left.getBalance()<0) {
				this.left=this.left.moveLeft();
			}
			return this.moveRight();
		}
		else if (balance < -1) {
			if (this.right.getBalance()>0) {
				this.right= this.right.moveRight();
			}
			return this.moveLeft();
		}
		return this;
	}
}
