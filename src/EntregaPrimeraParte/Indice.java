package EntregaPrimeraParte;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class Indice {
	
	private Vector<NodoIndice> generos;
	
	public Indice () {
		this.generos = new Vector<NodoIndice>();
	}

//	public Vector<NodoIndice> getGeneros() {
//		return generos;
//	}

	public void setGenero(Comparable genero) {	
		NodoIndice nodo = new NodoIndice(genero);
		//System.out.print(nodo.getGenero() + "\n"); 
		if (this.generos.size() == 0) {
			this.generos.add(nodo);			
		} else if (this.generos.size() == 1) {
			   	if (nodo.getGenero().compareTo(this.generos.elementAt(0).getGenero()) < 0) {
			   		this.generos.add(0, nodo);
			   	} else {
			   		this.generos.add(nodo); 
			   	} 
		} else {
			agregarGeneroOrdenado(this.generos, nodo);
			
		}
		//this.mostrarIndice();
	}
	
	public void agregarGeneroOrdenado( Vector<NodoIndice> arreglo, NodoIndice dato) {
	
		
        int izquierda=0;
        int derecha = arreglo.size() - 1;
        int centro;
        //busqueda binaria de la posicion de insercion
        while (izquierda <= derecha) 
        {
            centro = ((izquierda + derecha)/2);
                //if (auxiliar <= v[centro])
            //System.out.println(izquierda);
                if ( dato.getGenero().compareTo( arreglo.elementAt(centro).getGenero() ) < 0 )    
                	derecha = centro-1;
                else
                    izquierda = centro+1;
        }
        
        System.out.println("A insertar ->" + izquierda);
        arreglo.add(izquierda, dato);
		          
    } 
		
	
	
		 
//		if (dato.getGenero().compareTo(arreglo.elementAt(0).getGenero()) > 0) {
//			
//			this.generos.add(inicio, dato); 
//		} 
		 
		     
	 
	
	public void mostrarIndice () {		
		for(int i=0;i<this.generos.size();i++) {		
			System.out.println(this.generos.elementAt(i).getGenero() + " -> " + i);
		}
	}
		 		    
}
	
	

