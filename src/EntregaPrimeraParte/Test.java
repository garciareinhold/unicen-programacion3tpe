package EntregaPrimeraParte;

import java.util.ArrayList;

public class Test {

	public static void main(String[] args) {

//		Herramienta tool= new Herramienta();
//		tool.setColeccion("C:/datasets/dataset1.csv");
//		tool.generarIndice();
//		tool.getIndice().printPreOrder();
//		tool.setSalida("C:/salidas/salida1.csv");
//		tool.VerLibrosXGenero("cine");
		
		Indice generos = new Indice();
		Comparable gen = "Ficcion";
		Comparable gen1 = "Guerra";
		Comparable gen2 = "Bisturi";
		generos.setGenero(gen);
		generos.setGenero(gen1);
		generos.setGenero(gen2);
		generos.mostrarIndice();
		
		
		
		
		
	}

}
