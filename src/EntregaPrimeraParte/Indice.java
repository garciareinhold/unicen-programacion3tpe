package EntregaPrimeraParte;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Indice {
	
	private Vector<NodoIndice> generos;
	
	public Indice () {
		this.generos = new Vector<NodoIndice>();
	}

	public Vector<NodoIndice> getGeneros() {
		return generos;
	}

	public void setGenero(Comparable genero) {	
		NodoIndice nodo = new NodoIndice(genero);
		//System.out.println(nodo.getGenero());
		agregarGeneroOrdenado(this.generos, nodo);
	}
	
	public void agregarGeneroOrdenado( Vector<NodoIndice> arreglo, NodoIndice dato) {
		 int inicio = 0;
		 int fin = arreglo.size() - 1;
		 if (fin == -1) {
			 arreglo.addElement(dato);
		 }
		  
		 int pos;
		 
		 
		 if (inicio == fin ) {			 
			 if (dato.getGenero().compareTo(arreglo.elementAt(inicio).getGenero()) < 0 ) {
				 arreglo.add(inicio, dato);
			 }	else {
				 arreglo.add(dato); 
				 inicio = fin + 1;
			 }
		 } 
		 
		 while (inicio < fin) {
			 
			 pos = (inicio+fin) / 2;
			 //System.out.println(pos);
			 if (pos != 0) {
				//System.out.println(inicio + "I" + fin + "F");
				//System.out.println(dato.getGenero());
				 if ( dato.getGenero().compareTo(arreglo.elementAt(pos).getGenero()) < 0 &&					  
						 dato.getGenero().compareTo(arreglo.elementAt(pos-1).getGenero()) > 0 ) {
						 arreglo.add(pos, dato);
						 inicio = fin;
				 } else if ( arreglo.elementAt(pos).getGenero().compareTo(dato.getGenero()) < 0 )
		    	 			inicio = pos+1;
			     		else {
			     			fin = pos-1;
			     			if ((fin == inicio) && (dato.getGenero().compareTo(arreglo.elementAt(inicio).getGenero()) < 0)) {
			     				arreglo.add(inicio, dato);
			     			}
			     		} 
			     			
//				 System.out.println(fin);
//				 System.out.println(inicio);
			 } else {
				 //System.out.println(dato.getGenero() + "  " +  pos);
				 if   (this.generos.size() == 2)  {
					 if ( (dato.getGenero().compareTo(arreglo.elementAt(fin).getGenero()) < 0 ) &&
					 	  (dato.getGenero().compareTo(arreglo.elementAt(inicio).getGenero()) > 0 ) ) {
			 			this.generos.add(this.generos.elementAt(fin));
			 			this.generos.setElementAt(dato, fin); 
					 } else {
						 if (dato.getGenero().compareTo(arreglo.elementAt(fin).getGenero()) > 0 ) {
							 this.generos.add(dato); 
						 } else if (dato.getGenero().compareTo(arreglo.elementAt(inicio).getGenero()) < 0 ) {
							 		this.generos.add(inicio, dato);
						 		}
					 }					 
					 inicio = fin;
				 }
				 
			 }
			 
		  
		 }
		 
//		if (dato.getGenero().compareTo(arreglo.elementAt(0).getGenero()) > 0) {
//			System.out.println(dato.getGenero() + "Last");
//			this.generos.add(inicio, dato); 
//		} 
		 
		     
	 }
	
	public void mostrarIndice () {		
		for(int i=0;i<this.generos.size();i++) {		
			System.out.println(this.generos.elementAt(i).getGenero() + " -> " + i);
		}
	}
		 		    
}
	
	

