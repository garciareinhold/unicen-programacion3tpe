package EntregaPrimeraParte;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

		Herramienta tool= new Herramienta();
		tool.setColeccion("C:/datasets/dataset1.csv");
		tool.generarIndice();
		tool.getIndice().printPreOrder();
		NodoArbol nodo=tool.getIndice().hasElem("drama");
		ArrayList <Integer> prueba=nodo.getPunteroLibro();
		for(int i=0; i<prueba.size(); i++) {
			System.out.println(prueba.get(i));
		}
		//tool.setSalida("C:/salidas/salida1.csv");
		//tool.VerLibrosXGenero("humor");
	}

}
