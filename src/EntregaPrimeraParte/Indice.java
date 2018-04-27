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
		//this.generos = generos;
		NodoIndice nodo = new NodoIndice(genero);
		agregarGeneroOrdenado(this.generos, nodo);
	}
	
	public void agregarGeneroOrdenado( Vector<NodoIndice> arreglo, NodoIndice dato) {
		 int inicio = 0;
		 int fin = arreglo.size() - 1;
		 if (fin == -1) {
			 arreglo.addElement(dato);
		 }
		 
		 int pos;
		 while (inicio <= fin) {
			 
			 if (inicio == fin ) {
				 //System.out.println(inicio + "Fin->" + fin);
				 if (dato.getGenero().compareTo(arreglo.elementAt(inicio).getGenero()) < 0 ) {
					 arreglo.setElementAt(dato, inicio);
				 }	else {
					 arreglo.add(dato); 
					 inicio = fin + 1;
				 }
			 } else {
				 pos = (inicio+fin) / 2;
				 System.out.println(pos);
				 if ( dato.getGenero().compareTo(arreglo.elementAt(pos).getGenero()) < 0 &&					  
					 dato.getGenero().compareTo(arreglo.elementAt(pos-1).getGenero()) > 0 ) {
					 arreglo.setElementAt(dato, pos);
					 inicio = fin;
				 } else if ( arreglo.elementAt(pos).getGenero().compareTo(dato.getGenero()) < 0 )
			    	 		inicio = pos+1;
			     		else 
			     			fin = pos-1;
		     }
		 } 
		     
	 }
	
	public void mostrarIndice () {		
		for(int i=0;i<this.generos.size();i++) {		
			System.out.println(this.generos.elementAt(i).getGenero());
		}
	}
		 		    
}
	
	

