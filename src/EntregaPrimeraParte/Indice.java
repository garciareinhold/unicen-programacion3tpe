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

	public void setGenero(String genero) {
		//this.generos = generos;
		NodoIndice nodo = new NodoIndice(genero);
		
		generos.add(nodo);
		
	}
	
}
